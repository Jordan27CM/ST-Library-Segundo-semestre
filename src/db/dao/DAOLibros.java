/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.dao;

import db.Conexion;
import java.util.ArrayList;
import model.Libro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Jorda
 */
public class DAOLibros {

    private Conexion conexion;

    public DAOLibros(Conexion conn) {
        this.conexion = conn;
    }

    public void agregar(Libro libro) throws SQLException {
        String query = ""
                + "INSERT INTO libros (isbn, titulo, autor, categoria, stock, descripcion) "
                + "VALUES("
                + "'" + libro.getIsbn() + "', "
                + "'" + libro.getTitulo() + "', "
                + "'" + libro.getAutor() + "', "
                + "'" + libro.getCategoria() + "', "
                + "'" + libro.getStock()+ "', "
                + "'" + libro.getDescripcion() + "'"
                + ")";
        conexion.ejecutar(query);
    }

    public void eliminar(int id) throws SQLException {
        String query = "DELETE FROM libros WHERE id = " + id;
        conexion.ejecutar(query);
    }

    public void modificar(Libro libro) throws SQLException {
        String query = ""
                + "UPDATE libros "
                + "SET "
                + "isbn = '" + libro.getIsbn() + "', "
                + "titulo = '" + libro.getTitulo() + "', "
                + "autor = '" + libro.getAutor() + "', "
                + "categoria = '" + libro.getCategoria() + "', "
                + "stock = '" + libro.getStock()+ "', "
                + "fechaPublicacion = '" + LocalDate.now() + "', "
                + "descripcion = '" + libro.getDescripcion() + "' "
                + "WHERE id = " + libro.getIdLibro();
        conexion.ejecutar(query);
    }

    public Libro obtenerLibro(int id) throws SQLException {
        String query = ""
                + "SELECT * "
                + "FROM libros "
                + "WHERE id = " + id;
        ResultSet rs = conexion.ejecutar(query);
        Libro libro = null;
        while (rs.next()) {
            libro = extractBook(rs);
        }
        return libro;
    }

    public ArrayList<Libro> getLibros() throws SQLException {
        String query = "SELECT * FROM libros";
        ResultSet rs = conexion.ejecutar(query);

        ArrayList<Libro> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(extractBook(rs));
        }
        return lista;
    }

    public ArrayList<Libro> getLibrosPorUsuario(int id) throws SQLException{
        String query = "SELECT "
                + "libros.id, "
                + "libros.isbn, "
                + "libros.titulo, "
                + "libros.autor, "
                + "libros.categoria, "
                + "libros.stock, "
                + "libros.fechaPublicacion, "
                + "libros.descripcion "
                + "FROM usuario_libro "
                + "INNER JOIN clientes ON cliente_libro.cliente_id = clientes.id "
                + "INNER JOIN libros ON cliente_libro.libro_id = libros.id "
                + "WHERE cliente_libro.cliente_id = "+id;
        ResultSet rs = conexion.ejecutar(query);
        ArrayList<Libro> libros = new ArrayList<>();
        while(rs.next()){
            libros.add(extractBook(rs));
        }
        return libros;
    }
    

    public ArrayList<Libro> filtroTitulo(String titulo) throws SQLException{
        String query = "SELECT * FROM libros WHERE titulo LIKE '"+titulo+"%'";
        ResultSet rs = conexion.ejecutar(query);
        ArrayList<Libro> libros = new ArrayList<>();
        while (rs.next()) {
            libros.add(extractBook(rs));
        }
        return libros;
    }
    
    public ArrayList<Libro> filtroCategoria(String categoria) throws SQLException{
        String query = "SELECT * FROM libros WHERE categoria = '"+categoria+"'";
        ResultSet rs = conexion.ejecutar(query);
        ArrayList<Libro> libros = new ArrayList<>();
        while (rs.next()) {
            libros.add(extractBook(rs));
        }
        return libros;
    }
    
    private Libro extractBook(ResultSet rs) throws SQLException {
        Libro libro = new Libro();
        libro.setIdLibro(rs.getInt("id"));
        libro.setIsbn(rs.getString("isbn"));
        libro.setTitulo(rs.getString("titulo"));
        libro.setAutor(rs.getString("autor"));
        libro.setCategoria(rs.getString("categoria"));
        libro.setStock(rs.getInt("stock"));
        LocalDate fecha = LocalDate.parse(rs.getDate("fechaPublicacion").toString());
        libro.setFechaPublicacion(fecha);
        libro.setDescripcion(rs.getString("descripcion"));
        System.out.println(libro.getFechaPublicacion());
        return libro;
    }
}
