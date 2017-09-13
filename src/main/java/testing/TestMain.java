package testing;

import javax.persistence.Persistence;

/**
 *
 * @author Peter
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persistence.generateSchema("myPU", null);
    }
    
}
