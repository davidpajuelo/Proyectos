/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basesdatos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dam2
 */
@XmlRootElement
public class Persona implements Serializable{
    @XmlTransient
    private int id;
    private String nombre;
    private transient ArrayList<Compra>compras;

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public Persona(int id, String nombre,ArrayList compras) {
        
        this.id = id;
        this.nombre = nombre;
        this.compras=compras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
       public ArrayList< Compra> getCompras() {
        return compras;
    }
  public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }
    
    
}
