/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DAO.exceptions.NonexistentEntityException;
import Entidad.Sistema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Darthian
 */
public class SistemaJpaController {

    public SistemaJpaController() {
        emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sistema sistema) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sistema);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sistema sistema) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sistema = em.merge(sistema);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = sistema.getId();
                if (findSistema(id) == null) {
                    throw new NonexistentEntityException("The sistema with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sistema sistema;
            try {
                sistema = em.getReference(Sistema.class, id);
                sistema.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sistema with id " + id + " no longer exists.", enfe);
            }
            em.remove(sistema);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sistema> findSistemaEntities() {
        return findSistemaEntities(true, -1, -1);
    }

    public List<Sistema> findSistemaEntities(int maxResults, int firstResult) {
        return findSistemaEntities(false, maxResults, firstResult);
    }

    private List<Sistema> findSistemaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Sistema as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Sistema findSistema(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sistema.class, id);
        } finally {
            em.close();
        }
    }

    public int getSistemaCount() {
        EntityManager em = getEntityManager();
        try {
            return ((Long) em.createQuery("select count(o) from Sistema as o").getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
