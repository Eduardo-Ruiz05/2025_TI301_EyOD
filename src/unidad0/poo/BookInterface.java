/*
* ITESS TICS AGOSTO DICIEMBRE 2025
* ESTRUCTURAS Y ORGANIZACIÓN DE DATOS
* DOCENTE: FRANCISCO JAVIER MONTECILLO FUENTES
* INTENTO DE PROGRAMADOR: EDUARDO RUIZ AGUILAR
* EMAIL: eduardo.ruizaguilar.50@gmail.com
* DESCRIPCIÓN: 
* Interfaz de libro (book)
* FECHA: 23/SEPTIEMBRE/2025
*/
package unidad0.poo;


public interface BookInterface {
    void lend();   //Prestar
    void returnBack();
    boolean isAvailable();
    
    int getQuantity();
    String getTítulo();
    String getAuthor();
    void addBook(int quantity);
}
