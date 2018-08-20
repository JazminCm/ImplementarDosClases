/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import utilerias_objetos.Ticket;

/**
 *
 * @author Ismael
 */
public class Eliminar {
    statusOperacionesActualizar vendedora;
    private int codigo;
    
    public Eliminar(){}
    
    public Eliminar(statusOperacionesActualizar vendedora){
        this.vendedora = vendedora;
    }
    
     public File eliminar(int codigo) throws FileNotFoundException, IOException {
         this.codigo = codigo;
        File fichero = new File("Ticket"+ this.codigo +".txt");
            
        return fichero;
    }
    
    public interface statusOperacionesActualizar{
        public void statusActualizarTicket();
    }
}
