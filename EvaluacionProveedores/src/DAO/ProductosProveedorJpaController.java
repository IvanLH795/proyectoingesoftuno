/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entidad.ProductoProveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Camilo
 */
public class ProductosProveedorJpaController {
    
    public void create(ProductoProveedor producto, EntityManager emc) {
        emc.getTransaction().begin();
        try {
            producto = emc.merge(producto);
            emc.persist(producto);
            emc.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            emc.getTransaction().rollback();
        }
    }

    public void create(List<ProductoProveedor> productos, EntityManager em) {
        for (ProductoProveedor u: productos){
            this.create(u, em);
        }
    }

    public String delete(String nombre, EntityManager em){
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE FROM ProductoProveedor u WHERE u.nombreProducto = '" + nombre + "'");
            q.executeUpdate();
            em.getTransaction().commit();
            return "Succes";
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
            return "Fail";
        }
    }

    public String delete(int nit, EntityManager em){
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE FROM ProductoProveedor u WHERE u.proveedor.nit = " + nit);
            q.executeUpdate();
            em.getTransaction().commit();
            return "Succes";
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
            return "Fail";
        }
    }

    public String delete(ProductoProveedor producto, EntityManager em){
        return this.delete(producto.getNombreProducto(), em);
    }

    public List<ProductoProveedor> getProductosProveedor(EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM ProductoProveedor as u");
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public List<ProductoProveedor> getProductosProveedorNombre(String nombre, EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM ProductoProveedor as u WHERE u.nombreProducto = '" + nombre + "'");
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public List<ProductoProveedor> getProductoProveedorProveedorNit(int nit, EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM ProductoProveedor as u WHERE u.proveedor.nit = " + nit);
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public ProductoProveedor getProductoProveedorNombreProveedorNit(String nombre, int nit, EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM ProductoProveedor as u WHERE u.proveedor.nit = " + nit +
                    "AND u.nombre = '" + nombre + "'");
            return (ProductoProveedor)q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
