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
 public String imprimirPantallaReporte1(JTextArea vistaReporte) {
        String salida = "Fail";
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
                            + u2.getFecha() + "\n";
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
             salida = "Succes";
        }
        return salida;
 }

    public String imprimirPantallaReporte2(JTextArea vistaReporte, String Nit) {
         String salida = "Fail";
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
             Evaluaciones  = Evaluaciones +"Fecha:  " + nuevo.getEvaluaciones().get(i).getFecha()+"\n";
             }}catch(IndexOutOfBoundsException ex){}
            vistaReporte.setText(Evaluaciones);
            salida = "Succes";
         }
         else {JOptionPane.showMessageDialog(frame,"nit no encontrado", "",JOptionPane.WARNING_MESSAGE);}
         return salida;
    }

    public String imprimirReporte(File fichero, String text) throws IOException {
        String salida="Fail";
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
                salida ="Succes";
            }
            desktop.print(fichero);
        } catch (IOException ioe) {
        JOptionPane.showMessageDialog(frame,"Servicio de Impresión no disponible", "",JOptionPane.WARNING_MESSAGE);
ioe.printStackTrace();
        }
        return salida;
    }

JFrame frame;

    public String imprimirPantallaReporte3(JTextArea vistaReporte) {
       String salida ="Succes";
       Sistema provee = Frontera.Splash.sistema;
       String VerContratos = "";
       List<String> Contratos = null;
        try {
       Contratos = provee.getListaContratos();
       for(int i = 0; i< Contratos.size();i++){
           VerContratos = VerContratos + Contratos.get(i);
       }
       vistaReporte.setText(VerContratos);
       salida = "Succes";
    }catch(NullPointerException ex){}
       if(Contratos == null)
        JOptionPane.showMessageDialog(frame,"No hay contratos existentes", "",JOptionPane.WARNING_MESSAGE);
       return salida;
    }    
}