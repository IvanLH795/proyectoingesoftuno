/*
 * EvaluarProveedor.java
 *
 * Created on 24/10/2011, 03:07:53 PM
 */
package Frontera;

import Control.ControlEvaluadorProveedor;
import javax.swing.JOptionPane;
import Model.Proveedores;
/**
 * @author Beltrán
 */
public class EvaluarProveedor extends javax.swing.JFrame {

    /** Creates new form EvaluarProveedor */
    public EvaluarProveedor() {
        initComponents();
        for(int i=0;i<evaluacionPanel.getComponents().length;i++) {   //inicialmente se desabilitan los campos del panel evaluacion mientras no se verifique de que3 proveedor son.
        evaluacionPanel.getComponent(i).setEnabled(false);}
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        nitProveedorTextField = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        evaluacionPanel = new javax.swing.JPanel();
        calidadProductosLabel = new javax.swing.JLabel();
        fiabilidadEntregaLabel = new javax.swing.JLabel();
        cercaniaGeograficaLabel = new javax.swing.JLabel();
        AdaptabilidadLabel = new javax.swing.JLabel();
        calidadProductosTextField = new javax.swing.JTextField();
        fiabilidadEntregaTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cercaniaGeograficaSeleccion = new javax.swing.JComboBox();
        adaptabilidadSeleccion = new javax.swing.JComboBox();
        comentariosLabel = new javax.swing.JLabel();
        ingresarEvaluacionButton = new javax.swing.JButton();
        regresarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        comentariosTextField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jLabel1, org.jdesktop.beansbinding.ELProperty.create("Evaluación"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        jLabel1.setText("Evaluar Proveedor");

        nitProveedorTextField.setText("NIT proveedor");
        nitProveedorTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nitProveedorTextFieldMouseClicked(evt);
            }
        });

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        evaluacionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Evaluación"));

        calidadProductosLabel.setText("Calidad de los productos");

        fiabilidadEntregaLabel.setText("Fiabilidad de la entrega");

        cercaniaGeograficaLabel.setText("Cercania geográfica");

        AdaptabilidadLabel.setText("Adaptabilidad");

        jLabel6.setText("%");

        jLabel7.setText("%");

        cercaniaGeograficaSeleccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bogotá", "...", "...", "...", " " }));

        adaptabilidadSeleccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alta", "Media", "Baja" }));

        comentariosLabel.setText("Comentarios");

        ingresarEvaluacionButton.setText("Ingresar Evaluación");
        ingresarEvaluacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarEvaluacionButtonActionPerformed(evt);
            }
        });

        regresarButton.setText("Regresar");
        regresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarButtonActionPerformed(evt);
            }
        });

        comentariosTextField.setColumns(20);
        comentariosTextField.setRows(5);
        jScrollPane1.setViewportView(comentariosTextField);

        javax.swing.GroupLayout evaluacionPanelLayout = new javax.swing.GroupLayout(evaluacionPanel);
        evaluacionPanel.setLayout(evaluacionPanelLayout);
        evaluacionPanelLayout.setHorizontalGroup(
            evaluacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(evaluacionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(evaluacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(evaluacionPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(evaluacionPanelLayout.createSequentialGroup()
                        .addGroup(evaluacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calidadProductosLabel)
                            .addComponent(fiabilidadEntregaLabel)
                            .addComponent(cercaniaGeograficaLabel)
                            .addComponent(AdaptabilidadLabel))
                        .addGap(35, 35, 35)
                        .addGroup(evaluacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adaptabilidadSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cercaniaGeograficaSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(evaluacionPanelLayout.createSequentialGroup()
                                .addGroup(evaluacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fiabilidadEntregaTextField)
                                    .addComponent(calidadProductosTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                .addGroup(evaluacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(evaluacionPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, evaluacionPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)))))
                        .addContainerGap(128, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, evaluacionPanelLayout.createSequentialGroup()
                        .addComponent(ingresarEvaluacionButton)
                        .addGap(48, 48, 48)
                        .addComponent(regresarButton)
                        .addGap(23, 23, 23))
                    .addGroup(evaluacionPanelLayout.createSequentialGroup()
                        .addComponent(comentariosLabel)
                        .addContainerGap(279, Short.MAX_VALUE))))
        );
        evaluacionPanelLayout.setVerticalGroup(
            evaluacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(evaluacionPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(evaluacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calidadProductosLabel)
                    .addComponent(calidadProductosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(evaluacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiabilidadEntregaLabel)
                    .addComponent(fiabilidadEntregaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(evaluacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cercaniaGeograficaLabel)
                    .addComponent(cercaniaGeograficaSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(evaluacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adaptabilidadSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdaptabilidadLabel))
                .addGap(20, 20, 20)
                .addComponent(comentariosLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(evaluacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regresarButton)
                    .addComponent(ingresarEvaluacionButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(evaluacionPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(nitProveedorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(Buscar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nitProveedorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar))
                .addGap(35, 35, 35)
                .addComponent(evaluacionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nitProveedorTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nitProveedorTextFieldMouseClicked
       nitProveedorTextField.setText("");
    }//GEN-LAST:event_nitProveedorTextFieldMouseClicked

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
    Principal regresarMenu = new Principal(); //nos devuelve al Menu Principal
    regresarMenu.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_regresarButtonActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        ControlEvaluadorProveedor nuevo = new ControlEvaluadorProveedor();
        proveedor = nuevo.buscarProveedor(Integer.parseInt(nitProveedorTextField.getText()));
        if(!(nuevo.buscarProveedor(Integer.parseInt(nitProveedorTextField.getText())).equals(null))){  //revisa si el proveedor indicado existe
            for(int i=0;i<evaluacionPanel.getComponents().length;i++) {      //habilita los componentes del panel de evaluacion
          evaluacionPanel.getComponent(i).setEnabled(true);
               }//end for
            if(proveedor.isEvaluacionRealizada() == true){      //revisa si el proveedor ya tiene una calificacion anterior, en tal caso, presenta los datos
              calidadProductosTextField.setText(Float.toString(proveedor.getCalidad()));
              fiabilidadEntregaTextField.setText(Float.toString(proveedor.getFiabilidad()));
              cercaniaGeograficaSeleccion.setToolTipText(proveedor.getCercania());
              adaptabilidadSeleccion.setToolTipText(proveedor.getAdaptabilidad());
              comentariosTextField.setText(proveedor.getComentarios());
            }
        }else //si el usuario no se encuentra en la base de datos manda el msn "usuario no encontrado"
          JOptionPane.showMessageDialog(this,"Usuario No Encontrado", "Advertencia!",JOptionPane.WARNING_MESSAGE); 
    }//GEN-LAST:event_BuscarActionPerformed

    private void ingresarEvaluacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarEvaluacionButtonActionPerformed
          ControlEvaluadorProveedor nuevo = new ControlEvaluadorProveedor();
          proveedor = nuevo.buscarProveedor(Integer.parseInt(nitProveedorTextField.getText()));
       if(nuevo.validarDatos(calidadProductosTextField.getText(), fiabilidadEntregaTextField.getText() ,adaptabilidadSeleccion.getToolTipText(), cercaniaGeograficaSeleccion.getToolTipText())){
      Proveedores proveedor1 = new Proveedores();
        proveedor1 = proveedor;  //capturar datos
        proveedor1.setCalidad(Float.parseFloat(calidadProductosTextField.getText()));
        proveedor1.setFiabilidad(Float.parseFloat(fiabilidadEntregaTextField.getText()));
        proveedor1.setAdaptabilidad(adaptabilidadSeleccion.getToolTipText());
        proveedor1.setCercania(cercaniaGeograficaSeleccion.getToolTipText());
        proveedor1.setComentarios(comentariosTextField.getText());
        proveedor1.setEvaluacionRealizada(true); //aclara q el proveedor ya tuvo minimo una evaluacion
        nuevo.ingresarEvaluacionProveedor(proveedor, proveedor1);  //ingresar la evaluacion en el arreglo de proveedores
        JOptionPane.showMessageDialog(this,"Evaluacion Guardada", "",JOptionPane.WARNING_MESSAGE);
       }
       else   //manda el msn "Datos invalidos" cuando algun dato no cumple los requisitos
            JOptionPane.showMessageDialog(this,"Datos Inválidos", "Advertencia!",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_ingresarEvaluacionButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdaptabilidadLabel;
    private javax.swing.JButton Buscar;
    private javax.swing.JComboBox adaptabilidadSeleccion;
    private javax.swing.JLabel calidadProductosLabel;
    private javax.swing.JTextField calidadProductosTextField;
    private javax.swing.JLabel cercaniaGeograficaLabel;
    private javax.swing.JComboBox cercaniaGeograficaSeleccion;
    private javax.swing.JLabel comentariosLabel;
    private javax.swing.JTextArea comentariosTextField;
    private javax.swing.JPanel evaluacionPanel;
    private javax.swing.JLabel fiabilidadEntregaLabel;
    private javax.swing.JTextField fiabilidadEntregaTextField;
    private javax.swing.JButton ingresarEvaluacionButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nitProveedorTextField;
    private javax.swing.JButton regresarButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
 Proveedores proveedor = new Proveedores();
}
