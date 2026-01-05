/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.dao;

import db.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Sala;

/**
 *
 * @author Jorda
 */
public class DAOSalas {
    private Conexion conexion;

    public DAOSalas(Conexion conn) {
        this.conexion = conn;
    }
    
    public void agregar(Sala sala) throws SQLException{
        String query = ""
                + "INSERT INTO salas(disponible, capacidad)"
                + "VALUES("+sala.isDisponible()+", "+sala.getCapacidad()+")";
        conexion.ejecutar(query);
    }
    
    public void eliminar(int id) throws SQLException{
        String query = "DELETE FROM salas WHERE numeroSala = "+id;
        conexion.ejecutar(query);
    }
    
    public void modificar(Sala sala) throws SQLException{
        String query = ""
                + "UPDATE salas "
                + "SET "
                + "disponible = "+sala.isDisponible()+", "
                + "capacidad = '"+sala.getCapacidad()+"' "
                + "WHERE numeroSala = "+ sala.getNumeroSala();
        conexion.ejecutar(query);
    }
    
    public Sala obtenerSala(int id) throws SQLException{
        String query = "SELECT * FROM salas WHERE numeroSala = "+id;
        ResultSet rs = conexion.ejecutar(query);
        Sala sala = null;
        while(rs.next()){
            sala = extraerSala(rs);
        }
        return sala;
    }
    
    public ArrayList<Sala> getSalas() throws SQLException{
        String query = "SELECT * FROM salas";
        ResultSet rs = conexion.ejecutar(query);
        ArrayList<Sala> salas = new ArrayList<>();
        while(rs.next()){
            salas.add(extraerSala(rs));
        }
        return salas;
    }
    
    private Sala extraerSala(ResultSet rs) throws SQLException{
        Sala sala = new Sala();
        sala.setNumeroSala(rs.getInt("numeroSala"));
        sala.setDisponible(rs.getBoolean("disponible"));
        sala.setCapacidad(rs.getInt("capacidad"));
        return sala;
    }
}
