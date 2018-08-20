/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import vistas_tipo_usuario.Cliente;
import vistas_tipo_usuario.Vendedora;

/**
 *
 * @author Ismael
 */
public class Inicio {
    private static boolean comenzo = true;
    private static boolean conerror = false;
   
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        do {
            comenzo = menuInicio();
        } while (comenzo != false); 
    } 

    public static boolean menuInicio() throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        int opc = 0;
        try {
            System.out.println("***************************************\n" +
                               "****BIENVENIDOS A LA TIENDA DE ROPA****\n" +
                               "****************JAZGILL****************\n" +
                               "***************************************\n" +
                               "*********** Elige una opción **********\n" +
                               "***************************************\n" +
                               "*** 1 - Para Vendedora              ***\n" +
                               "*** 0 - Para salir                  ***\n");
            opc = scan.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Ingresa un número!!");
            menuInicio();
        }
        switch(opc){
            case 0:
                System.out.println(" ***********  Bye *********");
                break;
            default:
                menu2(opc);
                break;
        }
        
        return false;
    }

    private static void menu2(int opc) throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in); 
        int opcion = 0, tipo = opc;
        switch(opc){
            case 0:
                menuInicio();
                break;
            case 1:
                Vendedora venderora = new Vendedora();
                break;
            case 2:
                Cliente cliente = new Cliente();
                break;
            default:
                System.err.println("Elige una opción correcta!");
                menu2(opc);
                break;
        }
    }
}
