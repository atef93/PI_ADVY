package tn.advyteam.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "Manager")
public class Manager extends Employee implements Serializable{

	@OneToMany(mappedBy = "createdBy")
	private List<Projet> projets;
	
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}


	public Manager(List<Projet> projets) {
		super();
		this.projets = projets;
	}


	public List<Projet> getProjets() {
		return projets;
	}


	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}


	public Manager(int id, String nom) {
		super(id, nom);
		// TODO Auto-generated constructor stub
	}


	public Manager(String nom, String prenom, String adresse, String email, String sexe, Boolean isActif,
			Date datenaissance, Etatcivil etatcivil) {
		super(nom, prenom, adresse, email, sexe, isActif, datenaissance, etatcivil);
		// TODO Auto-generated constructor stub
	}


	public Manager(String nom, String prenom, String adresse, String email, String sexe, Boolean isActif,
			String password, Date datenaissance, Etatcivil etatcivil, String role, String image) {
		super(nom, prenom, adresse, email, sexe, isActif, password, datenaissance, etatcivil, role, image);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
