/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.dao;

import db.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;
import java.sql.ResultSet;

/**
 *
 * @author Jorda
 */
public class DAOUsuarios {
    private Conexion conexion;

    public DAOUsuarios(Conexion con) {
        this.conexion = con;
    }
    
    public void agregar(Usuario usuario) throws SQLException{
        String query = ""
                + "INSERT INTO usuarios(nickname, nombre, apellido, clave, nivelAcceso, rut)"
                + "VALUES ("
                + "'"+usuario.getNickname()+"', "
                + "'"+usuario.getNombre()+"', "
                + "'"+usuario.getApellido()+"', "
                + "'"+usuario.getClave()+"', "
                + ""+usuario.getNivelAcceso()+", "
                + "'"+usuario.getRut()+"')";
        conexion.ejecutar(query);
    }
    
    public void eliminar(int id) throws SQLException{
        String query = "DELETE FROM usuarios WHERE id = "+id;
        conexion.ejecutar(query);
    } 
   
    public void modificar(Usuario usuario) throws SQLException{
        String query = ""
                + "UPDATE usuarios "
                + "SET "
                + "nickname = '"+usuario.getNickname()+"', "
                + "nombre = '"+usuario.getNombre()+"', "
                + "apellido = '"+usuario.getApellido()+"', "
                + "clave = '"+usuario.getClave()+"', "
                + "nivelAcceso = "+usuario.getNivelAcceso()+", "
                + "rut = '"+usuario.getRut()+"' "
                + "WHERE id = "+usuario.getId()+";";
        conexion.ejecutar(query);
    }
    
    public Usuario obtenerUsuario(int id) throws SQLException{
        String query = "SELECT * FROM usuarios WHERE id = "+id;
        ResultSet rs = conexion.ejecutar(query);
        Usuario usuario = null;
        while(rs.next()){
            usuario = extraerUsuario(rs);
        }
        return usuario;
    }
    public ArrayList<Usuario> filtoNickname(String filto) throws SQLException{
        String query = ""
                + "SELECT * "
                + "FROM usuarios "
                + "WHERE nickname LIKE '"+filto+"%' "
                + "AND nivelAcceso = 2";
        ResultSet rs = conexion.ejecutar(filto);
        ArrayList<Usuario> usuarios = new ArrayList<>();
        while(rs.next()){
            usuarios.add(extraerUsuario(rs));
        }
        return usuarios;
    }
    public ArrayList<Usuario> getUsuarios() throws SQLException{
        String query = "SELECT * FROM usuarios";
        ResultSet rs = conexion.ejecutar(query);
        ArrayList<Usuario> usuarios = new ArrayList<>();
        while(rs.next()){
            usuarios.add(extraerUsuario(rs));
        }
        return usuarios;
    }
    public ArrayList<Usuario> getEmpleados() throws SQLException{
        String query = "SELECT * FROM usuarios WHERE nivelAcceso > 1";
        ResultSet rs = conexion.ejecutar(query);
        ArrayList<Usuario> usuarios = new ArrayList<>();
        while(rs.next()){
            usuarios.add(extraerUsuario(rs));
        }
        return usuarios;
    }
    
    private Usuario extraerUsuario(ResultSet rs) throws SQLException{
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setNickname(rs.getString("nickname"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setApellido(rs.getString("apellido"));
        usuario.setClave(rs.getString("clave"));
        usuario.setNivelAcceso(rs.getInt("nivelAcceso"));
        usuario.setRut(rs.getString("rut"));
        return usuario;
    }
}

    
    
