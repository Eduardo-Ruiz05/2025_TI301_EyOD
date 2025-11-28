
package tema3.estructurasNoLineales.recursividad;

import static tema3.estructurasNoLineales.recursividad.RecursionLineal.linearSum;


public class RecursionTest {

    
    public static void main(String[] args) {
        int[] array1 = {2, 1, 0, 6, 8, 10};
        System.out.println("caso 1: (2+1+0+6) = " + linearSum(array1, 4));
        
        int[] array2 = {0, 1, 1, 2, 3, 5, 8, 11};
        System.out.println("\ncaso 2: (0+1+1+2+3+5+8+11) = "+linearSum(array2, 8));
        
        int[] array3 = {98, 78, 69, 93, 100, 78, 80, 85};
        System.out.println("\ncaso 3: promedio de las primeras 4 calificaciones \n" 
                + linearSum(array3, 4)/4);
        //Resultado esperado: 84 (sin mostrar decimal)
    }
    
}
