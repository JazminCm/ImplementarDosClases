/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;
import utilerias_objetos.Prenda;
import utilerias_objetos.Ticket;

/**
 *
 * @author Ismael
 */
public class Actualizar {
    statusOperacionesActualizar vendedora;
    private int codigo;
    Prenda prenda = new Prenda();
    private Collection<Prenda> prendas = new ArrayList<>();
    
    public Actualizar(){}
    
    public Actualizar(statusOperacionesActualizar vendedora){
        this.vendedora = vendedora;
    }
    
    public Prenda capturar(){
        //vendedora.statusAgrega();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Ingresa Tipo");
        String tipo = scan.nextLine();
        System.out.println("Ingresa Talla");
        String talla = scan.nextLine();
        System.out.println("Ingresa precio");
        int precio = scan.nextInt();
        scan.nextLine();
        System.out.println("Ingresa color");
        String color = scan.nextLine();
        Prenda prenda = new Prenda(tipo,talla,color,precio);
        
        return prenda;
    }

    public int up(Ticket ticket) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("Ticket"+ this.getCodigo() +".txt");
        ObjectOutputStream oos = new ObjectOutputStream(file);
        oos.writeObject(ticket);
        oos.close();  
        
        return this.getCodigo();
    }
    
    public interface statusOperacionesActualizar{
        public void statusActualizarTicket();
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
