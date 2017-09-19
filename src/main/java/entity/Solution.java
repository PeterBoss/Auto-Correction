package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

/**
 *
 * @author Peter
 */
@Entity
//@IdClass(SolutionId.class)
public class Solution implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Id
    private int assignmentId;
    @Id
    private int userId;
    private int timeSpent;  //change datatype to something more useful?
    private int numberOfErrors;
    private int evaluationScore;

    public Solution() {
    }

    public Solution(int assignmentId, int userId, int timeSpent, int numberOfErrors, int evaluationScore) {
        this.assignmentId = assignmentId;
        this.userId = userId;
        this.timeSpent = timeSpent;
        this.numberOfErrors = numberOfErrors;
        this.evaluationScore = evaluationScore;
    }
    

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public int getNumberOfErrors() {
        return numberOfErrors;
    }

    public void setNumberOfErrors(int numberOfErrors) {
        this.numberOfErrors = numberOfErrors;
    }

    public int getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(int evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}
