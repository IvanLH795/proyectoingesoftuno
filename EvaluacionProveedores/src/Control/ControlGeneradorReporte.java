/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Entidad.ProductoProveedor;
import Entidad.Proveedores;
import Entidad.Sistema;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Darthian
 */
public class ControlGeneradorReporte {

    public ControlGeneradorReporte() {
    }

  public File imprimirADocumento(){
       File fichero = new File ("C:/Users/Beltran/Documents/NetBeansProjects/proyectoingesoftuno/EvaluacionProveedores/src/Frontera/reporteProveedores.txt");
        if(fichero.exists()){
        fichero.delete();
             try {
                   fichero.createNewFile();
                 } catch (IOException ioe) {
                       ioe.printStackTrace();
                 }
        }
        Sistema sistema = Frontera.Splash.sistema;
        String productos = "";
        String proveedor1 = "";

             for (Proveedores u: sistema.getProveedores()){
                 try{
                    for(ProductoProveedor u1: u.getProductos()){
                        productos = productos + u1.getNombreProducto() + "\t\t" + u1.getPrecio() + "\n";
                    }
                }catch(NullPointerException ex){
                    productos = "";
                }

  proveedor1 =  "Nombre: " + u.getNombre() + "\n" + "Nit: " + u.getNit() + "\n" +"Calidad: " + u.getCalidad() + "\n" +"Fiabilidad: " + u.getFiabilidad() + "\n" +"Cercania: " + u.getCercania() + "\n" +"Adaptabilidad: " + u.getAdaptabilidad() + "\n" + "Representante: " + u.getRepresentante() + "\n" + "Correo: " + u.getCorreo() + "\n" +"Telefono: " + u.getTelefono() + "\n" +"Pagina Web: " + u.getPaginaWeb() + "\n" + "Productos:\n" +"Nombre\t\t" + "Precio\n" + productos + "Comentarios: " + u.getComentarios() + "\n\n\n\n\n\n";
  try{
  saveString(fichero,proveedor1);

  }catch(IOException ex){
 }catch(NullPointerException ex){fichero.deleteOnExit();}
}
return fichero;
   }
     public static void saveString(File f,String s) throws IOException{
        boolean k = true;
         try{
             PrintWriter fileout = new PrintWriter(new FileWriter(f , k));
             fileout.print(s);
             fileout.flush();
             fileout.close();
         }catch(IOException ex){
             throw ex;
         }
    }
     public  void readLines(File f,String texto) throws FileNotFoundException, IOException{
         try{
             BufferedReader fileIn = new BufferedReader(new FileReader(f));
             String line = "";
             while ((line = fileIn.readLine()) != null){
                 texto+=line;
             }
             fileIn.close();
         }catch(FileNotFoundException ex){
         throw ex;}
         catch(IOException ex){
         throw ex;}
     }

}
