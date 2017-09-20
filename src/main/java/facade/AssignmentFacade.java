/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Assignment;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruger
 */
public class AssignmentFacade {

    private static EntityManagerFactory emf;
    private EntityManager em;

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public static void main(String[] args) {
        AssignmentFacade af = new AssignmentFacade();
        af.initiateSystem();
        Random randomGenerator = new Random();
        for (int i = 1; i <= 100; ++i) {
            float randomFloat = randomGenerator.nextFloat() * (10 ) ;
            Assignment a = new Assignment();
            a.setDifficulty(randomFloat);
            af.addAssignment(a);
        }
            af.getAssignmentByDifficulty( 4.0f);

    }

    public void initiateSystem() {

        Persistence.generateSchema("myPU", null);

        emf = Persistence.createEntityManagerFactory("myPU");

        em = emf.createEntityManager();

    }

    public void closeSystem() {

        if (em.isOpen()) {
            em.close();
        }

    }

    public void addAssignment(Assignment a) {  //should propably return something
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
    }

    public Assignment getAssignment(int id) {
        Assignment a;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        a = em.find(Assignment.class, id);
        em.getTransaction().commit();
        em.close();
        return a;
    }
    public void getAssignmentByDifficulty( float difficulty){
       em = emf.createEntityManager();
        try {
            List<Assignment> Assignments = new ArrayList();

            Assignments = em.createNamedQuery("Assignment.findAssignmentByDifficulty").setParameter("difficulty", difficulty).getResultList();

            for (Assignment assignment : Assignments) {

               System.out.println(assignment.toString());

            }
        } finally {
            em.close();
        }

        
    }

    public void updateAssignment(Assignment a) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteAssignment(Assignment a) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
        em.close();
    }
}
