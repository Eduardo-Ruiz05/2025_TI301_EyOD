
package unidad0.poo;


public class Book {
    private String titulo;
    private String autor;

    public Book() {
    }

    public Book(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public void hojearLibro(){
        
    }

    @Override
    public String toString() {
        return "Book{" + "titulo=" + titulo + ", autor=" + autor + '}';
    }
    
    
    
}
