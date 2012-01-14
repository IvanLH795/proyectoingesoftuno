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

    public void create(PresupuestoDisponible presupuesto, EntityManager emc) {
        emc.getTransaction().begin();
        try {
            presupuesto = emc.merge(presupuesto);
            emc.persist(presupuesto);
            emc.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            emc.getTransaction().rollback();
        }
    }

    public void update(PresupuestoDisponible presupuesto, EntityManager em){
        this.delete(em);
        this.create(presupuesto, em);
    }

    private void delete(EntityManager em){
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE FROM PresupuestoDisponible");
            q.executeUpdate();
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }    
}
