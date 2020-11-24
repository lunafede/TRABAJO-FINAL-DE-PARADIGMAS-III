/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grillas;

import Objetos.TipoCliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fabry
 */
public class GrillaTipoCliente extends AbstractTableModel {
    
    private ArrayList<TipoCliente> altipo = new ArrayList();

    public GrillaTipoCliente(ArrayList<TipoCliente> datos) {
        this.altipo = datos;
        
    }
    
    
    

    @Override
    public int getRowCount() {
          return altipo.size();
    }

    @Override
    public int getColumnCount() {
               return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      TipoCliente obj = altipo.get(rowIndex);
       switch(columnIndex){
           
           case 0: return obj.getDescripcion();
         
           
        default : return "";
    }
    }
    
    @Override
    public String getColumnName(int column) {
       switch(column){
           case 0: return "Descripcion";
         
          
        default : return "";
    }
    }
    
}
