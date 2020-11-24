/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Objetos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fabry
 */
public class ControladorProducto {
    
    Connection con;
    PreparedStatement ps, ps2;
    ResultSet rs;
    
    
     public Producto mostrar(int id) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
         Producto obj = null; 
        ControladorCategoria cc = new ControladorCategoria();
       
        try {

            ps = con.prepareStatement("select * from productos where id = ?");
                    
            ps.setInt(1 , id);
            rs = ps.executeQuery();
            while (rs.next()){
            
            
           
            
            obj = new Producto(rs.getInt(1),
                    rs.getString(2), rs.getString(3),
                    rs.getInt(4),
                    cc.mostrar(rs.getInt(5)));

            }
        } catch (Exception e) {
            System.out.println(e+"Producto");
        }
        
        
        
        return obj;
   
    }
     
     
     public ArrayList<Producto> MostrarTodo (){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Producto obj = null;
       ArrayList<Producto>  alProducto = new ArrayList<> ();
        ControladorCategoria cc = new ControladorCategoria();
          try {
        ps = con.prepareStatement("select * from Productos ");
            
            rs = ps.executeQuery();
            while (rs.next()){
            
            obj = new Producto(rs.getInt(1),
                    rs.getString(2), rs.getString(3),
                    rs.getInt(4),
                    cc.mostrar(rs.getInt(5)));

            
             alProducto.add(obj);
                
                
            }
        } catch (Exception e) {
            System.out.println(e+"Producto");
        }
    return alProducto;
    }
     
     
     public void Guardar(Producto p) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Producto obj = new Producto();
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement("INSERT INTO public.productos(\n" +
"	 codigo, descripcion, precio, categoria)\n" +
"	VALUES ( ?, ?, ?, ?);");
            
            
           
            ps.setString(1,p.getCodigo());
            ps.setString(2,p.getDescripcion());
            ps.setInt(3,p.getPrecio());
            ps.setInt(4,p.getCategoria().getId());
          
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Guardar Productos"+e);
        }
        
    }
    
}
