/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;
/**
 *
 * @author Beltrán
 */
import Model.Proveedores;
import Model.Sistema;
public class ControlEvaluadorProveedor {

    public ControlEvaluadorProveedor() {
    }
    public Proveedores buscarProveedor(int nit){

            Sistema provee = View.Main.provee;
            for (Proveedores u: provee.getProveedores()){
                if (u.getNit()==nit){
                    return u;
                }
            }
            return null;
    }
    public boolean validarDatos(String calidad, String fiabilidad, String adaptabilidad, String comentarios){
        if(Integer.parseInt(calidad) >= 0 && Integer.parseInt(calidad) <= 100 && Integer.parseInt(fiabilidad)>=0 && Integer.parseInt(fiabilidad)<=100 &&  comentarios.length()>=0 && comentarios.length()<=100 ){
        return true;
        }
        else
        return false;
    }
      public void ingresarEvaluacionProveedor(Proveedores viejo, Proveedores nuevo){
                viejo = nuevo;
    }


   
}
//valida los datos ingresados y despues los actualiza para el proveedor ingresado