/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Model.ProductoProveedor;
import Model.Proveedores;
import Model.Sistema;
import java.util.List;

/**
 *
 * @author Darthian
 */
public class ControlAdministrarProveedor {

    public void crearProveedor(String nombre, int nit, String direccion, String correo,
            String representante, String pagina, int telefono, List<ProductoProveedor> productos){

            Proveedores proveedor = new Proveedores();
            Sistema provee = View.Main.provee;

            proveedor.setNombre(nombre);
            proveedor.setNit(nit);
            proveedor.setDireccion(direccion);
            proveedor.setCorreo(correo);
            proveedor.setRepresentante(representante);
            proveedor.setPaginaWeb(pagina);
            proveedor.setTelefono(telefono);
            proveedor.setProductos(productos);
            provee.getProveedores().add(proveedor);
    }
    public void modificarProveedor(){



    }
    public void borrarProveedor(String nombre, int nit){

            Sistema provee = View.Main.provee;

            for (Proveedores u: provee.getProveedores()){
                if (u.getNombre().equals(nombre) && (u.getNit()==nit)){
                    provee.getProveedores().remove(u);
                    break;
                }
            }
    }
    public Proveedores buscarProveedor(String nombre, int nit){
            
            Sistema provee = View.Main.provee;
            for (Proveedores u: provee.getProveedores()){
                if (u.getNombre().equals(nombre) && (u.getNit()==nit)){
                    return u;
                }
            }
            return null;
    }
}
