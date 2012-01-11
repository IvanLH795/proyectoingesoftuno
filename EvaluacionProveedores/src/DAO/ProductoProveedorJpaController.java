/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DAO.exceptions.NonexistentEntityException;
import Entidad.ProductoProveedor;
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
public class ProductoProveedorJpaController {

    public ProductoProveedorJpaController() {
        emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProductoProveedor productoProveedor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productoProveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProductoProveedor productoProveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productoProveedor = em.merge(productoProveedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = productoProveedor.getId();
                if (findProductoProveedor(id) == null) {
                    throw new NonexistentEntityException("The productoProveedor with id " + id + " no longer exists.");
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
            ProductoProveedor productoProveedor;
            try {
                productoProveedor = em.getReference(ProductoProveedor.class, id);
                productoProveedor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productoProveedor with id " + id + " no longer exists.", enfe);
            }
            em.remove(productoProveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProductoProveedor> findProductoProveedorEntities() {
        return findProductoProveedorEntities(true, -1, -1);
    }

    public List<ProductoProveedor> findProductoProveedorEntities(int maxResults, int firstResult) {
        return findProductoProveedorEntities(false, maxResults, firstResult);
    }

    private List<ProductoProveedor> findProductoProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from ProductoProveedor as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ProductoProveedor findProductoProveedor(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductoProveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            return ((Long) em.createQuery("select count(o) from ProductoProveedor as o").getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
