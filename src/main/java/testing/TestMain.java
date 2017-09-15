package testing;

import entity.Assignment;
import entity.User;
import facade.AssignmentFacade;
import facade.UserFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Peter
 */
public class TestMain {

    private static EntityManagerFactory emf;
    private EntityManager em;

    public static void main(String[] args) {
       // Persistence.generateSchema("myPU", null);
        UserFacade uf = new UserFacade();
        AssignmentFacade af = new AssignmentFacade();
        TestMain tm = new TestMain();
        tm.initiateSystem();
        uf.addEntityManagerFactory(emf);
        af.addEntityManagerFactory(emf);
       // tm.closeSystem();
       
       User u1 = new User();
       u1.setName("Peter Boss Thomsen");
       u1.setSkillLevel(5.0f);
       
       uf.addUser(u1);
       
       Assignment a1 = new Assignment();
       a1.setDifficulty(5.0f);
       
       af.addAssignment(a1);
       
       a1.setDifficulty(4.0f);
       
       af.updateAssignment(a1);
       
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

}
