/*
* ITESS TICS AGOSTO DICIEMBRE 2025
* ESTRUCTURAS Y ORGANIZACIÓN DE DATOS
* DOCENTE: FRANCISCO JAVIER MONTECILLO PUENTE
* INTENTO DE PROGRAMADOR: EDUARDO RUIZ AGUILAR
* EMAIL: eduardo.ruizaguilar.50@gmail.com
* DESCRIPCIÓN:
* Se muestra un par de ejemplos de HashSet junto a su funcionamiento.
* FECHA: 09/DICIEMBRE/2025
*/
package tema4.ordenamiento;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class EjemplosHashSet {
    public static void main(String[] args) {
        // EJEMPLO 1
        // Crear un HashSet para almacenar nombres de usuarios únicos
        HashSet<String> usuarios = new HashSet<>();
        
        // Agregar usuarios (no permite duplicados)
        System.out.println("=== REGISTRO DE USUARIOS ÚNICOS ===\n");
        
        usuarios.add("carlos123");
        usuarios.add("maria_g");
        usuarios.add("juan_rod");
        usuarios.add("ana_2023");
        
        System.out.println("Usuarios registrados inicialmente: " + usuarios);
        
        // Intentar agregar duplicados
        boolean agregado1 = usuarios.add("carlos123");
        boolean agregado2 = usuarios.add("pedro_new");
        
        System.out.println("\n¿Se agregó 'carlos123' (duplicado)? " + agregado1);
        System.out.println("¿Se agregó 'pedro_new' (nuevo)? " + agregado2);
        
        System.out.println("\nUsuarios después de intentar agregar duplicados: " + usuarios);
        
        // Verificar existencia
        System.out.println("\n=== VERIFICACIONES ===");
        System.out.println("¿Existe 'maria_g'? " + usuarios.contains("maria_g"));
        System.out.println("¿Existe 'usuario_falso'? " + usuarios.contains("usuario_falso"));
        
        // Recorrer con Iterator
        System.out.println("\n=== RECORRIENDO CON ITERATOR ===");
        Iterator<String> iterator = usuarios.iterator();
        while (iterator.hasNext()) {
            System.out.println("Usuario: " + iterator.next());
        }
        
        // Recorrer con for-each (más común)
        System.out.println("\n=== RECORRIENDO CON FOR-EACH ===");
        for (String usuario : usuarios) {
            System.out.println("Usuario activo: " + usuario);
        }
        
        // Eliminar un usuario
        usuarios.remove("ana_2023");
        System.out.println("\nDespués de eliminar 'ana_2023': " + usuarios);
        
        // Tamaño y limpieza
        System.out.println("\nTotal de usuarios únicos: " + usuarios.size());
        usuarios.clear();
        System.out.println("Después de clear(), ¿está vacío? " + usuarios.isEmpty());
        
        // EJEMPLO 2
        System.out.println("=== SISTEMA DE ARTÍCULOS CON ETIQUETAS ===\n");
        
        // Crear artículos
        Articulo articulo1 = new Articulo(1, "Programación en Java");
        Articulo articulo2 = new Articulo(2, "Machine Learning Básico");
        Articulo articulo3 = new Articulo(3, "Estructuras de Datos");
        
        // Agregar etiquetas (HashSet elimina automáticamente duplicados)
        articulo1.agregarEtiquetas("java", "programación", "oop", "tutorial");
        articulo1.agregarEtiquetas("java", "programación"); // Duplicados ignorados
        
        articulo2.agregarEtiquetas("python", "ai", "machine learning", "tutorial");
        
        articulo3.agregarEtiquetas("java", "estructuras", "algoritmos", "programación");
        
        // Mostrar artículos
        System.out.println(articulo1);
        System.out.println(articulo2);
        System.out.println(articulo3);
        
        // Operaciones de conjunto entre artículos
        System.out.println("\n=== OPERACIONES DE CONJUNTO ===");
        
        // Etiquetas comunes entre artículo 1 y 3
        HashSet<String> comunes = articulo1.etiquetasComunes(articulo3);
        System.out.println("Etiquetas comunes entre Art1 y Art3: " + comunes);
        
        // Verificar si un artículo tiene cierta etiqueta
        System.out.println("\nArt1 tiene etiqueta 'java'? " + articulo1.tieneEtiqueta("java"));
        System.out.println("Art2 tiene etiqueta 'java'? " + articulo2.tieneEtiqueta("java"));
        
        // Ejemplo de unión de etiquetas (todos los tags únicos)
        HashSet<String> todasEtiquetas = new HashSet<>();
        todasEtiquetas.addAll(articulo1.getEtiquetas());
        todasEtiquetas.addAll(articulo2.getEtiquetas());
        todasEtiquetas.addAll(articulo3.getEtiquetas());
        
        System.out.println("\nTodas las etiquetas únicas del sistema: " + todasEtiquetas);
        System.out.println("Total de etiquetas únicas: " + todasEtiquetas.size());
        
        // Ejemplo: buscar artículos con cierta etiqueta
        System.out.println("\n=== ARTÍCULOS POR ETIQUETA ===");
        String etiquetaBuscada = "tutorial";
        System.out.println("Artículos con etiqueta '" + etiquetaBuscada + "':");
        
        Articulo[] articulos = {articulo1, articulo2, articulo3};
        for (Articulo art : articulos) {
            if (art.tieneEtiqueta(etiquetaBuscada)) {
                System.out.println("  - " + art);
            }
        }
        
        // Diferencia de conjuntos
        System.out.println("\n=== DIFERENCIA DE ETIQUETAS ===");
        HashSet<String> soloEnArt1 = new HashSet<>(articulo1.getEtiquetas());
        HashSet<String> etiquetasArt3 = articulo3.getEtiquetas();
        soloEnArt1.removeAll(etiquetasArt3);
        
        System.out.println("Etiquetas solo en Art1 (no en Art3): " + soloEnArt1);
    }
}

class Articulo {
    private int id;
    private String titulo;
    private HashSet<String> etiquetas;
    
    public Articulo(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.etiquetas = new HashSet<>();
    }
    
    public void agregarEtiquetas(String... nuevasEtiquetas) {
        etiquetas.addAll(Arrays.asList(nuevasEtiquetas));
    }
    
    public boolean tieneEtiqueta(String etiqueta) {
        return etiquetas.contains(etiqueta);
    }
    
    public HashSet<String> getEtiquetas() {
        return new HashSet<>(etiquetas); // Retorna copia para evitar modificación externa
    }
    
    public HashSet<String> etiquetasComunes(Articulo otro) {
        HashSet<String> comunes = new HashSet<>(this.etiquetas);
        comunes.retainAll(otro.etiquetas);
        return comunes;
    }
    
    @Override
    public String toString() {
        return "Artículo #" + id + ": " + titulo + " | Etiquetas: " + etiquetas;
    }
}
