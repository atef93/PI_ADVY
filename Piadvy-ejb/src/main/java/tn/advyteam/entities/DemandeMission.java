package tn.advyteam.entities;

import java.io.Serializable;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: DemandeMission
 *
 */
@Entity
public class DemandeMission implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	@ManyToOne
	private Mission missions;
	
	@ManyToOne
	private Employee employees;
	
	private Boolean etat;

	
	public DemandeMission() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DemandeMission(int id, Boolean etat) {
		super();
		this.id = id;
		this.etat = etat;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Mission getMissions() {
		return missions;
	}


	public void setMissions(Mission missions) {
		this.missions = missions;
	}


	public Employee getEmployees() {
		return employees;
	}


	public void setEmployees(Employee employees) {
		this.employees = employees;
	}


	public Boolean getEtat() {
		return etat;
	}


	public void setEtat(Boolean etat) {
		this.etat = etat;
	}



	

	
	
   
}
