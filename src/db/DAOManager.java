/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import db.dao.DAOUsuarios;
import db.dao.DAOLibros;
import db.dao.DAOSalas;
import db.dao.DAOUsuarioLibro;
import db.dao.DAOUsuarioSala;

/**
 *
 * @author Jorda
 */
public class DAOManager {
    private DAOUsuarios dataUsuario;
    private DAOLibros dataLibros;
    private DAOSalas dataSalas;
    private DAOUsuarioSala usuarioSala;
    private DAOUsuarioLibro usuarioLibro;
    private Conexion conexion;
    
    public DAOManager() {
        conexion = new Conexion();
        dataUsuario = new DAOUsuarios(conexion);
        dataLibros = new DAOLibros(conexion);
        dataSalas = new DAOSalas(conexion);
        usuarioLibro = new DAOUsuarioLibro(conexion);
        usuarioSala = new DAOUsuarioSala(conexion);
        
    }

    public DAOUsuarios getDataUsuario() {
        return dataUsuario;
    }

    public DAOLibros getDataLibros() {
        return dataLibros;
    }

    public DAOSalas getDataSalas() {
        return dataSalas;
    }

    public DAOUsuarioSala getUsuarioSala() {
        return usuarioSala;
    }

    public DAOUsuarioLibro getUsuarioLibro() {
        return usuarioLibro;
    }

    
    
}
