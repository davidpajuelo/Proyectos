/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basesdatos;

import java.io.Serializable;

/**
 *
 * @author dam2
 */
public class Compra implements Serializable{
    private int codigo;
    private String nombre;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
   
    public Compra(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    public Compra() {
      
    }

   
   

   
}
