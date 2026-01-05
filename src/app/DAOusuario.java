/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import db.DAOManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import model.Validaciones;

/**
 *
 * @author Jorda
 */
public class DAOusuario {
    static DAOManager daom = new DAOManager();
    public void agregar(){
        Usuario usuario = new Usuario(0, "jordan27", "jordan", "murillo", "123", 2, "2222222");
        try {
            daom.getDataUsuario().agregar(usuario);
            System.out.println("se agrego");
        } catch (SQLException ex) {
            Logger.getLogger(DAOusuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminar(){
        try {
            daom.getDataUsuario().eliminar(22);
            System.out.println("se elimino");
        } catch (SQLException ex) {
            Logger.getLogger(DAOusuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificar(){
        try {
            Usuario usuario = new Usuario(10, "juan", "pedro", "camilo", "3456", 0, "12321231");
            daom.getDataUsuario().modificar(usuario);
            System.out.println("se modifico");
        } catch (SQLException ex) {
            Logger.getLogger(DAOusuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void obtenerUsuario(){
        try {
            System.out.println(daom.getDataUsuario().obtenerUsuario(1).toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOusuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getUsuarios(){
        try {
            ArrayList<Usuario> usuarios = daom.getDataUsuario().getUsuarios();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOusuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        DAOusuario d = new DAOusuario();
        d.getUsuarios();
        
    }
    
}
