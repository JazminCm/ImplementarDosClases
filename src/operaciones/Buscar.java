/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import utilerias_objetos.Prenda;
import utilerias_objetos.Ticket;

/**
 *
 * @author Ismael
 */
public class Buscar {
    statusOperacionesBuscar vendedora;
    int codigo;
    
    public Buscar(statusOperacionesBuscar vendedora){
        this.vendedora = vendedora;
    }
    
    public void buscar() throws FileNotFoundException, IOException, ClassNotFoundException{
        //vendedora.statusAgrega();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa el codigo del ticket");
        codigo = scan.nextInt();
        buscarDoc(codigo);
    }
     
    public void buscarDoc(int a) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream file2 = new FileInputStream("Ticket"+a+".txt");
        ObjectInputStream p2 = new ObjectInputStream(file2);
        
        Ticket ticket = new Ticket();
        ticket = (Ticket) p2.readObject();
        System.out.println("\n\n\n\n");
        System.out.println("********************************\n"
                          +"*************TICKET*************\n"
                          +"********************************\n");
        System.out.println(ticket.getFecha()+"\n");
        Collection<Prenda> prendas = new ArrayList<>();
        prendas =(Collection<Prenda>)ticket.getPrendas();
        imprimir(prendas);
        System.out.println("\n Total: "+ticket.getTotal());
    }
    
    public interface statusOperacionesBuscar{
        public void statusBuscarTicket();
    }
    
    private static void imprimir(Collection colection) {
        int cont = 1;
        Iterator a = colection.iterator();
        while (a.hasNext()) {
            Prenda prenda = (Prenda)a.next(); 
            System.out.println(+cont+++"- " + prenda.getTipo() + " "+ prenda.getTalla()+ " " +prenda.getColor() + " "+ prenda.getPrecio());
        }
    }
}