package dao;

import Entidad.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class UsuarioDAO {
    private static EntityManagerFactory
    emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");

    public void crear(Usuario object){
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
    public boolean eliminar(Usuario object) {
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
    public Usuario leer(Usuario par) {
        EntityManager em = emf.createEntityManager();
        Usuario proveedor = null;
        Query q = em.createQuery("SELECT u from Proveedores u " +
                "WHERE u.nombre LIKE :nombre" +
                " AND u.nit LIKE :nit")
                .setParameter("nombre", par.getNombre())
                .setParameter("password", par.getPassword());
        try {
            proveedor = (Usuario) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            proveedor = (Usuario) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return proveedor;
        }
    }
    public boolean actualizar(Usuario object, Usuario nuevoObjeto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            object = leer(object);
            object.setNombre(nuevoObjeto.getNombre());
            object.setId(nuevoObjeto.getId());
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
