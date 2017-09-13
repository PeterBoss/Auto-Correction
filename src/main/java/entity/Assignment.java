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

    @OneToMany(mappedBy = "assignment")
    private List<Solution> solutions;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private short difficulty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(short difficulty) {
        this.difficulty = difficulty;
    }

}
