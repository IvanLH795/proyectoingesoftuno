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
    
    public void create(ProductoProveedor producto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager emc = emf.createEntityManager();
        emc.getTransaction().begin();
        try {
            producto = emc.merge(producto);
            emc.persist(producto);
            emc.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            emc.getTransaction().rollback();
        }finally{
            emc.close();
        }
    }

    public void create(List<ProductoProveedor> productos) {
        for (ProductoProveedor u: productos){
            this.create(u);
        }
    }

    public String delete(String nombre){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE u FROM ProductoProveedor as u WHERE u.nombreProducto = '" + nombre + "'");
            q.executeUpdate();
            em.getTransaction().commit();
            return "Succes";
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
            return "Fail";
        }finally{
            em.close();
        }
    }

    public String delete(ProductoProveedor producto){
        return this.delete(producto.getNombreProducto());
    }

    public List<ProductoProveedor> getProductosProveedor(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        try{
            Query q = em.createQuery("SELECT u FROM ProductoProveedor as u");
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public List<ProductoProveedor> getProductosProveedorNombre(String nombre){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        try{
            Query q = em.createQuery("SELECT u FROM ProductoProveedor as u WHERE u.nombreProducto = '" + nombre + "'");
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public List<ProductoProveedor> getProductoProveedorProveedorNit(int nit){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        try{
            Query q = em.createQuery("SELECT u FROM ProductoProveedor as u WHERE u.proveedor.nit = " + nit);
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public ProductoProveedor getProductoProveedorNombreProveedorNit(String nombre, int nit){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
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
