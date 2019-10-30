package tn.advyteam.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
@DiscriminatorValue(value = "employee")
public class Employee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String nom;
	@Column
	private String prenom;
	
	@OneToMany(mappedBy="emp")
	private List<EvaluationAnnuel> evaluation;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<EvaluationAnnuel> getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(List<EvaluationAnnuel> evaluation) {
		this.evaluation = evaluation;
	}



	

	
	
}
