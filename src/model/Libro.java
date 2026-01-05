   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author luisr
 */
public class Libro {
    private int idLibro;
    private String titulo;
    private String autor;
    private String categoria;
    private int stock;
    private LocalDate fechaPublicacion;
    private String descripcion;
    private String isbn;

    public Libro() {
        this.idLibro = 0;
        this.titulo = "";
        this.autor = "";
        this.categoria = "";
        this.stock = 0;
        this.fechaPublicacion = LocalDate.now();
        this.descripcion = "";
        this.isbn = "";
    }

    public Libro(int idLibro, String titulo, String autor, String categoria, int stock, LocalDate fechaPublicacion, String descripcion, String isbn) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.stock = stock;
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = descripcion;
        this.isbn = isbn;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int inventario) {
        this.stock = inventario;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", titulo=" + titulo + ", autor=" + autor + ", categoria=" + categoria + ", inventario=" + stock + ", fechaPublicacion=" + fechaPublicacion + ", descripcion=" + descripcion + ", isbn=" + isbn + '}';
    }
    
}
