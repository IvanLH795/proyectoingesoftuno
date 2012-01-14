/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entidad.Productos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Camilo
 */
public class ProductosJpaController {

    public void create(Productos producto, EntityManager em) {
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

    public String delete(String nombre, EntityManager em){
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE FROM Productos u WHERE u.nombreProducto = '" + nombre + "'");
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

    public String delete(Productos producto, EntityManager em){
        return this.delete(producto.getNombreProducto(), em);
    }

    public List<Productos> getProductos(EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM Productos as u");
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public Productos getProductoNombre(String nombre, EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM Productos as u WHERE u.nombreProducto = '" + nombre + "'");
            return (Productos)q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
