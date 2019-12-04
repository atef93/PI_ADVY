package tn.advyteam.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "devloppeur") 
public class Developpeur extends Employee implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "developpeur", fetch = FetchType.LAZY)
	private List<Timesheet> timesheets;

	
	
	public Developpeur() {
		super();
	}
	

	
	public List<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
	
	
	
}
