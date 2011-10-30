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

            Sistema listaProveedores = View.Splash.listaProveedores;
            for (Proveedores u: listaProveedores.getProveedores()){
                if (u.getNit()==nit){
                    return u;
                }
            }
            return null;
    }
    public boolean validarDatos(String calidad, String fiabilidad, String adaptabilidad, String comentarios){
        if(Float.parseFloat(calidad) >= 0 && Float.parseFloat(calidad) <= 100 && Float.parseFloat(fiabilidad)>=0 && Float.parseFloat(fiabilidad)<=100 &&  comentarios.length()>=0 && comentarios.length()<=100 ){
        return true;
        }
        else
        return false;
    }
      public void ingresarEvaluacionProveedor(Proveedores anterior, Proveedores actualizado){
                anterior = actualizado;
    }


   
}
//valida los datos ingresados y despues los actualiza para el proveedor ingresado