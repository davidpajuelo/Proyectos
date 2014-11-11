/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basesdatos;

import Datos.Constantes;
import Datos.FicherosDatos;
import basesdatos.Persona;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author dam2
 */
public class FramePersonas extends javax.swing.JFrame {

    /**
     * Creates new form FramePersonas
     */
    public FramePersonas() {
        initComponents();

        leerProperties();

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("NOMBRE");

        jTable1.setModel(model);
        
        //cargarPersonasXML();
        cargarPersonasXstream();
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {

                if (jTable1.getSelectedRow() >= 0) {
                    jTextField1.setText(
                            jTable1.getValueAt(
                                    jTable1.getSelectedRow(), Constantes.COLUMN_ID).toString());
                    jTextField2.setText(
                            jTable1.getValueAt(
                                    jTable1.getSelectedRow(), Constantes.COLUMN_NOMBRE).toString());
                }
            }
        });

    }

    private String rutaBD = null;
    private ArrayList<Compra> a1 = null;
    private ArrayList<Compra> compras = null;

    private void leerProperties() {

        FileReader file = null;
        Properties p = null;

        try {
            p = new Properties();
            file = new FileReader(Constantes.FICHERO_PROPERTIES);

            p.load(file);

            rutaBD = p.getProperty(Constantes.RUTABD_PROPERTY);
            //JOptionPane.showMessageDialog(this, rutaBD);

            //----------- Curiosidad -----------//
            //p.load(this.getClass().getResourceAsStream("/dentro.properties"));
            //JOptionPane.showMessageDialog(this, p.getProperty("dentro", "defecto"));
            //----------- Curiosidad -----------//
            file.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(FramePersonas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void cargarPersonas() {
        String nombre = "personas.dat";
        FicherosDatos fd = new FicherosDatos();

        deArrayATabla(fd.cargar(nombre));
    }
    private void cargarPersonasXML(){
        FicherosDatos fd = new FicherosDatos();
        deArrayATabla(fd.cargarXML("personas.xml"));
    }
    private void cargarPersonasXstream(){
          FicherosDatos fd = new FicherosDatos();
        deArrayATabla(fd.leerPersonas());
    }

    private ArrayList<Persona> deTablaAArray() {
        Persona p = null;
        ArrayList<Persona> personas = new ArrayList();
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            p = new Persona(
                    Integer.parseInt(jTable1.getModel().getValueAt(i, Constantes.COLUMN_ID).toString()),
                    (String) jTable1.getModel().getValueAt(i, Constantes.COLUMN_NOMBRE)
            );
            personas.add(p);
        }
        return personas;
    }

    private void deArrayATabla(ArrayList<Persona> personas) {
        DefaultTableModel model = ((DefaultTableModel) jTable1.getModel());

        for (Persona p : personas) {
            model.addRow(new Object[]{p.getId(), p.getNombre()});
        }

    }

    private void deArrayListATablaCompras(ArrayList<Compra> Compras) {
        DefaultTableModel model = ((DefaultTableModel) jTable2.getModel());

        for (Compra compra : Compras) {
            model.addRow(new Object[]{compra.getCodigo(), compra.getNombre()});
        }

    }

    private ArrayList<Compra> deTablaComprasAArrayList() {

        DefaultTableModel model = ((DefaultTableModel) jTable2.getModel());
        Compra c = null;
        ArrayList<Compra> compras = new ArrayList();
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            c = new Compra(
                    Integer.parseInt(jTable2.getModel().getValueAt(i, Constantes.COLUMN_ID).toString()),
                    (String) jTable2.getModel().getValueAt(i, Constantes.COLUMN_NOMBRE)
            );
            compras.add(c);
        }
        return compras;

    }

    private void cargarDialogo(String nombre, String id) {

        String nombre2 = "compras" + nombre + id + ".xml";
        FicherosDatos fd = new FicherosDatos();
        deArrayListATablaCompras(fd.cargarComprasXML(nombre2));

//         JOptionPane.showMessageDialog(this, "Cargado correctamente");
    }

    //    
//    private LinkedHashMap<Integer,Compra> deTablaAHash(){
//            LinkedHashMap <Integer,Compra> Compras= new LinkedHashMap();
//            for(int i=0;i<jTable2.getRowCount();i++){
//               Compra compra= new Compra(
//                        Integer.parseInt(jTable2.getModel().getValueAt(i, Constantes.COLUMN_ID).toString()),
//                        (String)jTable2.getModel().getValueAt(i, Constantes.COLUMN_NOMBRE)
//                   );
//                     Compras.put(i, compra);
//            }
//            return Compras;
//        
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDialog2 = new javax.swing.JDialog();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jDialog1.setMinimumSize(new java.awt.Dimension(600, 600));
        jDialog1.setModal(true);
        jDialog1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialog1WindowClosing(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel3.setText("Compras");

        jButton6.setText("Añadir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Guardar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jLabel4.setText("Código:");

        jLabel5.setText("Nombre:");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabel3))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jDialog1Layout.createSequentialGroup()
                                    .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialog1Layout.createSequentialGroup()
                                    .addGap(329, 329, 329)
                                    .addComponent(jLabel5))))))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        jDialog2.setMinimumSize(new java.awt.Dimension(300, 300));
        jDialog2.setModal(true);

        jButton8.setText("Si");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("No");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel6.setText("      ¿Seguro que quieres salir sin guardar?");

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, Short.MAX_VALUE)
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9)))
                .addContainerGap())
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Id:");

        jLabel2.setText("Nombre:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Compras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Borrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cargar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Guardar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jButton2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

//        String nombre = "personas.dat";
//        ArrayList<Persona> personas = deTablaAArray();
//        FicherosDatos fd = new FicherosDatos();
//        fd.guardarXML(personas);
//
//        JOptionPane.showMessageDialog(this, "Guardado correctamente");
        ArrayList<Persona> personas = deTablaAArray();
        FicherosDatos fd=new FicherosDatos();
        fd.escribirPersonas(personas);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = ((DefaultTableModel) jTable1.getModel());

        int a = model.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {

            model.removeRow(i);

        }
//        FicherosDatos fd=new FicherosDatos();
//        deArrayATabla(fd.cargarXML("personas.xml"));
        FicherosDatos fd= new FicherosDatos();
        deArrayATabla(fd.leerPersonas());
        JOptionPane.showMessageDialog(this, "Cargado correctamente");

    }//GEN-LAST:event_jButton4ActionPerformed


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here: 
        boolean bandera = false;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        ArrayList<Persona> arPer = deTablaAArray();

        int id = Integer.parseInt(jTextField1.getText());
        for (int i = 0; i < arPer.size(); i++) {
            if (arPer.get(i).getId() == id) {
                bandera = true;
            }
        }
        if (bandera == false) {
            model.addRow(new Object[]{jTextField1.getText(), jTextField2.getText()});
            JOptionPane.showMessageDialog(this, "Cliente creado correctamente");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            //cargarDialogo(jTable1.getValueAt(jTable1.getSelectedRow(), Constantes.COLUMN_NOMBRE).toString(), jTable1.getValueAt(jTable1.getSelectedRow(), Constantes.COLUMN_ID).toString());
            //Cargar Compras
            DefaultTableModel model = ((DefaultTableModel) jTable2.getModel());

            int a = model.getRowCount() - 1;
            for (int i = a; i >= 0; i--) {

                model.removeRow(i);

            }

            String nombre = "Compras" + jTable1.getValueAt(jTable1.getSelectedRow(), Constantes.COLUMN_NOMBRE) + "" + jTable1.getValueAt(jTable1.getSelectedRow(), Constantes.COLUMN_ID) + ".xml";
            FicherosDatos fd = new FicherosDatos();

            deArrayListATablaCompras(fd.cargarComprasXML(nombre));
            jDialog1.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No has seleccionado ningun cliente!!!");
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String nombre = jTable1.getValueAt(jTable1.getSelectedRow(), Constantes.COLUMN_NOMBRE).toString();
        String id = jTable1.getValueAt(jTable1.getSelectedRow(), Constantes.COLUMN_ID).toString();
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada != -1) {
            model.removeRow(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna fila");
        }

        File f1 = new File("compras" + nombre + id + ".dat");
        if (f1.exists()) {
            f1.delete();
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    //Botones del jDialogo
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int filaSeleccionada = jTable2.getSelectedRow();
        if (filaSeleccionada > 0) {
            jTextField3.setText(jTable2.getModel().getValueAt(filaSeleccionada, 0).toString());
            jTextField4.setText(jTable2.getModel().getValueAt(filaSeleccionada, 1).toString());
        }

        model.addRow(new Object[]{jTextField3.getText(), jTextField4.getText()});
        //BOTON GUARDAR
//        fd.guardarCompras("compras"+
//                jTable1.getValueAt(jTable1.getSelectedRow(), Constantes.COLUMN_NOMBRE)+
//                jTable1.getValueAt(jTable1.getSelectedRow(), Constantes.COLUMN_ID), compras);
//        

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:

        //BOTON GUARDAR
        FicherosDatos fd = new FicherosDatos();
        compras = deTablaComprasAArrayList();
        fd.guardarXMLCompras(compras,
                (String)jTable1.getValueAt(jTable1.getSelectedRow(), Constantes.COLUMN_NOMBRE), 
                Integer.parseInt((String)jTable1.getValueAt(jTable1.getSelectedRow(), Constantes.COLUMN_ID)));


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }

    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }

    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
         jDialog1.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        jDialog2.setVisible(false);
        
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jDialog1WindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog1WindowClosing
        // TODO add your handling code here:
        int contador = 0, contador2 = 0;
        ArrayList<Compra> arrayTabla = deTablaComprasAArrayList();
        String nombre = "compras" + jTable1.getValueAt(jTable1.getSelectedRow(), Constantes.COLUMN_NOMBRE) + "" + jTable1.getValueAt(jTable1.getSelectedRow(), Constantes.COLUMN_ID) + ".dat";
        FicherosDatos fd = new FicherosDatos();
        ArrayList<Compra> arrayArchivo = fd.cargarCompras(nombre);
        if(arrayArchivo.size()!=arrayTabla.size()){
            jDialog2.setVisible(true);
        }
           
    }//GEN-LAST:event_jDialog1WindowClosing

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        jDialog2.setVisible(false);
        jDialog1.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FramePersonas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
