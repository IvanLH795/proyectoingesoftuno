package DAO;

import Entidad.Contratos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ContratosJpaController {

    public String create(Contratos evaluacion, EntityManager em) {
        em.getTransaction().begin();
        try {
            em.persist(evaluacion);
            em.getTransaction().commit();
            return "Succes";
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
            return "Fail";
        }
    }

    public String delete(String fecha, EntityManager em){
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE FROM Contratos u WHERE u.fecha = '" + fecha + "'");
            q.executeUpdate();
            em.getTransaction().commit();
            return "Succes";
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
            return "Fail";
        }
    }

    public String update(int nit, EntityManager em){
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("UPDATE Contratos u SET u.proveedor.nit WHERE u.fecha = '" + nit + "'");
            q.executeUpdate();
            em.getTransaction().commit();
            return "Succes";
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
            return "Fail";
        }
    }

    public String delete(Contratos contrato, EntityManager em){
        return this.delete(contrato.getFecha(), em);
    }
    
    public String delete(int nit, EntityManager em){
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE FROM Contratos u WHERE u.proveedor.nit = " + nit);
            q.executeUpdate();
            em.getTransaction().commit();
            return "Succes";
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
            return "Fail";
        }
    }

    public List<Contratos> getListaContratos(EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM Contratos as u");
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public Contratos getContratos(String nombre, EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM Contratos as u WHERE u.nombreProducto = '" + nombre + "'");
            return (Contratos)q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
