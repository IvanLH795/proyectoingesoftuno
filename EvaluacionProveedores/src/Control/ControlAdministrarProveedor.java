/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Entidad.ProductoProveedor;
import Entidad.Proveedores;
import Entidad.Sistema;
import Frontera.Splash;
import dao.proveedoresDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Darthian
 */
public class ControlAdministrarProveedor {
    
    proveedoresDAO proveedorPersistente = new proveedoresDAO();

    public String crearProveedor(Proveedores u){
        if(validarProveedorNit(u.getNit())){
            if(validarProveedorTel(u.getTelefono()) || u.getTelefono()== 0){
                Sistema sistema = Frontera.Splash.sistema;
                sistema.getProveedores().add(u);
                proveedorPersistente.crear(u);
                return "Succes";
            }else{
                return "Telefono invalido";
            }
        }
        else{
            return "Nit invalido";
        }
    }

    public String modificarProveedor(Proveedores viejo, Proveedores nuevo){
        if(validarProveedorNit(nuevo.getNit())){
            if(validarProveedorTel(nuevo.getTelefono()) || nuevo.getTelefono()== 0){
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
                proveedorPersistente.actualizar(viejo, nuevo);
                return "Succes";
            }
            else{
                return "Telefono invalido";
            }
        }
        else{
            return "Nit invalido";
        }
    }

    public String borrarProveedor(String nombre, int nit){

            Sistema sistema = Frontera.Splash.sistema;

            for (Proveedores u: sistema.getProveedores()){
                if (u.getNombre().equals(nombre) || ((Integer)u.getNit()).equals((Integer)nit)){
                    sistema.getProveedores().remove(u);
                    proveedorPersistente.eliminar(u);
                    return "Succes";
                }
            }
            return "Falla";
    }

    public Proveedores buscarProveedor(String nombre, Integer nit){
            Sistema sistema = Frontera.Splash.sistema;
            for (Proveedores u: sistema.getProveedores()){
                if (u.getNombre().equals(nombre) || ((Integer)u.getNit()).equals(nit)){
                    proveedorPersistente.leer(u);
                    return u;
                }
            }
            return null;
    }

    public Proveedores buscarProveedor(String nombre){
            Sistema sistema = Frontera.Splash.sistema;
            for (Proveedores u: sistema.getProveedores()){
                if (u.getNombre().equals(nombre)){
                    proveedorPersistente.leer(u);
                    return u;
                }
            }
            return null;
    }

    public Proveedores buscarProveedor(Integer obj) {
            Sistema sistema = Frontera.Splash.sistema;
            for (Proveedores u: sistema.getProveedores()){
                if (((Integer)u.getNit()).equals(obj)){
                    proveedorPersistente.leer(u);
                    return u;
                }
            }
            return null;
    }

    public Proveedores buscarProveedor(){
        return null;
    }

    public String modificarProveedor(Proveedores viejo, Proveedores nuevo, Vector listaproductos) {
        if(validarProveedorNit(nuevo.getNit())){
            if(validarProveedorTel(nuevo.getTelefono()) || nuevo.getTelefono()== 0){
                viejo.setNombre(nuevo.getNombre());
                viejo.setNit(nuevo.getNit());
                viejo.setDireccion(nuevo.getDireccion());
                viejo.setCorreo(nuevo.getCorreo());
                viejo.setRepresentante(nuevo.getRepresentante());
                viejo.setPaginaWeb(nuevo.getPaginaWeb());
                viejo.setTelefono(nuevo.getTelefono());

                if(!(Splash.listaproductos == null)){
                    List<ProductoProveedor> lista = new ArrayList();
                    for(int i=0; i<listaproductos.size();i++){
                        ProductoProveedor producto = new ProductoProveedor();
                        producto.setNombreProducto((String)((Vector) listaproductos.get(i)).get(0));
                        producto.setPrecio((Float)((Vector)listaproductos.get(i)).get(1));
                        if(!producto.getNombreProducto().equals(null))
                            lista.add(producto);
                    }
                    viejo.setProductos(lista);
                    Splash.listaproductos = null;
                }
                proveedorPersistente.actualizar(viejo, nuevo);
                return "Succes";
            }
            else{
                return "Telefono invalido";
            }
        }
        else{
            return "Nit invalido";
        }
    }

    public String crearProveedor(Proveedores proveedor2, Vector listaproductos) {
        if(validarProveedorNit(proveedor2.getNit())){
            if(validarProveedorTel(proveedor2.getTelefono()) || proveedor2.getTelefono()== 0){
                List<ProductoProveedor> lista = new ArrayList();
                if(listaproductos != null){
                    for(int i=0; i<listaproductos.size();i++){
                        ProductoProveedor producto = new ProductoProveedor();
                        producto.setNombreProducto((String)((Vector) listaproductos.get(i)).get(0));
                        producto.setPrecio((Float)((Vector)listaproductos.get(i)).get(1));
                        if(!producto.getNombreProducto().equals(null))
                            lista.add(producto);
                    }
                    proveedor2.setProductos(lista);
                    Splash.listaproductos = null;
                }
                Sistema sistema = Frontera.Splash.sistema;
                sistema.getProveedores().add(proveedor2);
                proveedorPersistente.crear(proveedor2);
                return "Succes";
            }else{
                return "Telefono invalido";
            }
        }else{
            return "Nit invalido";
        }
    }

    private boolean validarProveedorNit(int nit) {
        if(nit<1)
            return false;
        return true;
    }

    private boolean validarProveedorTel(int tel) {
        if(tel<0)
            return false;
        if(Integer.toString(tel).length()<7 || Integer.toString(tel).length()>10)
            return false;

        return true;
    }
}