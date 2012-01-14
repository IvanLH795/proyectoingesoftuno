/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entidad.Proveedores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Camilo
 */
public class ProveedoresJpaController {

    public void create(Proveedores proveedor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            proveedor = em.merge(proveedor);
            em.persist(proveedor);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public String delete(String nombre){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE u FROM Proveedores as u WHERE u.nombre = '" + nombre + "'");
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

    public String delete(int nit){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE u FROM Proveedores as u WHERE u.nit = " + nit);
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

    public String delete(Proveedores proveedor){
        return this.delete(proveedor.getNit());
    }

    public String update(Proveedores viejo, Proveedores nuevo){
        this.delete(viejo);
        this.create(nuevo);
        return "Succes";
    }

    public List<Proveedores> getProveedores(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        try{
            Query q = em.createQuery("SELECT u FROM Proveedores as u");
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public Proveedores getProveedorNit(int nit){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        try{
            Query q = em.createQuery("SELECT u FROM Proveedores as u WHERE u.nit = " + nit);
            return (Proveedores)q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public Proveedores getProveedorNombre(String nombre){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        try{
            Query q = em.createQuery("SELECT u FROM Proveedores as u WHERE u.nombre = '" + nombre + "'");
            return (Proveedores)q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
