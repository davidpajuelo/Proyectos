/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basesdatos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam2
 */
public class ListaPersonas {
    private List <Persona> lista= new ArrayList<Persona>();
      public ListaPersonas(){    	
    }

    public void add(Persona per) {
            lista.add(per);
    }
   
   public List<Persona> getListaPersonas() {
            return lista;
    }
    
}
