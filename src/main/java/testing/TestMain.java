package testing;

import entity.User;
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
        uf.addEntityManagerFactory(emf);
        TestMain tm = new TestMain();
        tm.initiateSystem();
       // tm.closeSystem();

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
