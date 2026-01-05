/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.tm;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Usuario;

/**
 *
 * @author Jorda
 */
public class TMUsuario extends AbstractTableModel{
    private ArrayList<Usuario> usuarios;
    private String[] cabeceras = {"Id","Nickname"};
    
    public TMUsuario (ArrayList<Usuario> usuarios){
        this.usuarios = usuarios;
    }
    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = usuarios.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return usuario.getId();
            }
            case 1 -> {
                return usuario.getNickname();
            }
            default -> throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return cabeceras[column];
    }
    
}
