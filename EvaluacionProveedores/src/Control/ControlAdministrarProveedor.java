/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import DAO.EvaluacionesJpaController;
import DAO.ProductosProveedorJpaController;
import DAO.ProveedoresJpaController;
import Entidad.Evaluaciones;
import Entidad.ProductoProveedor;
import Entidad.Proveedores;
import Frontera.Splash;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;

/**
 *
 * @author Darthian
 */
public class ControlAdministrarProveedor {

    EntityManager em;
    public ControlAdministrarProveedor(){
        em = Splash.em;
    }
    
    public String crearProveedor(Proveedores u){
        if(validarProveedorNit(u.getNit())){
            if(validarProveedorTel(u.getTelefono()) || u.getTelefono()== 0){
                    ProveedoresJpaController jpaProveedor = new ProveedoresJpaController();
                    jpaProveedor.create(u, em);
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
                List<ProductoProveedor> lista = new ArrayList<ProductoProveedor>();
                List<Evaluaciones> listaeva = new ArrayList<Evaluaciones>();
                for(ProductoProveedor p: viejo.getProductos()){
                    ProductoProveedor u = new ProductoProveedor();
                    u.setNombreProducto(p.getNombreProducto());
                    u.setPrecioPorUnidad(p.getPrecioPorUnidad());
                    u.setProveedor(nuevo);
                    lista.add(u);
                }

                for(Evaluaciones p: viejo.getEvaluaciones()){
                    Evaluaciones u = new Evaluaciones();
                    u.setAdaptabilidad(p.getAdaptabilidad());
                    u.setCalidad(p.getCalidad());
                    u.setCercania(p.getCercania());
                    u.setComentarios(p.getComentarios());
                    u.setFecha(p.getFecha());
                    u.setFiabilidad(p.getFiabilidad());
                    u.setProveedor(nuevo);
                    listaeva.add(u);
                }
                nuevo.setProductos(lista);
                nuevo.setEvaluaciones(listaeva);

                
                ProductosProveedorJpaController productosb = new ProductosProveedorJpaController();
                productosb.delete(viejo.getNit(), em);
                EvaluacionesJpaController evaluacionesb = new EvaluacionesJpaController();
                evaluacionesb.delete(viejo.getNit(), em);


                ProveedoresJpaController jpaProveedor = new ProveedoresJpaController();
                jpaProveedor.create(nuevo, em);
                jpaProveedor.delete(viejo.getNit(), em);
                
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
            ProveedoresJpaController jpaProveedor = new ProveedoresJpaController();
            jpaProveedor.delete(nit, em);
            return "Succes";
    }

    public Proveedores buscarProveedor(String nombre, Integer nit){
        ProveedoresJpaController jpaProveedor = new ProveedoresJpaController();
        return jpaProveedor.getProveedorNit(nit, em);
    }

    public Proveedores buscarProveedor(String nombre){
        ProveedoresJpaController jpaProveedor = new ProveedoresJpaController();
        return jpaProveedor.getProveedorNombre(nombre, em);
    }

    public Proveedores buscarProveedor(Integer obj) {
        ProveedoresJpaController jpaProveedor = new ProveedoresJpaController();
        return jpaProveedor.getProveedorNit(obj, em);

    }

    public String modificarProveedor(Proveedores viejo, Proveedores nuevo, Vector listaProductos) {
        if(validarProveedorNit(nuevo.getNit())){
            if(validarProveedorTel(nuevo.getTelefono()) || nuevo.getTelefono()== 0){

                List<ProductoProveedor> lista = new ArrayList<ProductoProveedor>();
                List<Evaluaciones> listaeva = new ArrayList<Evaluaciones>();
                for(ProductoProveedor p: viejo.getProductos()){
                    ProductoProveedor u = new ProductoProveedor();
                    u.setNombreProducto(p.getNombreProducto());
                    u.setPrecioPorUnidad(p.getPrecioPorUnidad());
                    u.setProveedor(nuevo);
                    lista.add(u);
                }
                
                for(Evaluaciones p: viejo.getEvaluaciones()){
                    Evaluaciones u = new Evaluaciones();
                    u.setAdaptabilidad(p.getAdaptabilidad());
                    u.setCalidad(p.getCalidad());
                    u.setCercania(p.getCercania());
                    u.setComentarios(p.getComentarios());
                    u.setFecha(p.getFecha());
                    u.setFiabilidad(p.getFiabilidad());
                    u.setProveedor(nuevo);
                    listaeva.add(u);
                }
                nuevo.setProductos(lista);
                nuevo.setEvaluaciones(listaeva);

                ProductosProveedorJpaController productosb = new ProductosProveedorJpaController();
                productosb.delete(viejo.getNit(), em);
                ProveedoresJpaController jpaProveedor = new ProveedoresJpaController();
                jpaProveedor.create(nuevo, em);
                jpaProveedor.delete(viejo, em);
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

    public String crearProveedor(Proveedores proveedor, Vector listaproductos) {
        if(validarProveedorNit(proveedor.getNit())){
            if(validarProveedorTel(proveedor.getTelefono()) || proveedor.getTelefono()== 0){
                List<ProductoProveedor> lista = new ArrayList();
                if(listaproductos != null){
                    for(int i=0; i<listaproductos.size();i++){
                        ProductoProveedor producto = new ProductoProveedor();
                        producto.setNombreProducto((String)((Vector) listaproductos.get(i)).get(0));
                        producto.setPrecioPorUnidad((Float)((Vector)listaproductos.get(i)).get(1));
                        if(!(producto.getNombreProducto()==null))
                            lista.add(producto);
                            producto.setProveedor(proveedor);
                    }
                    proveedor.setProductos(lista);
                }
                ProveedoresJpaController jpaProveedor = new ProveedoresJpaController();
                jpaProveedor.create(proveedor, em);
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