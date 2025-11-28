
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
}
