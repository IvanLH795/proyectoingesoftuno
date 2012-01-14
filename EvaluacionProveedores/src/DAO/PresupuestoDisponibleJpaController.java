/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entidad.PresupuestoDisponible;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Camilo
 */
public class PresupuestoDisponibleJpaController {

    public void create(PresupuestoDisponible presupuesto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager emc = emf.createEntityManager();
        emc.getTransaction().begin();
        try {
            presupuesto = emc.merge(presupuesto);
            emc.persist(presupuesto);
            emc.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            emc.getTransaction().rollback();
        }finally{
            emc.close();
        }
    }

    public void update(PresupuestoDisponible presupuesto){
        this.delete();
        this.create(presupuesto);
    }

    private void delete(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE FROM PresupuestoDisponible");
            q.executeUpdate();
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }    
}
