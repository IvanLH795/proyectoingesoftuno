package DAO;

import Entidad.Evaluaciones;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EvaluacionesJpaController {

    public void create(Evaluaciones evaluacion, EntityManager em) {
        em.getTransaction().begin();
        try {
            evaluacion = em.merge(evaluacion);
            em.persist(evaluacion);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    public String delete(String fecha, EntityManager em){
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE FROM Evaluaciones u WHERE u.fecha = '" + fecha + "'");
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
            Query q = em.createQuery("DELETE FROM Evaluaciones u WHERE u.proveedor.nit = " + nit);
            q.executeUpdate();
            em.getTransaction().commit();
            return "Succes";
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
            return "Fail";
        }
    }

    public String delete(Evaluaciones evaluacion, EntityManager em){
        return this.delete(evaluacion.getFecha(), em);
    }

    public List<Evaluaciones> getEvaluaciones(EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM Evaluaciones as u");
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public Evaluaciones getEvaluacionFecha(String fecha, EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM Evaluaciones as u WHERE u.fecha = '" + fecha + "'");
            return (Evaluaciones)q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
