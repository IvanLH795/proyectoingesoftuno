/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Entidad.ProductoProveedor;
import Entidad.Proveedores;
import Entidad.Sistema;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        String proveedor1 = "";
             for (Proveedores u: provee.getProveedores()){
                 try{
                    for(ProductoProveedor u1: u.getProductos()){
                        productos = productos + u1.getNombreProducto() + "\t\t" + u1.getPrecio() + "\n";
                    }
                }catch(NullPointerException ex){
                    productos = "";
                }

           proveedor1 =  "Nombre: " + u.getNombre() + "\n" +
                         "Nit: " + u.getNit() + "\n" +
                         "Calidad: " + u.getCalidad() + "\n" +
                         "Fiabilidad: " + u.getFiabilidad() + "\n" +
                         "Cercania: " + u.getCercania() + "\n" +
                         "Adaptabilidad: " + u.getAdaptabilidad() + "\n" +
                         "Representante: " + u.getRepresentante() + "\n" +
                         "Correo: " + u.getCorreo() + "\n" +
                         "Telefono: " + u.getTelefono() + "\n" +
                         "Pagina Web: " + u.getPaginaWeb() + "\n" +
                         "Productos:\n" +
                         "Nombre\t\t" + "Precio\n" +
                         productos +
                         "Comentarios: " + u.getComentarios() + "\n";
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
    }
}
