package dao;

import Entidad.Proveedores;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class proveedoresDAO {
    private static EntityManagerFactory
    emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
    public void crear(Proveedores object){
         EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public boolean eliminar(Proveedores object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            em.remove(object);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }
    public Proveedores leer(Proveedores par) {
        EntityManager em = emf.createEntityManager();
        Proveedores proveedor = null;
        Query q = em.createQuery("SELECT u from Proveedores u " +
                "WHERE u.nombre LIKE :nombre" +
                " AND u.nit LIKE :nit")
                .setParameter("nombre", par.getNombre())
                .setParameter("password", par.getNit());
        try {
            proveedor = (Proveedores) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            proveedor = (Proveedores) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return proveedor;
        }
    }
    public boolean actualizar(Proveedores object, Proveedores nuevoObjeto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            object = leer(object);
            object.setNombre(nuevoObjeto.getNombre());
            object.setNit(nuevoObjeto.getNit());
            em.merge(object);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }    
}