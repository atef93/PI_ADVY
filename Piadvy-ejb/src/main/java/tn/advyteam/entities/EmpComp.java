package tn.advyteam.entities;


import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EmpComp
 *
 */
@Entity
public class EmpComp implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int employeeId;
	private int competenceId;
	private float score;
	//private static final long serialVersionUID = -558553967080513790L;

	public EmpComp() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}   
	public int getCompetenceId() {
		return this.competenceId;
	}

	public void setCompetenceId(int competenceId) {
		this.competenceId = competenceId;
	}

	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
	
   	@Override
	public String toString() {
		return "EmpComp [id=" + id + ", employeeId=" + employeeId + ", competenceId=" + competenceId + "]";
	}
}
