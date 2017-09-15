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

    @OneToMany
    private List<Solution> solutions;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private float skillLevel;  //think of better thing to call it, maybe

    public User(String name, float skillLevel) {
        this.name = name;
        this.skillLevel = skillLevel;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    
    
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

    public float getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(float skillLevel) {
        this.skillLevel = skillLevel;
    }

}
