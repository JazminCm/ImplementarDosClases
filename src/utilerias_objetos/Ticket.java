/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilerias_objetos;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Ismael
 */
public class Ticket implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;
    private String fecha ;
    private Collection<Prenda> prendas ;
    private double total;
    
    public Ticket(){}
  
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Collection<Prenda> getPrendas() {
        return prendas;
    }

    public void setPrendas(Collection<Prenda> prendas) {
        this.prendas = prendas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
