/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grillas;

import Objetos.Categoria;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fabry
 */
public class GrillaCategoria extends AbstractTableModel{
    private ArrayList<Categoria> alCateg = new ArrayList();
    public GrillaCategoria(ArrayList<Categoria> datos) {
        this.alCateg = datos;
        
    }

    @Override
    public int getRowCount() {
      return alCateg.size();
    }

    @Override
    public int getColumnCount() {
          return 1;
          
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Categoria obj = alCateg.get(rowIndex);
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
