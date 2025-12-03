
package tema3.estructurasNoLineales.recursividad;


public class RecursionLineal {
    
    /*
    * Descripción: Dado un arreglo de enteros, suma los primeros n elementos.
    * Se usa recursividad para sumar el valor en la posición n-1 hasta
    * el valor en la posición 0.
    * retorna: int r
    */
    public static int linearSum(int [] data, int n) {
        // Comprueba si n es el primer elemento del arreglo (el último en sumar)
        if(n == 0)
            return 0;   // retorna 0 ya que no queda nada que sumar 
        else
            return linearSum(data, n - 1) + data[n-1];  
            // En cada recursividad se le resta 1 a n para recorrer el arreglo
            // hacia atrás, además de sumar el próximo return con el actual 
            // (el valor en la posición n-1)
    }
    
    /*
    * Descripción: Calcula el valor de x a la n-écima potencia 
    * (para enteros no negativos).
    * retorna: double r.
    */
    public static double powerBad(double x, int n) {
        if(n == 0)
            return 1;   //todo número positivo elevado a la 0 es igual a 1
        else
            return x * powerBad(x, n-1); //recur n veces (multiplica x n veces)
    }
    
    /*
    * Descripción: Calcula el valor de x a la n-écima potencia (n >= 0)
    * en lugar de hacer recur n veces, la cantidad de veces que
    * se hará recur nuevamente se reducirá a la mitad por cada recur.
    * retorna: double result.
    */
    public static double powerGood(double x, int n) {
        if(n == 0)
            return 1;   //todo número positivo elevado a la 0 es igual a 1
        
        else{
            double partial = powerGood(x, n/2); //recur con n a la mitad,

            double result = partial * partial; //se eleva n/2 ó k
            
            if(n % 2 == 1)
                result *= x;   //si n es impar entonces se suma 1 al exponente
            
            return result;
        }
    }
    
    /*
    * Descripción: Genera la serie fibonacci en la posición n (forma 
    * ineficiente)(index desde 0).
    *
    * retorna: long F(n)
    */
    public static long fibonacciBad(int n) {
        if(n <= 1)
            return n;   //la posición 0 y 1 de la serie es 1
        else
            return fibonacciBad(n-2) + fibonacciBad(n-1);
                    //suma el valor anterior a n con el anterior a ese mismo
    }
    
    /*
    * Descripción: Genera un par de valores de la serie fibonacci en la posición
    * n y n-1. Si n > 1: se hace recur disminuyendo n en 1 y guardando ese valor
    * en el long temporal, se usará posteriormente para encontrar
    * el valor F(n) sumando ambas posiciones de temp
    * retorna: long[] {F(n), F(n-1)}
    */
    public static long[] fibonacciGood(int n) {
        if(n <= 1){
            long[] answer = {n,0};  
            return answer;
        } else{
            long[] temp = fibonacciGood(n-1);
            long[] answer = {temp[0] + temp[1], temp[0]};
            return answer;
        }
    }
}

