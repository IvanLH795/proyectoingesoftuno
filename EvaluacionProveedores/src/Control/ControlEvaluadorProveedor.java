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
    public String compararProveedor(int nit){
        Proveedores v = buscarProveedor(nit);
        if(v == null){
            return "Proveedor no encontrado";
        }
        return "Proveedor encontrado";
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
    public String validarDatos(String calidad, String fiabilidad, String adaptabilidad, String comentarios){
        if(Float.parseFloat(calidad)>= 0 && Float.parseFloat(calidad) <= 100){
                if(Float.parseFloat(fiabilidad)>=0 && Float.parseFloat(fiabilidad)<=100){
                            return "Succes";
                }else{
                    return "Error Fiabilidad";
                }
        }else{
            return "Error Calidad";
        }
    }
      public void ingresarEvaluacionProveedor(Proveedores anterior, Proveedores actualizado){
                anterior = actualizado;
    }
}
//valida los datos ingresados y despues los actualiza para el proveedor ingresado