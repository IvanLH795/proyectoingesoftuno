/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;
/**
 *
 * @author Beltrán
 */
import Entidad.Proveedores;
import Entidad.Sistema;
public class ControlEvaluadorProveedor {
    Sistema sistem = new Sistema();
    public ControlEvaluadorProveedor() {
    }
    public Proveedores buscarProveedor(int nit){

            Sistema sistema = Frontera.Splash.sistema;
            for (Proveedores u: sistema.getProveedores()){
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

    public void setSistem(Sistema sistem) {
        this.sistem = sistem;
    }

public String buscar(int nit){

           
            for (Proveedores u: sistem.getProveedores()){
                if (u.getNit()== nit){
                    return "Proveedor Encontrado";
                }
            }
            return "Proveedor No Encontrado";
    }
  public String validar(double calidad, double fiabilidad, String comentarios){
        if(calidad >= 0 && calidad <= 100 && fiabilidad>=0 && fiabilidad<=100 &&  comentarios.length()>=0 && comentarios.length()<=100 ){
        return "Datos Correctos";
        }
        else
        return "Datos Incorrectos";
    }

   
}
//valida los datos ingresados y despues los actualiza para el proveedor ingresado