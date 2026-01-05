/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.tm;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Sala;

/**
 *
 * @author Jorda
 */
public class TMSalas extends AbstractTableModel{
    private ArrayList<Sala> salas;
    private String[] cabeceras = {"numero de Sala", "Disponible", "Capacidad"};
    
    
    public TMSalas(ArrayList<Sala> salas){
        this.salas = salas;
    }
    
    @Override
    public int getRowCount() {
        return salas.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sala sala = salas.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return sala.getNumeroSala();
            }
            case 1 -> {
                return sala.isDisponible();
            }
            case 2 -> {
                return sala.getCapacidad();
            }
            default -> throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return cabeceras[column];
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 1){
            return Boolean.class;
        }
        return String.class;
    }
    
}
