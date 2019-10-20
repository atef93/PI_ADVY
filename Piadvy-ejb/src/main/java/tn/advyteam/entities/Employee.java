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
public class Employee implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String sexe;
	private Boolean isActif;
	private String password;
	@Temporal(TemporalType.DATE)
	private Date datenaissance;
	private Etatcivil etatcivil ;
	
	
	
	
	
	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Etatcivil getEtatcivil() {
		return etatcivil;
	}

	public void setEtatcivil(Etatcivil etatcivil) {
		this.etatcivil = etatcivil;
	}
	

	@OneToOne 
	private Contrat contrat ; 

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	

	public Employee(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	
	public Employee(int id, String nom, String prenom, String adresse, String email, Boolean isActif, String password,
			Date datenaissance,Etatcivil etatcivil) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.isActif = isActif;
		this.password = password;
		this.datenaissance = datenaissance;
		this.etatcivil = etatcivil;
	}
	
	

	public Employee(int id, String nom, String prenom, String adresse, String email, String sexe, Boolean isActif,
			String password, Date datenaissance, Etatcivil etatcivil, Contrat contrat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.sexe = sexe;
		this.isActif = isActif;
		this.password = password;
		this.datenaissance = datenaissance;
		this.etatcivil = etatcivil;
		this.contrat = contrat;
	}

	public Employee() {
		super();
	}
	
	
	
	
}
