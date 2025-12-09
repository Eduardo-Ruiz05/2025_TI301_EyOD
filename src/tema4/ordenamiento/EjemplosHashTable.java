/*
* ITESS TICS AGOSTO DICIEMBRE 2025
* ESTRUCTURAS Y ORGANIZACIÓN DE DATOS
* DOCENTE: FRANCISCO JAVIER MONTECILLO PUENTE
* INTENTO DE PROGRAMADOR: EDUARDO RUIZ AGUILAR
* EMAIL: eduardo.ruizaguilar.50@gmail.com
* DESCRIPCIÓN:
* Se muestra un par de ejemplos de HashTable junto a su funcionamiento.
* FECHA: 09/DICIEMBRE/2025
*/
package tema4.ordenamiento;

import java.util.Enumeration;
import java.util.Hashtable;

public class EjemplosHashTable {
    public static void main(String[] args) throws InterruptedException {
        // EJEMPLO 1
        // Crear un HashTable para diccionario español-inglés
        Hashtable<String, String> diccionario = new Hashtable<>();
        
        // Agregar palabras (HashTable NO permite claves o valores null)
        diccionario.put("casa", "house");
        diccionario.put("perro", "dog");
        diccionario.put("gato", "cat");
        diccionario.put("libro", "book");
        diccionario.put("agua", "water");
        
        System.out.println("=== DICCIONARIO ESPAÑOL-INGLÉS ===");
        
        // Traducir palabras
        String palabra = "perro";
        System.out.println(palabra + " en inglés: " + diccionario.get(palabra));
        
        // Mostrar todas las traducciones usando Enumeration
        System.out.println("\n=== LISTA COMPLETA ===");
        Enumeration<String> claves = diccionario.keys();
        while (claves.hasMoreElements()) {
            String clave = claves.nextElement();
            System.out.println(clave + " -> " + diccionario.get(clave));
        }
        
        // Intentar agregar null (generará NullPointerException)
        try {
            diccionario.put(null, "something");  // ERROR
        } catch (NullPointerException e) {
            System.out.println("\nError: HashTable no permite claves null");
        }
        
        // Verificar si contiene una clave
        System.out.println("\n¿Contiene 'gato'? " + diccionario.containsKey("gato"));
        System.out.println("¿Contiene 'bird'? " + diccionario.containsValue("bird"));
        
        // Reemplazar un valor
        diccionario.put("libro", "textbook");  // Reemplaza "book" por "textbook"
        System.out.println("\n'libro' ahora significa: " + diccionario.get("libro"));
        
        // EJEMPLO 2
        // HashTable es thread-safe, útil para acceso concurrente
        Hashtable<String, Integer> contadorVisitas = new Hashtable<>();
        
        // Inicializar contadores
        contadorVisitas.put("home", 0);
        contadorVisitas.put("about", 0);
        contadorVisitas.put("contact", 0);
        
        System.out.println("=== CONTADOR DE VISITAS (Thread-Safe) ===\n");
        
        // Crear múltiples hilos que incrementan contadores
        Thread[] hilos = new Thread[5];
        
        for (int i = 0; i < hilos.length; i++) {
            final int threadId = i;
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    // Incrementar contadores de forma segura
                    synchronized(contadorVisitas) {
                        contadorVisitas.put("home", contadorVisitas.get("home") + 1);
                        contadorVisitas.put("about", contadorVisitas.get("about") + 1);
                        contadorVisitas.put("contact", contadorVisitas.get("contact") + 1);
                    }
                    
                    // Otra forma thread-safe (sin synchronized explícito)
                    // contadorVisitas.compute("home", (k, v) -> v + 1);
                }
                System.out.println("Hilo " + threadId + " completado");
            });
        }
        
        // Iniciar todos los hilos
        for (Thread hilo : hilos) {
            hilo.start();
        }
        
        // Esperar a que todos terminen
        for (Thread hilo : hilos) {
            hilo.join();
        }
        
        // Mostrar resultados finales
        System.out.println("\n=== RESULTADOS FINALES ===");
        System.out.println("Visitas a home: " + contadorVisitas.get("home"));
        System.out.println("Visitas a about: " + contadorVisitas.get("about"));
        System.out.println("Visitas a contact: " + contadorVisitas.get("contact"));
        
        // Verificar que la suma sea correcta (5 hilos × 1000 iteraciones × 3 páginas)
        int totalEsperado = 5 * 1000 * 3;
        int totalReal = contadorVisitas.get("home") + 
                       contadorVisitas.get("about") + 
                       contadorVisitas.get("contact");
        System.out.println("\nTotal esperado: " + totalEsperado);
        System.out.println("Total real: " + totalReal);
        System.out.println("¿Correcto? " + (totalEsperado == totalReal));
    }
    
}
