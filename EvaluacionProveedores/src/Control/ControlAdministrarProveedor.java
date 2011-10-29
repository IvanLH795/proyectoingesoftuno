/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Model.Proveedores;
import Model.Sistema;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darthian
 */
public class ControlAdministrarProveedor {

    public void crearProveedor(String nombre, int nit, String direccion, String correo,
            String representante, String pagina, int telefono){

            Proveedores proveedor = new Proveedores();
            List<Proveedores> proveedores = new ArrayList<Proveedores>();
            Sistema sistema = View.Main.sistem;

            proveedor.setNombre(nombre);
            proveedor.setNit(nit);
            proveedor.setDireccion(direccion);
            proveedor.setCorreo(correo);
            proveedor.setRepresentante(representante);
            proveedor.setPaginaWeb(pagina);
            proveedor.setTelefono(telefono);
            proveedores.add(proveedor);
            sistema.setProveedores(proveedores);
    }
    public void modificarProveedor(){

    }
    public void borrarProveedor(){

    }
    public void buscarProveedor(String nombre, int nit){
        
    }
}
