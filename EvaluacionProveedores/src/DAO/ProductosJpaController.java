/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entidad.Productos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Camilo
 */
public class ProductosJpaController {

    public void create(Productos producto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            producto = em.merge(producto);
            em.persist(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }

    public String delete(String nombre){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE u FROM Productos as u WHERE u.nombreProducto = '" + nombre + "'");
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

    public String delete(Productos producto){
        return this.delete(producto.getNombreProducto());
    }

    public List<Productos> getProductos(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        try{
            Query q = em.createQuery("SELECT u FROM Productos as u");
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public Productos getProductoNombre(String nombre){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        try{
            Query q = em.createQuery("SELECT u FROM Productos as u WHERE u.nombreProducto = '" + nombre + "'");
            return (Productos)q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
