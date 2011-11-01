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

/**
 *
 * @author Fernando
 */
public class GenerarReporte extends javax.swing.JFrame {

    /** Creates new form GenerarReporte */
    public GenerarReporte() {
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SEP - Reporte");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Generacion de reportes");

        cancelarButton.setText("Cancelar");
        cancelarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarButtonMouseClicked(evt);
            }
        });

        imprimirButton.setText("Imprimir");
        imprimirButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imprimirButtonMouseClicked(evt);
            }
        });

        reporteProveedores.setText("Reporte Lista Proveedores");
        reporteProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteProveedoresActionPerformed(evt);
            }
        });

        vistaReporte.setColumns(20);
        vistaReporte.setRows(5);
        jScrollPane1.setViewportView(vistaReporte);

        tituloVistaReporte.setText("Vista Reporte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelarButton)
                                .addGap(18, 18, 18)
                                .addComponent(imprimirButton))
                            .addComponent(reporteProveedores))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloVistaReporte)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(tituloVistaReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(reporteProveedores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarButton)
                            .addComponent(imprimirButton))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarButtonMouseClicked
    Principal regresar = new Principal(Login.roll);
    regresar.setLocationRelativeTo(null);
    regresar.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_cancelarButtonMouseClicked

    private void imprimirButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imprimirButtonMouseClicked
    
    }//GEN-LAST:event_imprimirButtonMouseClicked

    private void reporteProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteProveedoresActionPerformed
       
    }//GEN-LAST:event_reporteProveedoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton imprimirButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reporteProveedores;
    private javax.swing.JLabel tituloVistaReporte;
    private javax.swing.JTextArea vistaReporte;
    // End of variables declaration//GEN-END:variables

}
