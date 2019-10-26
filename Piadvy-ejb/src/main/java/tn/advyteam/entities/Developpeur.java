package tn.advyteam.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "devloppeur")
public class Developpeur extends Employee implements Serializable {

	
	@OneToMany(mappedBy = "developpeur")
	private List<Timesheet> timesheets;

	public List<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

	public Developpeur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Developpeur(int id, String nom) {
		super(id, nom);
		// TODO Auto-generated constructor stub
	}

	public Developpeur(String nom, String prenom, String adresse, String email, String sexe, Boolean isActif,
			Date datenaissance, Etatcivil etatcivil) {
		super(nom, prenom, adresse, email, sexe, isActif, datenaissance, etatcivil);
		// TODO Auto-generated constructor stub
	}

	public Developpeur(String nom, String prenom, String adresse, String email, String sexe, Boolean isActif,
			String password, Date datenaissance, Etatcivil etatcivil,String role) {
		super(nom, prenom, adresse, email, sexe, isActif, password, datenaissance, etatcivil,role);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

	
	
	
	
}
