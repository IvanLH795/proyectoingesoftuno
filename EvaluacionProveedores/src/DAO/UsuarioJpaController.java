/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entidad.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Camilo
 */
public class UsuarioJpaController {

    public void create(Usuario usuario) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager emc = emf.createEntityManager();
        emc.getTransaction().begin();
        try {
            usuario = emc.merge(usuario);
            emc.persist(usuario);
            emc.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            emc.getTransaction().rollback();
        }finally{
            emc.close();
        }
    }

    public void update(Usuario viejo, Usuario nuevo){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("UPDATE Usuario s SET s.nombre = '" +
                    nuevo.getNombre() + "', s.password = '"+ nuevo.getPassword() +
                    "', s.roll = '"+ nuevo.getRoll() +
                    "' WHERE s.nombre = '" + viejo.getNombre() + "'");
            q.executeUpdate();
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }
    
    public String delete(String nombre){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE u FROM Usuario as u WHERE u.nombre = '" + nombre + "'");
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
    
    public void delete(Usuario usuario){
        this.delete(usuario.getNombre());
    }

    public Usuario buscarNombre(String nombre){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU");
        EntityManager em = emf.createEntityManager();
        try{
            Query q = em.createQuery("SELECT u FROM Usuario as u WHERE u.nombre = '" + nombre + "'");
            return (Usuario)q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

}
