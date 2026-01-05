/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import db.DAOManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sala;

/**
 *
 * @author Jorda
 */
public class DAOSala {

    static DAOManager dao = new DAOManager();
    public void agregar(){
        try {
            Sala sala = new Sala(0, true, 11000);
            dao.getDataSalas().agregar(sala);
            System.out.println("se agrego");
        } catch (SQLException ex) {
            Logger.getLogger(DAOSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminar(){
        try {
            dao.getDataSalas().eliminar(5);
            System.out.println("se elimino");
        } catch (SQLException ex) {
            Logger.getLogger(DAOSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificar(){
        try {
            Sala sala = new Sala(6, true, 10000);
            dao.getDataSalas().modificar(sala);
            System.out.println("se modifico");
        } catch (SQLException ex) {
            Logger.getLogger(DAOSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void obtenerSala(){
        try {
            Sala sala = dao.getDataSalas().obtenerSala(6);
            System.out.println(sala.toString());
        } catch (SQLException ex) {
            Logger.getLogger(DAOSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getSalas(){
        try {
            ArrayList<Sala> salas = dao.getDataSalas().getSalas();
            for (Sala sala : salas) {
                System.out.println(sala.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
       DAOSala dao = new DAOSala();
       dao.getSalas();
    }
    
}
