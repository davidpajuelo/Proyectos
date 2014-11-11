/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basesdatos;

import Datos.TiposToXML;
import Datos.ToXMLFactory;
import Datos.ToXMLable;

/**
 *
 * @author dam2
 */
public class BasesDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FramePersonas fr= new FramePersonas();
        ToXMLFactory fac = new ToXMLFactory();
       
        ToXMLable mio = fac.build(TiposToXML.XSTREAM);
        try{
        mio.toXML(mio, null);
        }catch(Exception e){}
         fr.setVisible(true);
    }
}
