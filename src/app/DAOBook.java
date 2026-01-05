/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import db.DAOManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Libro;

/**
 *
 * @author Jorda
 */
public class DAOBook {

    /**
     * @param args the command line arguments
     */
    public void agregar(){
        Libro libro = null;
        try {
            DAOManager dao = new DAOManager();
            
            libro = new Libro(100, "asd", "asdasd", "qweqwe", 200, LocalDate.now(), "asdasd", "qweqweqwe123123");
            dao.getDataLibros().agregar(libro);
        } catch (SQLException ex) {
//            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fallo el ingreso de nuevo lirbo: " + libro.getTitulo());
        }
    }
    public void select(){
        try {
            DAOManager dao = new DAOManager();
            ArrayList<Libro> libros = dao.getDataLibros().getLibros();
            for (Libro libro : libros) {
                System.out.println(libro.toString());
            }
            
        } catch (SQLException ex) {
            System.out.println("error");
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificar(){
            Libro libro;
        try {
            libro = new Libro(1, "asd", "asdasd", "qweqwe", 200, LocalDate.now(), "asdasd", "qweqweqwe123123");
            DAOManager dao = new DAOManager();
            dao.getDataLibros().modificar(libro);
        } catch (SQLException ex) {
            System.out.println("no se modfico el libro");
        }
    }
    public void eliminar(){
        try {
            DAOManager dao = new DAOManager();
            dao.getDataLibros().eliminar(22);
            System.out.println("se elimino con exito");
        } catch (SQLException ex) {
            System.out.println("no se elimino");
        }
    }
    public void librosUsuario(){
        try {
            DAOManager dao = new DAOManager();
            ArrayList<Libro> libros =dao.getDataLibros().getLibrosPorUsuario(2);
            for (Libro libro : libros) {
                System.out.println(libro);
            }
            
        } catch (SQLException ex) {
            System.out.println("error");
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    public void filtro(){
        try {
            DAOManager dao = new DAOManager();
            ArrayList<Libro> libros =dao.getDataLibros().filtroCategoria("ficción");
            for (Libro libro : libros) {
                System.out.println(libro.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        DAOBook book = new DAOBook();
        book.select();
        
    }
    
}
