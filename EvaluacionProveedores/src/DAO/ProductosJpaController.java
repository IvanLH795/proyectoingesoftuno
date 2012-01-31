package DAO;

import Entidad.Productos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ProductosJpaController {

    public String create(Productos producto, EntityManager em) {
        em.getTransaction().begin();
        try {
            em.persist(producto);
            em.getTransaction().commit();
            return "Succes";
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
            return "Fail";
        }
    }

    public String delete(String nombre, EntityManager em){
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE FROM Productos u WHERE u.nombreProducto = '" + nombre + "'");
            q.executeUpdate();
            em.getTransaction().commit();
            return "Correcto";
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
            return e.toString();
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
