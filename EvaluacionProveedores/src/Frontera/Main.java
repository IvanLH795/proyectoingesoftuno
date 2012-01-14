/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Frontera;

import DAO.ProductosProveedorJpaController;
import DAO.ProveedoresJpaController;
import DAO.UsuarioJpaController;
import Entidad.ProductoProveedor;
import Entidad.Proveedores;
import Entidad.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Camilo
 */
public class Main {
    public static void main(String args[]){
        ProveedoresJpaController nuevo = new ProveedoresJpaController();
        Proveedores p = new Proveedores();

        p.setNit(3);
        p.setNombre("Hola");

        ProductoProveedor h = new ProductoProveedor();
        h.setNombreProducto("producto");
        h.setPrecioPorUnidad(new Float(200));
        h.setProveedor(p);
        List<ProductoProveedor> hi = new ArrayList<ProductoProveedor>();
        hi.add(h);
        p.setProductos(hi);
        nuevo.create(p);

        ProductosProveedorJpaController productos = new ProductosProveedorJpaController();
        List<ProductoProveedor> listilla = productos.getProductoProveedorProveedorNit(3);
        for(ProductoProveedor u: listilla){
            System.out.println(u.getNombreProducto() + u.getProveedor().getNit());
        }
        Usuario us = new Usuario();
        us.setNombre("Usuario");
        us.setPassword("asdf");
        us.setRoll("Auxiliar");

        UsuarioJpaController usuario = new UsuarioJpaController();
        usuario.create(us);
        Usuario a = new Usuario();
        a.setNombre("Usuario2");
        a.setPassword("asdf2");
        a.setRoll("Auxiliar2");
        
        usuario.update(us, a);

        System.out.println(usuario.buscarNombre("Usuario2").getRoll());

    }
}
