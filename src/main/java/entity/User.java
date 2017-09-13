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
public class User implements Serializable {

    @OneToMany(mappedBy = "user")
    private List<Solution> solutions;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private short skillLevel;  //think of better thing to call it, maybe

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(short skillLevel) {
        this.skillLevel = skillLevel;
    }

}
