package tn.advyteam.entities;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Publication implements Serializable  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	private Boolean isActif ;
	
	@ManyToOne 
	@JoinColumn(name="id_emp")
	private Employee employee;
	

	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@OneToMany
	(mappedBy="pub",cascade= {CascadeType.REMOVE},fetch=FetchType.EAGER)
	private List<Commentairepub> lstComm = new ArrayList<>();
	
	
	public List<Commentairepub> getLstComm() {
		return lstComm;
	}
	public void setLstComm(List<Commentairepub> lstComm) {
		this.lstComm = lstComm;
	}
	
	Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Publication() {
		super();
	}
	public Publication(String description, Date dateCreation) {
		super();
		this.description = description;
		this.dateCreation = dateCreation;
	}
	public Publication(Long id, String description, Date dateCreation) {
		super();
		this.id = id;
		this.description = description;
		this.dateCreation = dateCreation;
	}
	
	public Publication( String description) {
		super();
		
		this.description = description;
	}
	public Boolean getIsActif() {
		return isActif;
	}
	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}
	public Publication(String description, Date dateCreation, Boolean isActif) {
		super();
		this.description = description;
		this.dateCreation = dateCreation;
		this.isActif = isActif;
	}
	
	
	
	
	}
