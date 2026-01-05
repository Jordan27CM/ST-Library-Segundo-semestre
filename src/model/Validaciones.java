/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import db.DAOManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Jorda
 */
public class Validaciones {
    
    public boolean validarRut(String rut){
        int suma= 0;
        String dvR, dvT;
        int[] serie = {2,3,4,5,6,7};
        rut = rut.replace("-", "");
        dvR = rut.substring(rut.length()-1);
        try{
            for(int i= rut.length()-2;i>=0;i--){
                suma += Integer.parseInt(rut.substring(i,i+1))*serie[(rut.length()-2-i)%6];
            }
        }
        catch(NumberFormatException e){
        return false;
        }
        dvT = String.valueOf(11-suma%11);
        if(dvT.compareToIgnoreCase("10")==0){
            dvT = "K";
        }
        return dvT.compareToIgnoreCase(dvR)== 0; 
    }
    
    public boolean validarRutRepetitivo(String rut){
        if(rut.isEmpty()){
            return false;
        }
        try {
            DAOManager dao = new DAOManager();
            ArrayList<Usuario> usuarios = dao.getDataUsuario().getUsuarios();
            for (Usuario usuario : usuarios) {
                if(usuario.getRut().equals(rut)){
                    return false;
                }
            }
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
    public LocalDate validarFecha(String fecha) throws Exception{
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechas;
        fechas = LocalDate.parse(fecha, formato);
        return fechas;      
    }
    
    public int edad(String fecha){
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fecha, formato);
        return Period.between(fechaNacimiento, fechaActual).getYears();
        
    }
    
    public boolean validarClaves(String clave1, String clave2){
        return clave1.length()> 7 && clave1.equals(clave2);
    }
    
    public boolean validarNickname(String nickname){
        if(nickname.isEmpty()){
            return false;
        }
        try {
            DAOManager dao = new DAOManager();
            ArrayList<Usuario> usuarios = dao.getDataUsuario().getUsuarios();
            for (Usuario usuario : usuarios) {
                if(usuario.getNickname().equals(nickname)){
                    return false;
                }
            }
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
            
    public boolean validarIsbn(String isbn){
        isbn = isbn.replace("-", "");
        if(isbn.length() !=13){
            return false;
        }
        try{
            int total = 0;
            for (int i = 0; i < 12; i++) {
                int digito = Integer.parseInt(isbn.substring(i, i +1));
                total += (i % 2 == 0) ? digito : digito * 3;
            }
            int sum = 10 - (total % 10);
            if (sum == 10){
                sum = 0;
            }
            return sum == Integer.parseInt(isbn.substring(12));
        }
        catch(Exception e){
            return false;
        }
    }
    
    public String formatoIsbn(String isbn){
        isbn = isbn.replace("-", "");
        return isbn = isbn.substring(0,3)+"-"+
               isbn.substring(3,4)+"-"+
               isbn.substring(4,7)+"-"+
               isbn.substring(7,12)+"-"+
               isbn.substring(12);
    }
}
