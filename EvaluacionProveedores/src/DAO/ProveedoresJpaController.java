package DAO;

import Entidad.Proveedores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ProveedoresJpaController {

    public String create(Proveedores proveedor, EntityManager em) {
        em.getTransaction().begin();
        try {
            em.persist(proveedor);
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
            Query q = em.createQuery("DELETE FROM Proveedores u WHERE u.nombre = '" + nombre + "'");
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
            Query q = em.createQuery("DELETE FROM Proveedores p WHERE p.nit = " + nit);
            q.executeUpdate();
            em.getTransaction().commit();
            return "Succes";
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
            return "Fail";
        }
    }

    public String delete(Proveedores proveedor, EntityManager em){
        return this.delete(proveedor.getNit(), em);
    }

    public String updateNitIguales(Proveedores nuevo, EntityManager em){
        em.getTransaction().begin();
        try{
            em.merge(nuevo);
            em.getTransaction().commit();
            return "Succes";
        }catch(Exception e){
            em.getTransaction().rollback();
            return "Fail";
        }
    }

    public String updateNitDistintos(int nit, Proveedores nuevo, EntityManager em){
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("UPDATE Proveedores p SET p.nit = " +
                    nuevo.getNit() + "' WHERE p.nit = " + nit);
            q.executeUpdate();
            em.getTransaction().commit();
            return "Succes";
        }catch(Exception e){
            em.getTransaction().rollback();
            return "Fail";
        }
    }

    public List<Proveedores> getProveedores(EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM Proveedores as u");
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public Proveedores getProveedorNit(int nit, EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM Proveedores as u WHERE u.nit = " + nit);
            return (Proveedores)q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public Proveedores getProveedorNombre(String nombre, EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM Proveedores as u WHERE u.nombre = '" + nombre + "'");
            return (Proveedores)q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
