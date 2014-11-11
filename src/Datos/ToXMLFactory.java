/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author dam2
 */
public class ToXMLFactory {
    
    
    public ToXMLable build(TiposToXML tipo)
            
    {
        ToXMLable interfaz = null;
        switch(tipo)
        {
            case XSTREAM : interfaz = new XstreamEjemplo(); break;
            case JAXB: interfaz = new JaxbEjemplo(); break;
                
            
        }
        
        return interfaz;
    }
    
    
    
}
