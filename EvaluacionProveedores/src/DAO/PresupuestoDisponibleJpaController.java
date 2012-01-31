package DAO;

import Entidad.PresupuestoDisponible;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PresupuestoDisponibleJpaController {

    public String create(PresupuestoDisponible presupuesto, EntityManager emc) {
        emc.getTransaction().begin();
        try {
            emc.persist(presupuesto);
            emc.getTransaction().commit();
            return "Succes";
        } catch (Exception e) {
            System.out.println(e);
            emc.getTransaction().rollback();
            return "Fail";
        }
    }

    public void update(PresupuestoDisponible viejo, PresupuestoDisponible nuevo, EntityManager em){
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("UPDATE PresupuestoDisponible s SET s.presupuesto = "
                    + nuevo.getPresupuesto() + ", "
                    + "s.presupuestoDisponible = "
                    + nuevo.getPresupuestoDisponible()
                    +" WHERE s.presupuesto = " + viejo.getPresupuesto());
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
            return (PresupuestoDisponible)q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
