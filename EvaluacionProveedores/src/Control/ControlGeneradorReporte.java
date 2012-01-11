/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Entidad.Evaluaciones;
import Entidad.ProductoProveedor;
import Entidad.Proveedores;
import Entidad.Sistema;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Darthian
 */
public class ControlGeneradorReporte {

 public ControlGeneradorReporte() {
    }
 public void imprimirPantallaReporte1(JTextArea vistaReporte) {

        Sistema provee = Frontera.Splash.sistema;
        String productos = "";
        String evaluaciones = "Calidad\t\tFiabilidad\t\tFecha\n";
        String proveedor1 = "";
        for (Proveedores u: provee.getProveedores()){
            try{
                for(ProductoProveedor u1: u.getProductos()){
                    productos = productos + u1.getNombreProducto() + "\t\t" + u1.getPrecioPorUnidad() + "\n";
                }
            }catch(NullPointerException ex){
                productos = "";
            }
            try{
                for(Evaluaciones u2: u.getEvaluaciones()){
                    evaluaciones = evaluaciones + u2.getCalidad() + "\t\t" + u2.getFiabilidad() + "\t\t"
                            + u2.getAnio() + "/" + u2.getMes() + "/" + u2.getDia() + " " + u2.getHora() + ":" + u2.getMini() + "\n";
                    if(u2.getComentarios() != null)
                        evaluaciones = evaluaciones + "Comentario: " + u2.getComentarios() + "\n";
            }
            }catch(NullPointerException ex){
                evaluaciones = "Calidad\t\tFiabilidad\t\tFecha\n";
            }

           proveedor1 =  "Nombre: " + u.getNombre() + "\n" +
                         "Nit: " + u.getNit() + "\n" +
                         evaluaciones + "\n" +
                         "Representante: " + u.getRepresentante() + "\n" +
                         "Correo: " + u.getCorreo() + "\n" +
                         "Telefono: " + u.getTelefono() + "\n" +
                         "Pagina Web: " + u.getPaginaWeb() + "\n" +
                         "Productos:\n" +
                         "Nombre\t\t" + "Precio\n" +
                         productos + "\n";
             vistaReporte.append(proveedor1);
             vistaReporte.append(System.getProperty("line.separator")); // Esto para el salto de línea
        }
 }

    public void imprimirPantallaReporte2(JTextArea vistaReporte, String Nit) {
         int nit  = Integer.parseInt(Nit);
         Proveedores nuevo = null;
         Sistema provee = Frontera.Splash.sistema;
          for (Proveedores u: provee.getProveedores()){
          if(u.getNit()== nit){
            nuevo = u;
          }
          }
         if (nuevo != null){
             String Evaluaciones ="";
             try{
             for(int i = 0; i < nuevo.getEvaluaciones().size();i++){
             Evaluaciones  = Evaluaciones +"\n\n"+ "Evaluacion numero:  " + i +"\n\n";
             Evaluaciones  = Evaluaciones +"Adaptabilidad:  "+ nuevo.getEvaluaciones().get(i).getAdaptabilidad()+"\n";
             Evaluaciones  = Evaluaciones +"Cercania:  " + nuevo.getEvaluaciones().get(i).getCercania()+"\n";
             Evaluaciones  = Evaluaciones +"Comentarios:  " + nuevo.getEvaluaciones().get(i).getComentarios()+"\n";
             Evaluaciones  = Evaluaciones +"Calidad:  " +  nuevo.getEvaluaciones().get(i).getCalidad()+"\n";
             Evaluaciones  = Evaluaciones +"Fiabilidad:  " + nuevo.getEvaluaciones().get(i).getFiabilidad()+"\n";
             Evaluaciones  = Evaluaciones +"Anio:  " + nuevo.getEvaluaciones().get(i).getAnio()+" ";
             Evaluaciones  = Evaluaciones +"Mes:  " +  nuevo.getEvaluaciones().get(i).getMes()+" ";
             Evaluaciones  = Evaluaciones +"Dia:  " +  nuevo.getEvaluaciones().get(i).getDia()+" ";
             Evaluaciones  = Evaluaciones +"Hora:  " +  nuevo.getEvaluaciones().get(i).getHora()+" ";
             Evaluaciones  = Evaluaciones +"Min:  " +  nuevo.getEvaluaciones().get(i).getMini()+"\n";
             }}catch(IndexOutOfBoundsException ex){}
            vistaReporte.setText(Evaluaciones);
         }
         else {JOptionPane.showMessageDialog(frame,"nit no encontrado", "",JOptionPane.WARNING_MESSAGE);}

    }

    public void imprimirReporte(File fichero, String text) throws IOException {
        boolean k = true;
         try{
             PrintWriter fileout = new PrintWriter(new FileWriter(fichero , k));
             fileout.print(text);
             fileout.flush();
             fileout.close();
         }catch(IOException ex){
             throw ex;
         }
        try {
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            desktop.print(fichero);
        } catch (IOException ioe) {
        JOptionPane.showMessageDialog(frame,"Servicio de Impresión no disponible", "",JOptionPane.WARNING_MESSAGE);
ioe.printStackTrace();
        }
    }

JFrame frame;

    public void imprimirPantallaReporte3(JTextArea vistaReporte) {
       Sistema provee = Frontera.Splash.sistema;
       String VerContratos = "";
       List<String> Contratos = null;
        try {
       Contratos = provee.getListaContratos();
       for(int i = 0; i< Contratos.size();i++){
           VerContratos = VerContratos + Contratos.get(i);
       }
       vistaReporte.setText(VerContratos);
    }catch(NullPointerException ex){}
       if(Contratos == null)
        JOptionPane.showMessageDialog(frame,"No hay contratos existentes", "",JOptionPane.WARNING_MESSAGE);
    }

}