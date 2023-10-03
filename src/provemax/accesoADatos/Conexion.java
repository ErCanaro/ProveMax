/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Bulacio
 */
public class Conexion {
    public static final String URL="jdbc:mariadb://localhost/";
    public static final String BD="provemax";
    public static final String USER="root";
    public static final String PASS="";
    public static Connection conexion;
    
    private Conexion(){};
    
    public static Connection getConexion(){
        if (conexion == null) {
            try {
                //Cargar Driver  
                Class.forName("org.mariadb.jdbc.Driver");
                //Establecer la  CONEXION
                conexion = DriverManager.getConnection(URL + BD, USER, PASS);
                JOptionPane.showMessageDialog(null, "Conexion a " + BD + " establecida");

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar los Drivers");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectar con la BD");
            }
        };
        return conexion;
    }
}


