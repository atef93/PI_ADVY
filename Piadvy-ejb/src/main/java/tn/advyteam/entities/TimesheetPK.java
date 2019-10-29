package tn.advyteam.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TimesheetPK implements Serializable{

	
	private int idProjet;
	private int idDeveloppeur;
	
	
	
	public TimesheetPK() {
		super();
	}
	public TimesheetPK(int idProjet, int idDeveloppeur) {
		super();
		this.idProjet = idProjet;
		this.idDeveloppeur = idDeveloppeur;
	}
	public int getIdProjet() {
		return idProjet;
	}
	public int getIdDeveloppeur() {
		return idDeveloppeur;
	}
	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}
	public void setIdDeveloppeur(int idDeveloppeur) {
		this.idDeveloppeur = idDeveloppeur;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDeveloppeur;
		result = prime * result + idProjet;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimesheetPK other = (TimesheetPK) obj;
		if (idDeveloppeur != other.idDeveloppeur)
			return false;
		if (idProjet != other.idProjet)
			return false;
		return true;
	}
	
	
}
