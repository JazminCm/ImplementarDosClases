/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilerias_objetos;

import java.io.Serializable;

/**
 *
 * @author Ismael
 */
public class Prenda implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;
    private String tipo;
    private String talla;
    private String color;
    private double precio;
    
    public Prenda(){}
    
    public Prenda(String tipo, String talla, String color, double precio) {
        this.tipo = tipo;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
