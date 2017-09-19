package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Peter
 */
@Entity
public class Assignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float difficulty;

    @OneToMany
    private List<Solution> solutions;
    
    public void addSolutions(Solution solution){
        this.solutions.add(solution);
    }

    public Assignment() {
    }

    public Assignment(float difficulty) {
        this.difficulty = difficulty;
    }

    public Assignment(float difficulty, List<Solution> solutions) {
        this.difficulty = difficulty;
        this.solutions = solutions;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(float difficulty) {
        this.difficulty = difficulty;
    }

}
