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
 public void imprimirPantalla(JTextArea vistaReporte) {

        Sistema provee = Frontera.Splash.sistema;
        String productos = "";
        String evaluaciones = "Calidad\t\tFiabilidad\t\tFecha\n";
        String proveedor1 = "";
        for (Proveedores u: provee.getProveedores()){
            try{
                for(ProductoProveedor u1: u.getProductos()){
                    productos = productos + u1.getNombreProducto() + "\t\t" + u1.getPrecio() + "\n";
                }
            }catch(NullPointerException ex){
                productos = "";
            }
            try{
                for(Evaluaciones u2: u.getEvaluaciones()){
                    evaluaciones = evaluaciones + u2.getCalidad() + "\t\t" + u2.getFiabilidad() + "\t\t"
                            + u2.getAnio() + "/" + u2.getMes() + "/" + u2.getDia() + " " + u2.getHora() + ":" + u2.getMin() + "\n";
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
}