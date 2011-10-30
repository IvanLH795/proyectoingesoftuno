/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Model.Proveedores;
import Model.Sistema;

/**
 *
 * @author Darthian
 */
public class ControlAdministrarProveedor {

    public void crearProveedor(Proveedores u){
            Sistema provee = Frontera.Splash.listaProveedores;
            provee.getProveedores().add(u);
    }

    public void modificarProveedor(Proveedores viejo, Proveedores nuevo){
            if(!viejo.equals(nuevo)){
                viejo.setNombre(nuevo.getNombre());
                viejo.setNit(nuevo.getNit());
                viejo.setDireccion(nuevo.getDireccion());
                viejo.setCorreo(nuevo.getCorreo());
                viejo.setRepresentante(nuevo.getRepresentante());
                viejo.setPaginaWeb(nuevo.getPaginaWeb());
                viejo.setTelefono(nuevo.getTelefono());
                viejo.setProductos(null);
            }
    }

    public void borrarProveedor(String nombre, int nit){

            Sistema provee = Frontera.Splash.listaProveedores;

            for (Proveedores u: provee.getProveedores()){
                if (u.getNombre().equals(nombre) && (u.getNit()==nit)){
                    provee.getProveedores().remove(u);
                    break;
                }
            }
    }

    public Proveedores buscarProveedor(String nombre, int nit){
            
            Sistema provee = Frontera.Splash.listaProveedores;
            for (Proveedores u: provee.getProveedores()){
                if (u.getNombre().equals(nombre) && (u.getNit()==nit)){
                    return u;
                }
            }
            return null;
    }
}
