/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Objetos.Detalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fabry
 */
public class ControladorDetalleFactura {
    
    Connection con;
    PreparedStatement ps,ps2;
    ResultSet rs;
    
     public Detalle mostrar(int id) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Detalle obj = null; 
        ControladorProducto cp = new ControladorProducto();
        ControladorFactura cf = new ControladorFactura();
            
        
        try {

            ps = con.prepareStatement("select * from detalles  where id = ?");
                    
            ps.setInt(1 , id);
            rs = ps.executeQuery();
            while (rs.next()){
            
            
           
            
            obj = new Detalle(rs.getInt(1),
                   rs.getInt(2),
                   rs.getInt(3),
                   rs.getInt(4),
                   cp.mostrar(rs.getInt(5)),
                   cf.mostrar(rs.getInt(6)));

            }
        } catch (Exception e) {
            System.out.println(e+"DEtalle");
        }
        
        
        
        return obj;
   
    }
     
      public ArrayList<Detalle> MostrarTodo (){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Detalle obj =null;
        ControladorProducto cp = new ControladorProducto();
        ControladorFactura cf = new ControladorFactura();
        ArrayList<Detalle>  alDetall = new ArrayList<> ();
        
        
          try {
        ps = con.prepareStatement("select * from detalles");
                    
            rs = ps.executeQuery();
            while (rs.next()){
            
             obj = new Detalle(rs.getInt(1),
                   rs.getInt(2),
                   rs.getInt(3),
                   rs.getInt(4),
                   cp.mostrar(rs.getInt(5)),
                   cf.mostrar(rs.getInt(6)));


            
             alDetall.add(obj);
                
                
            }
        } catch (Exception e) {
            System.out.println(e+"Detalles");
        }
    return alDetall;
    }
    
     public void Guardar(Detalle d) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Detalle obj = new Detalle();
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement("INSERT INTO public.detalles(\n" +
"	 cantidad, precio_unitario, subtotal, producto, factura)\n" +
"	VALUES ( ?, ?, ?, ?, ?);");
            
            
            ps.setInt(1,d.getCantidad());
           ps.setInt(2,d.getPrecioUni());
          ps.setInt(3,d.getSubTotal());
           ps.setInt(4,d.getProducto().getId());
           ps.setInt(5,d.getFactura().getId());
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Guardar Detalle "+e);
        }
        
    }
}
