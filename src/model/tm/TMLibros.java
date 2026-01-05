/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.tm;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Libro;

/**
 *
 * @author Jorda
 */
public class TMLibros extends AbstractTableModel {

    private ArrayList<Libro> lista;
    private String[] cabeceras = {"ID", "Titulo", "Autor", "Categoria"};

    public TMLibros(ArrayList<Libro> lista){
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Libro libro = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0 -> {
                return libro.getIdLibro();
            }
            case 1 -> {
                return libro.getTitulo();
            }
            case 2 -> {
                return libro.getAutor();
            }
            case 3 -> {
                return libro.getCategoria();
            }
            
            default -> throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return cabeceras[column];
    }
}
