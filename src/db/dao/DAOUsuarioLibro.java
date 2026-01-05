/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.dao;

import db.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Libro;

/**
 *
 * @author Jorda
 */
public class DAOUsuarioLibro {
    private Conexion conexion;

    public DAOUsuarioLibro(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public void agregar(int idLibro, int idUsuario) throws SQLException{
        String query = ""
                + "INSERT INTO usuario_libro(usuario_id, libro_id)"
                + "VALUES("+idUsuario+","+idLibro+")";
        conexion.ejecutar(query);
    }
    public void eliminar(int idUsuario, int idLibro) throws SQLException{
        String query = "DELETE FROM usuario_libro WHERE usuario_id = "+ idUsuario+" AND libro_id = "+idLibro+" LIMIT 1";
        conexion.ejecutar(query);
    }
    public void eliminarRegistroLibro(int id){
        
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
                + "INNER JOIN usuarios ON usuario_libro.usuario_id = usuarios.id "
                + "INNER JOIN libros ON usuario_libro.libro_id = libros.id "
                + "WHERE usuario_libro.usuario_id = "+id;
        ResultSet rs = conexion.ejecutar(query);
        ArrayList<Libro> libros = new ArrayList<>();
        while(rs.next()){
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
        return libro;
    }
}
