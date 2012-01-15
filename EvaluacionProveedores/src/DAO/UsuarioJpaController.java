/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entidad.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Camilo
 */
public class UsuarioJpaController {

    public void create(Usuario usuario, EntityManager emc) {
        emc.getTransaction().begin();
        try {
            usuario = emc.merge(usuario);
            emc.persist(usuario);
            emc.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            emc.getTransaction().rollback();
        }
    }

    public void update(Usuario viejo, Usuario nuevo, EntityManager em){
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
        }
    }
    
    public String delete(String nombre, EntityManager em){
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE FROM Usuario u WHERE u.nombre = '" + nombre + "'");
            q.executeUpdate();
            em.getTransaction().commit();
            return "Succes";
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
            return "Fail";
        }
    }
    
    public void delete(Usuario usuario, EntityManager em){
        this.delete(usuario.getNombre(), em);
    }

    public Usuario buscarNombre(String nombre, EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM Usuario as u WHERE u.nombre = '" + nombre + "'");
            return (Usuario)q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public List<Usuario> getUsuarios(EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM Usuario as u");
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
