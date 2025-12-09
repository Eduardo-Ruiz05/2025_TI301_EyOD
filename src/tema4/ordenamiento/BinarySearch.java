/*
* ITESS TICS AGOSTO DICIEMBRE 2025
* ESTRUCTURAS Y ORGANIZACIÓN DE DATOS
* DOCENTE: FRANCISCO JAVIER MONTECILLO PUENTE
* INTENTO DE PROGRAMADOR: EDUARDO RUIZ AGUILAR
* EMAIL: eduardo.ruizaguilar.50@gmail.com
* DESCRIPCIÓN: 
* Dado un arreglo aleatorio de 1 millón de valores, ordenarlos y aplicar 
* binary search para encontrar un valor (target).
* FECHA: 09/DICIEMBRE/2025
*/
package tema4.ordenamiento;

import java.util.Random;
import static tema4.ordenamiento.BurbujaQuickSort.estaOrdenado;
import static tema4.ordenamiento.BurbujaQuickSort.quickSortOptimizado;

public class BinarySearch {
    public static void main(String[] args) {
        // Tamaño del arreglo: 1,000,000 de elementos
        final int TAMANIO = 1000000;
        int[] datos = new int[TAMANIO];
        Random random = new Random();
        
        System.out.println("Generando " + TAMANIO + " números aleatorios...");
        
        // Llenar el arreglo con números aleatorios entre 0 y 10,000,000
        for (int i = 0; i < TAMANIO; i++) {
            datos[i] = random.nextInt(10000000);
        }
        
        System.out.println("Arreglo generado. Iniciando ordenamiento...");
        //System.out.println("ADVERTENCIA: Este proceso puede tardar MUCHAS HORAS o DÍAS.");
        //System.out.println("Considera reducir el tamaño del arreglo para pruebas.");
        System.out.println("Presiona Ctrl+C para cancelar.\n");
        
        // Medir el tiempo de ejecución
        long inicio = System.currentTimeMillis();
        
        // Llamar al método de ordenamiento
        //ordenamientoBurbuja(datos);
        quickSortOptimizado(datos, 0, TAMANIO-1);
        long fin = System.currentTimeMillis();
        long tiempoEjecucion = fin - inicio;
        
        // Verificar si el arreglo está ordenado
        boolean ordenado = estaOrdenado(datos);
        
        System.out.println("\n==========================================");
        System.out.println("Resultados del ordenamiento:");
        System.out.println("Tiempo total: " + tiempoEjecucion + " milisegundos");
        System.out.println("Tiempo total: " + (tiempoEjecucion / 1000.0) + " segundos");
        System.out.println("Tiempo total: " + (tiempoEjecucion / 60000.0) + " minutos");
        System.out.println("¿Arreglo ordenado correctamente? " + ordenado);
        
        // Realizar la búsqueda
        int idx = binarySearchPersonalizado(datos, 77777);
        if (idx >= 0) {
            System.out.println("Target " + 77777 + ": encontrado en índice " + idx);
        } else {
            System.out.println("Target " + 77777 + ": no encontrado (inserción en " + (-idx-1) + ")");
        }
        
    }
    
    /**
     * Implementación personalizada de búsqueda binaria
     */
    public static int binarySearchPersonalizado(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int iteraciones = 0;
        
        while (left <= right) {
            iteraciones++;
            int mid = left + (right - left) / 2;  // Evita overflow
            
            if (arr[mid] == target) {
                System.out.println("Búsqueda completada en " + iteraciones + " iteraciones");
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println("Búsqueda completada en " + iteraciones + " iteraciones");
        return -(left + 1);  // Convención igual a Arrays.binarySearch()
    }
    
    /**
     * Encuentra la primera ocurrencia de un elemento en arreglo ordenado
     */
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;  // Seguir buscando a la izquierda
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    /**
     * Encuentra la última ocurrencia de un elemento en arreglo ordenado
     */
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;  // Seguir buscando a la derecha
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}
