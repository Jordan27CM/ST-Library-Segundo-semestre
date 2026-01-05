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
import model.Sala;

/**
 *
 * @author Jorda
 */
public class DAOUsuarioSala {
    private Conexion conexion;

    public DAOUsuarioSala(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public void agregarSala(int idSala, int idUsuario) throws SQLException{
        String query = ""
                + "INSERT INTO usuario_sala(usuario_id, sala_numero)"
                + "VALUE ("+idUsuario+","+idSala+")";
        conexion.ejecutar(query);
    }
    
    public ArrayList<Sala> salasPorUsuario(int id) throws SQLException{
        String query = ""
                + "SELECT salas.numeroSala, salas.disponible, salas.capacidad "
                + "FROM usuario_sala "
                + "INNER JOIN usuarios ON usuario_sala.usuario_id = usuarios.id "
                + "INNER JOIN salas ON usuario_sala.sala_numero = salas.numeroSala "
                + "WHERE usuario_sala.usuario_id = "+id;
        ResultSet rs = conexion.ejecutar(query);
        ArrayList<Sala> salas = new ArrayList<>();
        while(rs.next()){
            salas.add(extraerSala(rs));
        }
        return salas;
    }
    public void eliminar(int idUsuario, int idSala) throws SQLException{
        String query = "DELETE FROM usuario_sala WHERE usuario_id = "+idUsuario+" AND sala_numero = "+idSala;
        conexion.ejecutar(query);
    }
    
    private Sala extraerSala(ResultSet rs) throws SQLException{
        Sala sala = new Sala();
        sala.setNumeroSala(rs.getInt("numeroSala"));
        sala.setDisponible(rs.getBoolean("disponible"));
        sala.setCapacidad(rs.getInt("capacidad"));
        return sala;
    }
    
}
