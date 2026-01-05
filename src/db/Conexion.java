/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Jorda
 */
public class Conexion {
    private Connection conn;
    private Statement st;
    
    public Conexion(){
        String nombreDB= "st_library";
        String url = "jdbc:mysql://localhost/"+nombreDB+"?user=root&password=";
        try {
            conn = DriverManager.getConnection(url);
//            System.out.println("conexion exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet ejecutar(String sql) throws SQLException{
        st = conn.createStatement();
        if(sql.toLowerCase().strip().startsWith("select")){
            ResultSet rs = st.executeQuery(sql);
            return rs;
        }
        else{
            st.execute(sql);
            cerrarConn();
            return null;
        }
    }
    public void cerrarConn() throws SQLException{
        st.close();
    }
    
}
