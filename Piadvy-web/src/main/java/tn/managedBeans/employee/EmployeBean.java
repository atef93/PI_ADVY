package tn.managedBeans.employee;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tn.advyteam.entities.Contrat;
import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Employee;
import tn.advyteam.entities.Etatcivil;
import tn.advyteam.entities.TypeContrat;
import tn.advyteam.serviceImp.EmployeServiceImp;


@ManagedBean(name="employeBean")
public class EmployeBean implements Serializable{
	
	@EJB
	EmployeServiceImp employeServiceImp ;
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String sexe;
	private Boolean isActif;
	private String password;
	private Date datenaissance;
	private Etatcivil etatcivil ;
	private List<Employee> listemploye ;
	private Employee employe ;
	private Developpeur developpeur;
	
	//contrat
	private int reference;
	private Date datedebut;
	private Date datefin;
	private Float salaire;
	private TypeContrat typeContrat;
	
	

	public void AjouterEmploye() 
	{
		employeServiceImp.addemploye(new Developpeur(nom, prenom));
	
	}
	

	public Employee getEmploye() {
		return employe;
	}



	public void setEmploye(Employee employe) {
		this.employe = employe;
	}

	@PostConstruct
	public void init() {
		this.getEmployes();
	}


	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public EmployeServiceImp getEmployeServiceImp() {
		return employeServiceImp;
	}

	public void setEmployeServiceImp(EmployeServiceImp employeServiceImp) {
		this.employeServiceImp = employeServiceImp;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
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

	public Etatcivil getEtatcivil() {
		return etatcivil;
	}

	public void setEtatcivil(Etatcivil etatcivil) {
		this.etatcivil = etatcivil;
	}

	


	public List<Employee> getEmployes()
	{
		listemploye = employeServiceImp.emps();
		System.out.println(listemploye.size());
		System.out.println(employe.getContrat());

		return listemploye; 
		
	}

	public List<Employee> getListemploye() {
		return listemploye;
	}

	public void setListemploye(List<Employee> listemploye) {
		this.listemploye = listemploye;
	}
	
	
	
	
	public void supprimer(int id)
	{
		employeServiceImp.delete(id);
		getEmployes();
		
	}
	
	
	public void AjouterContrat() 
	{
		employeServiceImp.addContrat(new Contrat(datedebut, datefin, salaire, typeContrat));
	
	}


	public void AjouterContratemp() 
	{
		employeServiceImp.ajoutercontratemploye(new Developpeur(nom, prenom, adresse, email, sexe, isActif, password, datenaissance, etatcivil),new Contrat(datedebut, datefin, salaire, typeContrat));
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
	
	

}
