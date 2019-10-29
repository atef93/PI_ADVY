package tn.advyteam.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_emp")
public class Employee implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	private Boolean EnMission=false;
	
	@OneToMany(mappedBy = "employees")
	private List<DemandeMission> demandesMission;
	
	public Employee() {
		super();
	}
	public Employee(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}



	public Boolean getEnMission() {
		return EnMission;
	}



	public void setEnMission(Boolean enMission) {
		EnMission = enMission;
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
	

	public List<DemandeMission> getDemandesMission() {
		return demandesMission;
	}
	public void setDemandesMission(List<DemandeMission> demandesMission) {
		this.demandesMission = demandesMission;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
}
