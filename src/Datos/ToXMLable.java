/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author dam2
 */
public interface ToXMLable {
     public void toXML (Object objecto,String file);
    public Object fromXML(String file);
}
