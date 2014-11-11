/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import basesdatos.Persona;
import com.thoughtworks.xstream.XStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class XstreamEjemplo implements ToXMLable {

    @Override
    public void toXML(Object objeto, String file) {
        try {
            ArrayList<Persona> listaPersonas = (ArrayList) objeto;
            XStream xstream = new XStream();
            xstream.toXML(listaPersonas, new FileOutputStream(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XstreamEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Object fromXML(String file) {
        ArrayList<Persona> lista = null;
        try {
            XStream xstream = new XStream();
            lista = (ArrayList) xstream.fromXML(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
