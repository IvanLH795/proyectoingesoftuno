/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GenerarReporte.java
 *
 * Created on 22-sep-2011, 15:12:58
 */

package Frontera;


import Control.ControlGeneradorReporte;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class GenerarReporte extends javax.swing.JFrame {

    /** Creates new form GenerarReporte */
    public GenerarReporte() {
            initComponents();
             vistaReporte.setEditable(false);
            }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cancelarButton = new javax.swing.JButton();
        imprimirButton = new javax.swing.JButton();
        reporteProveedores = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        vistaReporte = new javax.swing.JTextArea();
        tituloVistaReporte = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        VerButtonEvaluaciones = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        nit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SEP - Reporte");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel1.setText("Generacion de reportes");

        cancelarButton.setText("Cancelar");
        cancelarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarButtonMouseClicked(evt);
            }
        });
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        imprimirButton.setText("Imprimir");
        imprimirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirButtonActionPerformed(evt);
            }
        });

        reporteProveedores.setText("Reporte Lista Proveedores");
        reporteProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteProveedoresActionPerformed(evt);
            }
        });

        vistaReporte.setColumns(20);
        vistaReporte.setEditable(false);
        vistaReporte.setRows(5);
        jScrollPane1.setViewportView(vistaReporte);

        tituloVistaReporte.setFont(new java.awt.Font("Arial Narrow", 3, 14));
        tituloVistaReporte.setText("Vista Reporte");

        VerButtonEvaluaciones.setText("Ver");
        VerButtonEvaluaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerButtonEvaluacionesActionPerformed(evt);
            }
        });

        jButton2.setText("Reporte de Contrataciones");

        nit.setText("Nit");
        nit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nitMouseClicked(evt);
            }
        });

        jLabel2.setText("Reporte Evaluaciones Proveedor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloVistaReporte))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(imprimirButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                    .addComponent(cancelarButton))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel2))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(nit, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(VerButtonEvaluaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addComponent(reporteProveedores))
                            .addComponent(jButton2))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloVistaReporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VerButtonEvaluaciones))
                        .addGap(24, 24, 24)
                        .addComponent(reporteProveedores)
                        .addGap(33, 33, 33)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarButton)
                            .addComponent(imprimirButton))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarButtonMouseClicked
    Principal regresar = new Principal(Login.roll);
    regresar.setLocationRelativeTo(null);
    regresar.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_cancelarButtonMouseClicked

    private void reporteProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteProveedoresActionPerformed
      vistaReporte.setText("");
        ControlGeneradorReporte nuevo = new ControlGeneradorReporte();
        nuevo.imprimirPantallaReporte1(vistaReporte);
    }//GEN-LAST:event_reporteProveedoresActionPerformed

    private void imprimirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirButtonActionPerformed
        ControlGeneradorReporte nuevo = new ControlGeneradorReporte();
        File fichero = new File ( System.getProperty("user.dir"),"Reporte.txt");
        if(fichero.exists()){
        fichero.delete();
             try {
                   fichero.createNewFile();
                 } catch (IOException ioe) {
                       ioe.printStackTrace();
                 }
        }
        try {
            if(!(vistaReporte.getText().isEmpty())){
            nuevo.imprimirReporte(fichero, vistaReporte.getText());
            JOptionPane.showMessageDialog(this,"Archivo Impreso", "",JOptionPane.WARNING_MESSAGE);
            Principal regresar = new Principal(Login.roll);
            regresar.setLocationRelativeTo(null);
            regresar.setVisible(true);
            this.dispose();
            }
            else
            JOptionPane.showMessageDialog(this,"Error...", "",JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(GenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_imprimirButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void VerButtonEvaluacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerButtonEvaluacionesActionPerformed
        if(!nit.getText().isEmpty()){
        vistaReporte.setText("");
        ControlGeneradorReporte nuevo = new ControlGeneradorReporte();
        nuevo.imprimirPantallaReporte2(vistaReporte,nit.getText());
        }
        else
          JOptionPane.showMessageDialog(this,"necesita especificar un Nit valido", "",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_VerButtonEvaluacionesActionPerformed

    private void nitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nitMouseClicked
        nit.setText("");
    }//GEN-LAST:event_nitMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VerButtonEvaluaciones;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton imprimirButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nit;
    private javax.swing.JButton reporteProveedores;
    private javax.swing.JLabel tituloVistaReporte;
    private javax.swing.JTextArea vistaReporte;
    // End of variables declaration//GEN-END:variables

}


