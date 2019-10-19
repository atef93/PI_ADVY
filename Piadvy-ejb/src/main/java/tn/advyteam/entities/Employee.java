package tn.advyteam.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	
	@Id
	private int id;
	private String nom;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
