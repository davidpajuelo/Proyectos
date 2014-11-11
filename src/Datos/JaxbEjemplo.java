/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import basesdatos.ListaPersonas;
import basesdatos.Persona;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dam2
 */
public class JaxbEjemplo implements ToXMLable{

    @Override
    public void toXML(Object obj, String file) {
        
        File fichero1 = new File(file);
        
        try {
            
            JAXBContext jaxb= JAXBContext.newInstance(ListaPersonas.class);
            Marshaller m = jaxb.createMarshaller();
            m.marshal(obj, new FileWriter(file, true));
            //m.setProperty(Marshaller.JAXB_FORMATTE_OUTPUT, true);
            //m.marshall(a,System.out);
        } catch (Exception ex) {
            Logger.getLogger(JaxbEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object fromXML(String file) {
        ArrayList<Persona> salida=new ArrayList<Persona>();
        try {
            JAXBContext jaxb= JAXBContext.newInstance(ListaPersonas.class);
            Unmarshaller um = jaxb.createUnmarshaller();
            ListaPersonas personas= (ListaPersonas)um.unmarshal(new FileReader(file));
            for(int i=0;i<personas.getListaPersonas().toArray().length;i++){
                salida.add(personas.getListaPersonas().get(i));
            }
        } catch (JAXBException ex) {
            Logger.getLogger(JaxbEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JaxbEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
}


