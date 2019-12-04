package tn.advyteam.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tache {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private Timesheet timesheet;
	
	public Tache() {
		// TODO Auto-generated constructor stub
	}

	public Tache(Timesheet timesheet) {
		super();
		this.timesheet = timesheet;
	}

	public int getId() {
		return id;
	}

	public Timesheet getTimesheet() {
		return timesheet;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
	}
	
	



	
	
	
}