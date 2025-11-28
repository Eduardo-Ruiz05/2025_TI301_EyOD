/*
* ITESS TICS AGOSTO DICIEMBRE 2025
* ESTRUCTURAS Y ORGANIZACIÓN DE DATOS
* DOCENTE: FRANCISCO JAVIER MONTECILLO PUENTE
* INTENTO DE PROGRAMADOR: EDUARDO RUIZ AGUILAR
* EMAIL: eduardo.ruizaguilar.50@gmail.com
* DESCRIPCIÓN PROBLEMA: 
* Dado una longitud L & Major Tick Lenght. Calcular la regla
* FECHA: 19/NOVIEMBRE/2025
*/
package tema3.estructurasNoLineales;


public class BinarySearch {

    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] datos = {2,4,5,7,8,9,12,14,17,19,22,25,27,28,33,37};
        System.out.println(binarySearch(datos,22,8,12));
    }

    /**
     * Returns true if the target value is found in the indicated portion of the data array.
     * This search only considers the array portion from data[low] to data[high] inclusive.
     * @param data
     * @param target
     * @param low
     * @param high
     * @return
     */

public static boolean binarySearch(int[] data, int target, int low, int high) {
    if (low > high)
        return false;    // interval empty; no match
    else {
        int mid = (low + high) / 2;
        if (target == data[mid])
            return true;    // found a match
        else if (target < data[mid])
            return binarySearch(data, target, low, mid - 1);   // recur left of the middle
        else
            return binarySearch(data, target, mid + 1, high);   // recur right of the middle
    }
}
}
