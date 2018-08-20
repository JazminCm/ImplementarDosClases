/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas_tipo_usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import operaciones.Buscar;
import operaciones.Buscar.statusOperacionesBuscar;
import operaciones.Leer;
import operaciones.Leer.statusOperacionLeer;
import operaciones.Actualizar;
import operaciones.Actualizar.statusOperacionesActualizar;
import operaciones.Eliminar;
import principal.Inicio;
import utilerias_objetos.Prenda;
import utilerias_objetos.Ticket;

/**
 *
 * @author Ismael
 */
public class Vendedora implements statusOperacionLeer, statusOperacionesBuscar, statusOperacionesActualizar{
    private boolean salir = false;
    private Collection<Prenda> prendas = new ArrayList<>();
    private Buscar busca;
    private Eliminar eliminar = new Eliminar();
    private int numCodE;
    private boolean noE = false;
    
   
    public Vendedora() throws IOException, FileNotFoundException, ClassNotFoundException{
        do {
            menu();
        } while (!salir);
    }

    private void menu() throws IOException, FileNotFoundException, ClassNotFoundException {
        int opc;
        Scanner scan = new Scanner(System.in);
        
        try {
            System.out.println("***************************************");
            System.out.println("*********** Elige una opción **********");
            System.out.println("***************************************\n");
            System.out.println("*** 1 - Crear Ticket               ***");
            System.out.println("*** 2 - Buscar Ticket              ***");
            System.out.println("*** 3 - Editar Ticket              ***");
            System.out.println("*** 4 - Eliminar Ticket            ***");
            System.out.println("*** 0 - Salir                      ***");
            opc = scan.nextInt();
            switchOpcionesMenu(opc);
        } catch (InputMismatchException e) {
            System.err.println("Ingresa un número!!");
            menu();
        }
    }

    private void switchOpcionesMenu(int opc) throws IOException, FileNotFoundException, ClassNotFoundException {
        Inicio i = new Inicio();
        Scanner scan = new Scanner(System.in);
        switch (opc){
            case 0:
                i.menuInicio();
                salir = true;
                break;
            case 1:
                salir = true;
                menu2();
                break;
            case 2:
                busca = new Buscar(this);
                busca.buscar();
                menu();
                break;
            case 3:
                noE = true;
                System.out.println("Ingresa el codigo del ticket");
                numCodE = scan.nextInt();
                menu2();
                break;
            case 4:
                System.out.println("Ingresa el codigo del ticket");
                int cod = scan.nextInt();
                File fichero = eliminar.eliminar(cod);
                if (fichero.delete()){
                    System.out.println("\n\n*******************************************************************");
                    System.err.println("El Ticket con el código: "+cod+" ha sido borrado satisfactoriamente");
                    System.out.println("\n\n*******************************************************************");
                }else{
                    System.out.println("\n\n*******************************************************************");
                    System.err.println("El Ticket con el código: "+cod+" No puede ser borrado");
                    System.out.println("\n\n*******************************************************************");
                }
                break;
            default:
                break;
        }
    }

    public void menu2() throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in); 
        try {
            System.out.println("***************************************");
            System.out.println("*********** Elige una opción **********");
            System.out.println("***************************************\n");
            System.out.println("*** 1 - Agregar prenda               ***");
            System.out.println("*** 0 - Salir                        ***");
            switchOpcionesVenta(scan.nextInt(),prendas );
        } catch (InputMismatchException e) {
            System.err.println("Ingresa un número!!");
            menu2();
        }
    }

    private void switchOpcionesVenta(int opc , Collection prendas) throws IOException, FileNotFoundException, ClassNotFoundException {
        Leer nuevaTicket = null;
        Actualizar actualizarTicket = null;
        if (noE == false) 
            nuevaTicket= new Leer(this);
        else
            actualizarTicket = new Actualizar(this);
        
        if (opc == 1 && true ) 
            opc = 3;
        
        if (opc == 0 && true ) 
            opc = 2;
        
        switch(opc){
            case 0:
                Ticket  ticket = new Ticket();
                ticket.setPrendas(this.prendas);
                ticket.setTotal(sumar(this.prendas));
                ticket.setFecha(String.format("%1$tY-%1$tm-%1$tdT%1$tH:%1$tM:%1$tS", new Date()));
                System.err.println("Numero de ticket:"+ nuevaTicket.Guardar(ticket));
                menu();
                break;
            case 1:
                prendas.add(nuevaTicket.capturar());
                menu2();
                break;
            case 2:
                Ticket  ticketAc = new Ticket();
                ticketAc.setPrendas(this.prendas);
                ticketAc.setTotal(sumar(this.prendas));
                ticketAc.setFecha(String.format("%1$tY-%1$tm-%1$tdT%1$tH:%1$tM:%1$tS", new Date()));
                actualizarTicket.setCodigo(numCodE);
                System.err.println("Numero de ticketactuzlizado:"+ actualizarTicket.up(ticketAc));
                noE = false;
                menu();
                break;
            case 3:
                prendas.add(actualizarTicket.capturar());
                menu2();
                break;
            default:
                System.err.println("Seleccióna un opcion correcta");
                menu2();
                break;
        }
    }
    
    @Override
    public void statusAgrega(){
        System.err.println("Agregando Prenda*****");
    }
    @Override
    public void statusBuscarTicket(){
    }
    @Override
    public void statusActualizarTicket(){
    }
    
    private static double sumar( Collection colection) {
        Iterator a = colection.iterator();
        double suma = 0;
        while (a.hasNext()) {            
            Prenda prenda = (Prenda)a.next(); 
            suma = suma + prenda.getPrecio();
        }
        return suma;
    }
}