package tn.advyteam.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorColumn(name = "Mission")
public class Mission implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	@Column
	private String libelle;
	@Column
	private String description;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column
	private Date duree;
	@Column
	private boolean etat;
    @JsonIgnore
	@OneToOne(mappedBy = "mission")
	private Employee emp;
    @JsonIgnore
	@OneToMany(mappedBy = "m")
	private List<NoteFrais> notefrais;
	
    @JsonIgnore
	@OneToMany(mappedBy = "missions")
	private List<DemandeMission> demandesMission;
	
	public Mission () {
		
	}

	public Mission(int id, String libelle, String description, Date duree, boolean etat, Employee emp) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.etat = etat;
		this.emp = emp;
	}

	public Mission(int id, String libelle, String description) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
	}

	public Mission(String libelle, String description, Date duree, boolean etat, Employee emp) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.etat = etat;
		this.emp = emp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDuree() {
		return duree;
	}

	public void setDuree(Date duree) {
		this.duree = duree;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public List<DemandeMission> getDemandesMission() {
		return demandesMission;
	}

	public void setDemandesMission(List<DemandeMission> demandesMission) {
		this.demandesMission = demandesMission;
	}

	
	
}
	