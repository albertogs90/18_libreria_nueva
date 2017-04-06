package javabeans;

/**
 * Created by USUARIO on 03/04/2017.
 */

public class Libro {
    private String titulo;
    private String isbn;
    private double precio;

    public Libro(String titulo, String isbn, double precio) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
