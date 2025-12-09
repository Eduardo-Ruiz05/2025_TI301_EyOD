/*
    * ITESS TICS AGOSTO DICIEMBRE 2025
    * ESTRUCTURAS Y ORGANIZACIÓN DE DATOS
    * DOCENTE: FRANCISCO JAVIER MONTECILLO PUENTE
    * INTENTO DE PROGRAMADOR: EDUARDO RUIZ AGUILAR
    * EMAIL: eduardo.ruizaguilar.50@gmail.com
    * DESCRIPCIÓN:
    * Se muestra un par de ejemplos de HashMap junto a su funcionamiento.
    * FECHA: 09/DICIEMBRE/2025
    */
package tema4.ordenamiento;

import java.util.HashMap;
import java.util.Map;

public class EjemplosHashMap {
    public static void main(String[] args) {
        //EJEMPLO 1
        // Crear un HashMap para gestionar inventario de productos
        HashMap<String, Integer> inventario = new HashMap<>();
        
        // Agregar productos al inventario
        inventario.put("Laptop", 15);
        inventario.put("Mouse", 50);
        inventario.put("Teclado", 30);
        inventario.put("Monitor", 20);
        inventario.put("Impresora", 8);
        
        System.out.println("=== INVENTARIO DE PRODUCTOS ===");
        
        // Recorrer e imprimir el inventario
        for (Map.Entry<String, Integer> producto : inventario.entrySet()) {
            System.out.println("Producto: " + producto.getKey() + 
                             ", Cantidad: " + producto.getValue());
        }
        
        // Actualizar cantidad de un producto
        inventario.put("Laptop", inventario.get("Laptop") - 3);
        System.out.println("\nDespués de vender 3 Laptops:");
        System.out.println("Laptops en stock: " + inventario.get("Laptop"));
        
        // Verificar existencia de producto
        String productoBuscado = "Tablet";
        if (inventario.containsKey(productoBuscado)) {
            System.out.println(productoBuscado + " está en inventario");
        } else {
            System.out.println(productoBuscado + " NO está en inventario");
        }
        
        // Eliminar un producto
        inventario.remove("Impresora");
        System.out.println("\nTamaño del inventario después de eliminar: " + 
                          inventario.size());
        
        //EJEMPLO 2
        // HashMap con objeto personalizado como clave
        HashMap<Estudiante, Double> calificaciones = new HashMap<>();
        
        // Crear estudiantes
        Estudiante est1 = new Estudiante("A001", "Carlos Pérez", 20);
        Estudiante est2 = new Estudiante("A002", "María Gómez", 21);
        Estudiante est3 = new Estudiante("A003", "Juan Rodríguez", 22);
        
        // Asignar calificaciones
        calificaciones.put(est1, 8.5);
        calificaciones.put(est2, 9.2);
        calificaciones.put(est3, 7.8);
        
        System.out.println("=== CALIFICACIONES DE ESTUDIANTES ===");
        
        // Mostrar todas las calificaciones
        for (Map.Entry<Estudiante, Double> entry : calificaciones.entrySet()) {
            System.out.println("Estudiante: " + entry.getKey() + 
                             ", Calificación: " + entry.getValue());
        }
        
        // Buscar estudiante por ID (creando nuevo objeto con mismo ID)
        Estudiante estudianteBuscado = new Estudiante("A002", "", 0);
        if (calificaciones.containsKey(estudianteBuscado)) {
            System.out.println("\nCalificación de María: " + 
                            calificaciones.get(estudianteBuscado));
        }
        
        // Actualizar calificación
        calificaciones.put(est1, 9.0);
        System.out.println("\nCalificación actualizada de Carlos: " + 
                          calificaciones.get(est1));
        
        // Usar métodos útiles de HashMap
        System.out.println("\n=== MÉTODOS ÚTILES ===");
        System.out.println("¿Está vacío? " + calificaciones.isEmpty());
        System.out.println("Total de estudiantes: " + calificaciones.size());
        System.out.println("¿Contiene calificación 9.2? " + 
                          calificaciones.containsValue(9.2));
        
        // Limpiar el HashMap
        calificaciones.clear();
        System.out.println("Después de clear(), tamaño: " + calificaciones.size());
    }
}

class Estudiante {
    private String id;
    private String nombre;
    private int edad;
    
    public Estudiante(String id, String nombre, int edad) {
    this.id = id;
    this.nombre = nombre;
    this.edad = edad;
    }
    
    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    
    @Override
    public String toString() {
        return nombre + " (ID: " + id + ", Edad: " + edad + ")";
    }
    
    // IMPORTANTE: Para usar objetos como clave, debemos sobreescribir
    // hashCode() y equals()
    @Override
    public int hashCode() {
        return id.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Estudiante that = (Estudiante) obj;
        return id.equals(that.id);
    }
}
