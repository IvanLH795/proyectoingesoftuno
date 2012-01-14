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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Camilo
 */
public class Main {
    public static void main(String args[]){
        ProveedoresJpaController nuevo = new ProveedoresJpaController();
        Proveedores p = new Proveedores();
        ProductosProveedorJpaController productonuevo = new ProductosProveedorJpaController();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU", System.getProperties());
        EntityManager em = emf.createEntityManager();

        p.setNit(3);
        p.setNombre("Hola");

        ProductoProveedor h = new ProductoProveedor();
        h.setNombreProducto("producto");
        h.setPrecioPorUnidad(new Float(200));
        h.setProveedor(p);

        List<ProductoProveedor> hi = new ArrayList<ProductoProveedor>();
        hi.add(h);

        p.setProductos(hi);
        nuevo.create(p, em);


        ProductosProveedorJpaController productos = new ProductosProveedorJpaController();
        List<ProductoProveedor> listilla = productos.getProductoProveedorProveedorNit(3, em);
        for(ProductoProveedor u: listilla){
            System.out.println(u.getNombreProducto() + u.getProveedor().getNit());
        }
        productonuevo.delete(p.getNit(), em);
        nuevo.delete(p.getNit(), em);

        Usuario us = new Usuario();
        us.setNombre("Usuario");
        us.setPassword("asdf");
        us.setRoll("Auxiliar");

        UsuarioJpaController usuario = new UsuarioJpaController();
        usuario.create(us, em);
        Usuario a = new Usuario();
        a.setNombre("Usuario2");
        a.setPassword("asdf2");
        a.setRoll("Auxiliar2");
        
        usuario.update(us, a, em);

        System.out.println(usuario.buscarNombre("Usuario2", em).getRoll());
        em.close();
        emf.close();
    }
}
