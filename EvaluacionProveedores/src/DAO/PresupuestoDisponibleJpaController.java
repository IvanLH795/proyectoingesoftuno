package DAO;

import Entidad.PresupuestoDisponible;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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

    public PresupuestoDisponible getPresupuestoDisponible(EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM PresupuestoDisponible as u");
            return (PresupuestoDisponible) q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
