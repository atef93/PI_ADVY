package tn.advyteam.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "Type_emp")
public class Employee implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
    @Enumerated(EnumType.STRING)
	private Etatcivil etatcivil ;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Contrat contrat ; 
	private String role ;

	
	
	@OneToMany(mappedBy="employee" , cascade= {CascadeType.REMOVE} )
	private List<Publication> lstPub;

	@OneToMany(mappedBy="employee" , cascade= {CascadeType.REMOVE} )
	private List<Commentairepub> lstcom;
	
	public List<Publication> getLstPub() {
		return lstPub;
	}

	public void setLstPub(List<Publication> lstPub) {
		this.lstPub = lstPub;
	}

	public List<Commentairepub> getLstcom() {
		return lstcom;
	}

	public void setLstcom(List<Commentairepub> lstcom) {
		this.lstcom = lstcom;
	}

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

	

	
	

	public Employee() {
		super();
	}

	public Employee(String nom, String prenom, String adresse, String email, String sexe, Boolean isActif,
			Date datenaissance, Etatcivil etatcivil) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.sexe = sexe;
		this.isActif = isActif;
		this.datenaissance = datenaissance;
		this.etatcivil = etatcivil;
	}

	public Employee(String nom, String prenom, String adresse, String email, String sexe, Boolean isActif,
			String password, Date datenaissance, Etatcivil etatcivil ,String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.sexe = sexe;
		this.isActif = isActif;
		this.password = password;
		this.datenaissance = datenaissance;
		this.etatcivil = etatcivil;
		this.role = role ;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	
	
	
	


	
	
	
	
}
