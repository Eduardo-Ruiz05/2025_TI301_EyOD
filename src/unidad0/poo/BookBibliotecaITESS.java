/*
* ITESS TICS AGOSTO DICIEMBRE 2025
* ESTRUCTURAS Y ORGANIZACIÓN DE DATOS
* DOCENTE: FRANCISCO JAVIER MONTECILLO FUENTES
* INTENTO DE PROGRAMADOR: EDUARDO RUIZ AGUILAR
* EMAIL: eduardo.ruizaguilar.50@gmail.com
* DESCRIPCIÓN: Diseñar el sistema de biblioteca ITESS
* Clases: Usuarios, Libros } Biblioteca
Usuarios: hereda una interfaz, 
* FECHA: 23/SEPTIEMBRE/2025
*/

//Composición: que incluye atributos de otras clases, objetos, etc.
package unidad0.poo;


public class BookBibliotecaITESS implements BookInterface {
    
    private String título;
    private String author;
    private int quantity;

    public BookBibliotecaITESS(String título, String author, int quantity) {
        this.título = título;
        this.author = author;
        this.quantity = quantity;
    }
    
    @Override
    public void lend() {
        this.quantity =- 1;
    }

    @Override
    public void returnBack() {
        this.quantity =+ 1;
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    /*
    * Características de Interfaces
    *
    * Solo métodos
    * Se puede asignar a una clase mas no crear una clase
    * No tiene código (No atributos)
    * Todos sus metodos son públicos
    *
    * Datos:
    * Conjuntos de hechos, números, palabras u otra información útil.
    *
    * Información:
    * Interpretación de los datos basado en su contexto.
    *
    * Interfaz:
    * conjunto de métodos abstractos y variables constantes, 
    * especificando qué deben hacer las clases que la implementen, 
    * pero no cómo lo deben hacer
    *
    * Estructura de Datos:
    * Colección de datos que se caracterizan por su organizacion y 
    * por las operaciones que se definen en ellos.
    */

    @Override
    public int getQuantity() {
        return 0;
    }

    @Override
    public String getTítulo() {
        return null;
    }

    @Override
    public String getAuthor() {
        return null;
    }

    @Override
    public void addBook(int quantity) {
    }

    
}
