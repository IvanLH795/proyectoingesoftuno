/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Entidad.ProductoProveedor;
import Entidad.Proveedores;
import Entidad.Sistema;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
                if (u.getNombre().equals(nombre) || ((Integer)u.getNit()).equals((Integer)nit)){
                    provee.getProveedores().remove(u);
                    break;
                }
            }
    }

    public Proveedores buscarProveedor(String nombre, Integer nit){

            Sistema provee = Frontera.Splash.listaProveedores;

            for (Proveedores u: provee.getProveedores()){
                if (u.getNombre().equals(nombre) || ((Integer)u.getNit()).equals(nit)){
                    return u;
                }
            }
            return null;
    }

    public Proveedores buscarProveedor(String nombre){

            Sistema provee = Frontera.Splash.listaProveedores;
            for (Proveedores u: provee.getProveedores()){
                if (u.getNombre().equals(nombre)){
                    return u;
                }
            }
            return null;
    }

    public Proveedores buscarProveedor(Integer obj) {
            Sistema provee = Frontera.Splash.listaProveedores;
            for (Proveedores u: provee.getProveedores()){
                if (((Integer)u.getNit()).equals(obj)){
                    return u;
                }
            }
            return null;
    }

    public Proveedores buscarProveedor(){
        return null;
    }

    public void modificarProveedor(Proveedores viejo, Proveedores nuevo, Vector listaproductos) {
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

        List<ProductoProveedor> lista = new ArrayList();
        ProductoProveedor producto = new ProductoProveedor();
        for(int i=0; i<listaproductos.size();i++){
                if(i%2==0){
                    producto.setNombreProducto((String)listaproductos.get(i));
                }
                else{
                    producto.setPrecio((Float)listaproductos.get(i));
                    if(!listaproductos.get(i-1).equals(null))
                        lista.add(producto);
                }
        }
        viejo.setProductos(lista);
    }

    public void crearProveedor(Proveedores proveedor2, Vector listaproductos) {
         List<ProductoProveedor> lista = new ArrayList();
        ProductoProveedor producto = new ProductoProveedor();
        for(int i=0; i<listaproductos.size();i++){
                if(i%2==0){
                    producto.setNombreProducto((String)listaproductos.get(i));
                }
                else{
                    producto.setPrecio((Float)listaproductos.get(i));
                    if(!listaproductos.get(i-1).equals(null))
                        lista.add(producto);
                }
        }
        proveedor2.setProductos(lista);
        Sistema provee = Frontera.Splash.listaProveedores;
        provee.getProveedores().add(proveedor2);
    }
}
