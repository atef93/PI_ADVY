package tn.advyteam.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "devloppeur")
public class Developpeur extends Employee implements Serializable {

	
	@OneToMany(mappedBy = "developpeur")
	private List<Timesheet> timesheets;

	public Developpeur() {
		super();
	}
	
	public Developpeur(String nom, String prenom) {
		super(nom, prenom);
	}
	
	public List<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
	
	
	
}
