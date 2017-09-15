package entity;

import java.io.Serializable;

/**
 *
 * @author Peter
 */
public class SolutionId implements Serializable {

    private Integer assignmentId;
    private Integer userId;

    public SolutionId() {
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SolutionId)) {
            return false;
        }
        SolutionId id = (SolutionId) obj;
        return id.assignmentId.equals(this.assignmentId) && id.userId.equals(this.userId);
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

}
