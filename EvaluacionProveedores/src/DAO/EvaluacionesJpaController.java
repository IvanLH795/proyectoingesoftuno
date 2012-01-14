/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entidad.Evaluaciones;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Camilo
 */
public class EvaluacionesJpaController {

    public void create(Evaluaciones evaluacion) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            evaluacion = em.merge(evaluacion);
            em.persist(evaluacion);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public String delete(String fecha){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE u FROM Evaluaciones as u WHERE u.fecha = '" + fecha + "'");
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

    public String delete(Evaluaciones evaluacion){
        return this.delete(evaluacion.getFecha());
    }

    public List<Evaluaciones> getEvaluaciones(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        try{
            Query q = em.createQuery("SELECT u FROM Evaluaciones as u");
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public Evaluaciones getEvaluacionFecha(String fecha){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        try{
            Query q = em.createQuery("SELECT u FROM Evaluaciones as u WHERE u.fecha = '" + fecha + "'");
            return (Evaluaciones)q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
