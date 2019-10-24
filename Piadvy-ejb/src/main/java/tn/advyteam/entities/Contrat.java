package tn.advyteam.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Contrat implements Serializable {

	
	
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reference;
	
	@Temporal(TemporalType.DATE)
	private Date datedebut;
	
	@Temporal(TemporalType.DATE)
	private Date datefin;
	
	private Float salaire;
	
	private TypeContrat typeContrat;
	
	@OneToOne(mappedBy ="contrat")
	private  Employee employe ;
	
	
	public Employee getEmploye() {
		return employe;
	}

	public void setEmploye(Employee employe) {
		this.employe = employe;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public Float getSalaire() {
		return salaire;
	}

	public void setSalaire(Float salaire) {
		this.salaire = salaire;
	}

	public TypeContrat getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}

	
	public Contrat() {
		// TODO Auto-generated constructor stub
	}
	public Contrat(Date datedebut, Date datefin, Float salaire, TypeContrat typeContrat) {
		super();
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.salaire = salaire;
		this.typeContrat = typeContrat;
	}

	public Contrat(int reference, Date datedebut, Date datefin, Float salaire, TypeContrat typeContrat,
			Employee employe) {
		super();
		this.reference = reference;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.salaire = salaire;
		this.typeContrat = typeContrat;
		this.employe = employe;
	}
	
	
	
	
	
}
