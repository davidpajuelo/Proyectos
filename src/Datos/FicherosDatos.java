/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import basesdatos.Compra;
import basesdatos.ListaPersonas;
import basesdatos.Persona;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author dam2
 */
public class FicherosDatos {

    public void guardar(String nombreFichero, ArrayList<Persona> datos) {

        FileOutputStream file = null;
        Iterator it = datos.iterator();
        try {
            file = new FileOutputStream(nombreFichero);
            ObjectOutputStream object = new ObjectOutputStream(file);
            while (it.hasNext()) {
                Persona aux = (Persona) it.next();
                object.writeObject(aux);
            }
        } catch (IOException ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public void guardarCompras(String nombreFichero, ArrayList<Compra> compras) {
        FileOutputStream file = null;
        Iterator it = compras.iterator();
        try {
            file = new FileOutputStream(nombreFichero);
            ObjectOutputStream object = new ObjectOutputStream(file);
            while (it.hasNext()) {
                Compra aux = (Compra) it.next();
                object.writeObject(aux);
            }
            object.close();
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Persona> cargar(String nombreFichero) {

        ArrayList<Persona> personas = new ArrayList<>();
        Persona p = null;


        try {
            FileInputStream file = new FileInputStream(nombreFichero);

            ObjectInputStream object = new ObjectInputStream(file);

            while (file.available() > 0) {
                p = (Persona) object.readObject();
                personas.add(p);
            }//close close
            object.close();
            file.close();

        } catch (Exception ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);

        }
        return personas;
    }

    public ArrayList<Compra> cargarCompras(String nombreFichero) {

        ArrayList<Compra> compras = new ArrayList<>();
        Compra c = null;

        try {
            FileInputStream file = new FileInputStream(nombreFichero);
            if (file != null && file.available() > 0) {
                ObjectInputStream object = new ObjectInputStream(file);
                while (file.available() > 0) {
                    c = (Compra) object.readObject();
                    compras.add(c);
                }//close close
                object.close();
                file.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(No existe archivo de compras)Se a creado un nuevo archivo para las compras del usuario. ");

            try {
                FileOutputStream fos = new FileOutputStream(nombreFichero);
            } catch (FileNotFoundException ex1) {
                Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return compras;
    }

    public void guardarXML(ArrayList<Persona> arrayPersonas) {
        try {
            Element personas = new Element("Personas");
            Document document = new Document(personas);
            for (int i = 0; i < arrayPersonas.size(); i++) {
                Element persona = new Element("Persona");
                String idNumero = String.valueOf(i + 1);
                persona.setAttribute(new Attribute("id", idNumero));
                Element nombre = new Element("nombre");
                persona.addContent(nombre);
                String nombrePersona = arrayPersonas.get(i).getNombre().toString();
                nombre.addContent(nombrePersona);
                document.getRootElement().addContent(persona);
            }


            //ARCHIVO PARA GUARDAR
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.output(document, System.out);
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(document, new FileWriter(
                    "personas.xml"));
        } catch (IOException ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    public ArrayList<Persona> cargarXML(String fichero) {
        ArrayList<Persona> ArrayPersonas = new ArrayList();
        File f1 = new File(fichero);
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document document = saxBuilder.build(f1);
            Element rootNode = document.getRootElement();
            List<Element> personas = rootNode.getChildren("Persona");
            for (int i = 0; i <= personas.size() - 1; i++) {
                Element element = personas.get(i);
                Persona p1 = new Persona(Integer.parseInt(element.getAttributeValue("id")), element.getChildText("nombre"));
                ArrayPersonas.add(p1);
            }

        } catch (Exception ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ArrayPersonas;
    }

    public void guardarXMLCompras(ArrayList<Compra> arrayCompras, String nombrePersona, int idPersona) {
        try {
            Element compras = new Element("Compras");
            Document document = new Document(compras);
            for (int i = 0; i < arrayCompras.size(); i++) {
                Element compra = new Element("Compra");
                String idNumero = String.valueOf(arrayCompras.get(i).getCodigo());
                compra.setAttribute(new Attribute("id", idNumero));
                Element nombre = new Element("nombre");
                compra.addContent(nombre);
                String nombreCompra = arrayCompras.get(i).getNombre().toString();
                nombre.addContent(nombreCompra);
                document.getRootElement().addContent(compra);
            }


            //ARCHIVO PARA GUARDAR
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.output(document, System.out);
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(document, new FileWriter(
                    "Compras" + nombrePersona + idPersona + ".xml"));
        } catch (IOException ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Compra> cargarComprasXML(String fichero) {
        ArrayList<Compra> ArrayCompras = new ArrayList();
        File f1 = new File(fichero);
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document document = saxBuilder.build(f1);
            Element rootNode = document.getRootElement();
            List<Element> compras = rootNode.getChildren("Compra");
            for (int i = 0; i <= compras.size() - 1; i++) {
                Element element = compras.get(i);
                Compra c1 = new Compra(Integer.parseInt(element.getAttributeValue("id")), element.getChildText("nombre"));
                ArrayCompras.add(c1);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No hay archivo " + fichero + " lo creo nuevo");
        }
        return ArrayCompras;
    }

    public void escribirPersonas(ArrayList<Persona> listaPersonas) {
 //Creamos un objeto Lista de Personas
//        ListaPersonas listaper = new ListaPersonas();
//        for(Persona  itemPersona: listaPersonas){
//            Persona persona=itemPersona;
//            listaper.add(persona);
//        }
        try {
            XStream xstream = new XStream();
//            cambiar de nombre a las etiquetas XML
//            xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
//             xstream.alias("DatosPersona", Persona.class);
//            xstream.useAttributeFor(Persona.class, "coche");
//             xstream.useAttributeFor(Persona.class, "id");
//            quitar etiwueta lista (atributo de la clase ListaPersonas)
//            xstream.addImplicitCollection(ListaPersonas.class, "lista");
//            Insertar los objetos en el XML
//            xstream.registerConverter(new CocheConverter());
            xstream.toXML(listaPersonas, new FileOutputStream("Personas.xml"));
            System.out.println("Creado fichero XML....");
        } catch (Exception e) {
            e.printStackTrace();
        }

    } //fin EscribirPersonas
    public ArrayList leerPersonas() {

    ArrayList<Persona> lista=null;

        try {
            XStream xstream = new XStream();
            
//            xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
//            xstream.alias("DatosPersona", Persona.class);
//            xstream.useAttributeFor(Persona.class, "id");
//            xstream.addImplicitCollection(ListaPersonas.class, "lista");
            lista = (ArrayList) xstream.fromXML(new FileInputStream("personas.xml"));
            
            
//            List<Persona> listaPersonas = new ArrayList<Persona>();
//            listaPersonas = listadoTodas.getListaPersonas();
//            
//            Iterator iterador = listaPersonas.listIterator(); //Le solicito a la lista que me devuelva un iterador con todos los el elementos contenidos en ella
//            while (iterador.hasNext()) {
//                Persona p = (Persona) iterador.next(); //Obtengo el elemento contenido
//                lista.add(p);
//            }
//            System.out.println("Fin de listado .....");
        } //fin LeerPersonas
        catch (FileNotFoundException ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    return lista;
    }
}
