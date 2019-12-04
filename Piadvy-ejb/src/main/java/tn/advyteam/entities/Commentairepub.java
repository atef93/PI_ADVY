package tn.advyteam.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Commentairepub implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	
	@ManyToOne 
	@JoinColumn(name="idpub")
	private Publication pub;
	
	@ManyToOne 
	@JoinColumn(name="id_emp")
	private Employee employee;
	
	
	

	public Commentairepub(Publication pub) {
		super();
		this.pub = pub;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Publication getPub() {
		return pub;
	}

	public void setPub(Publication pub) {
		this.pub = pub;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Commentairepub(long id, String description, Date dateCreation) {
		super();
		this.id = id;
		this.description = description;
		this.dateCreation = dateCreation;
	}

	public Commentairepub(String description, Date dateCreation) {
		super();
		this.description = description;
		this.dateCreation = dateCreation;
	}

	public Commentairepub() {
		super();
	}

	public Commentairepub(String description, Date dateCreation, Publication pub) {
		super();
		this.description = description;
		this.dateCreation = dateCreation;
		this.pub = pub;
	}
	
	

}