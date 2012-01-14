/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Frontera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Camilo
 */
public class Main {
    public static void main(String args[]){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU", System.getProperties());
        EntityManager em = emf.createEntityManager();
    }
}
