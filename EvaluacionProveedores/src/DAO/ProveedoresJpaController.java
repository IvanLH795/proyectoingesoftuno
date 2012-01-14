/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entidad.Proveedores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Camilo
 */
public class ProveedoresJpaController {

    public void create(Proveedores proveedor, EntityManager em) {
        em.getTransaction().begin();
        try {
            proveedor = em.merge(proveedor);
            em.persist(proveedor);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }
    
    public String delete(String nombre, EntityManager em){
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE FROM Proveedores u WHERE u.nombre = '" + nombre + "'");
            q.executeUpdate();
            em.getTransaction().commit();
            return "Succes";
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
            return "Fail";
        }
    }

    public String delete(int nit, EntityManager em){
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("DELETE FROM Proveedores p WHERE p.nit = " + nit);
            q.executeUpdate();
            em.getTransaction().commit();
            return "Succes";
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
            return "Fail";
        }
    }

    public String delete(Proveedores proveedor, EntityManager em){
        return this.delete(proveedor.getNit(), em);
    }

    public void update(Proveedores viejo, Proveedores nuevo, EntityManager em){
        em.getTransaction().begin();
        try{
            Query q = em.createQuery("UPDATE Proveedores s SET s.nombre = '" +
                    nuevo.getNombre() + 
                    "', s.nit = "+ nuevo.getNit() +
                    ", s.representante = '"+ nuevo.getRepresentante() +
                    "', s.correo = '"+ nuevo.getCorreo() +
                    "', s.telefono = "+ nuevo.getTelefono() +
                    ", s.paginaWeb = '"+ nuevo.getPaginaWeb() +
                    "', s.direccion = '"+ nuevo.getDireccion() +
                    "' WHERE s.nit = " + viejo.getNit());
            q.executeUpdate();
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    public List<Proveedores> getProveedores(EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM Proveedores as u");
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public Proveedores getProveedorNit(int nit, EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM Proveedores as u WHERE u.nit = " + nit);
            return (Proveedores)q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public Proveedores getProveedorNombre(String nombre, EntityManager em){
        try{
            Query q = em.createQuery("SELECT u FROM Proveedores as u WHERE u.nombre = '" + nombre + "'");
            return (Proveedores)q.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
