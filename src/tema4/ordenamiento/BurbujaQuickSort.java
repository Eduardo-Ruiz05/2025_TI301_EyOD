/*
    * ITESS TICS AGOSTO DICIEMBRE 2025
    * ESTRUCTURAS Y ORGANIZACIÓN DE DATOS
    * DOCENTE: FRANCISCO JAVIER MONTECILLO PUENTE
    * INTENTO DE PROGRAMADOR: EDUARDO RUIZ AGUILAR
    * EMAIL: eduardo.ruizaguilar.50@gmail.com
    * DESCRIPCIÓN: 
    * Ejemplos y comparación de algoritmos de ordenamiento (burbuja y quickSsort)
    * FECHA: 09/DICIEMBRE/2025
    */
package tema4.ordenamiento;

import java.util.Random;

public class BurbujaQuickSort {

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
        
        System.out.println("Arreglo generado. Iniciando ordenamiento por burbuja...");
        //System.out.println("ADVERTENCIA: Este proceso puede tardar MUCHAS HORAS o DÍAS.");
        //System.out.println("Considera reducir el tamaño del arreglo para pruebas.");
        System.out.println("Presiona Ctrl+C para cancelar.\n");
        
        // Medir el tiempo de ejecución
        long inicio = System.currentTimeMillis();
        
        // Llamar al método de ordenamiento por burbuja
        //ordenamientoBurbuja(datos);
        quickSort(datos, 0, TAMANIO-1);
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
        
        // Mostrar algunos elementos para verificar
        System.out.println("\nPrimeros 10 elementos del arreglo ordenado:");
        for (int i = 0; i < 10 && i < TAMANIO; i++) {
            System.out.print(datos[i] + " ");
        }
        
        System.out.println("\n\nÚltimos 10 elementos del arreglo ordenado:");
        for (int i = TAMANIO - 10; i < TAMANIO; i++) {
            if (i >= 0) {
                System.out.print(datos[i] + " ");
            }
        }
    }

     /**
     * Método que implementa el algoritmo de ordenamiento por burbuja
     * Optimizado con una bandera para detectar si ya está ordenado
     * 
     * @param arreglo El arreglo a ordenar
     */
    public static void ordenamientoBurbuja(int[] arreglo) {
        int n = arreglo.length;
        boolean intercambiado;
        
        for (int i = 0; i < n - 1; i++) {
            intercambiado = false;
            
            // Los últimos i elementos ya están en su lugar
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambiar arreglo[j] y arreglo[j+1]
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    intercambiado = true;
                }
            }
            
            // Si no hubo intercambios en la pasada, el arreglo ya está ordenado
            if (!intercambiado) {
                break;
            }
            
            // Mostrar progreso cada 10000 iteraciones para no saturar la consola
            if (i % 10000 == 0) {
                System.out.println("Progreso: " + (i * 100.0 / n) + "% completado");
            }
        }
    }
    
    /**
     * Método auxiliar para verificar si un arreglo está ordenado
     * 
     * @param arreglo El arreglo a verificar
     * @return true si el arreglo está ordenado, false en caso contrario
     */
    public static boolean estaOrdenado(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            if (arreglo[i] > arreglo[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Método principal que ordena un arreglo usando QuickSort
     * 
     * @param arreglo El arreglo a ordenar
     * @param inicio Índice inicial del subarreglo
     * @param fin Índice final del subarreglo
     */
    public static void quickSort(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            // Particionar el arreglo y obtener el índice del pivote
            int indicePivote = particionar(arreglo, inicio, fin);
            
            // Ordenar recursivamente los elementos antes y después del pivote
            quickSort(arreglo, inicio, indicePivote - 1);
            quickSort(arreglo, indicePivote + 1, fin);
        }
    }
    
    /**
     * Versión optimizada de QuickSort con selección de pivote aleatoria
     * para evitar el peor caso O(n²)
     * 
     * @param arreglo El arreglo a ordenar
     * @param inicio Índice inicial del subarreglo
     * @param fin Índice final del subarreglo
     */
    public static void quickSortOptimizado(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            // Seleccionar un pivote aleatorio para evitar el peor caso
            int indicePivoteAleatorio = inicio + (int)(Math.random() * (fin - inicio + 1));
            
            // Intercambiar el pivote aleatorio con el último elemento
            int temp = arreglo[indicePivoteAleatorio];
            arreglo[indicePivoteAleatorio] = arreglo[fin];
            arreglo[fin] = temp;
            
            // Particionar y ordenar recursivamente
            int indicePivote = particionar(arreglo, inicio, fin);
            quickSortOptimizado(arreglo, inicio, indicePivote - 1);
            quickSortOptimizado(arreglo, indicePivote + 1, fin);
        }
    }
    
    /**
     * Método auxiliar para particionar el arreglo
     * 
     * @param arreglo El arreglo a particionar
     * @param inicio Índice inicial del subarreglo
     * @param fin Índice final del subarreglo
     * @return La posición final del pivote
     */
    private static int particionar(int[] arreglo, int inicio, int fin) {
        // Elegir el último elemento como pivote
        int pivote = arreglo[fin];
        int i = inicio - 1; // Índice del elemento más pequeño
        
        for (int j = inicio; j < fin; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arreglo[j] <= pivote) {
                i++;
                // Intercambiar arreglo[i] y arreglo[j]
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }
        
        // Intercambiar arreglo[i+1] y arreglo[fin] (colocar el pivote en su posición correcta)
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[fin];
        arreglo[fin] = temp;
        
        return i + 1;
    }
}
