/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fabry
 */
public class Conexion {
    
    public Connection getConexion(){
         Connection conecction = null ;
 
         String url= "jdbc:postgresql://127.0.0.1:5432/ventas_dao";
         String user="postgres";
         String password= "fabri";
         
         
         try {
             
         Class.forName("org.postgresql.Driver");
         conecction= DriverManager.getConnection(url,user,password);
         if (conecction!=null)
         {
             System.out.println("Se conecto a la base de datos");
         }
        } catch (Exception e) {
            
             System.out.println("Fallo la conexion "+e);
        }
     return conecction;
    }

    public void chauBD(){
    Connection c =null;
        try {
            c.close();
        } catch (SQLException ex) {
           System.out.println("Falla Chau BD"+ex); 
        }
    
    }
    
}
