package tn.advyteam.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Projet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5480113447701511433L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String titre;
	@Column
	private String description;
	@ManyToOne
	private Manager createdBy;
	@OneToMany(mappedBy = "projet")
	private List<CommentProjet> commentsProjet;
	@OneToMany(mappedBy = "projet")
	private List<Timesheet> timesheets;
	
	
	public Projet() {
		// TODO Auto-generated constructor stub
	}

	

	public Projet(String titre, String description, Manager createdBy) {
		super();
		this.titre = titre;
		this.description = description;
		this.createdBy = createdBy;
	}



	public int getId() {
		return id;
	}


	public String getTitre() {
		return titre;
	}


	public String getDescription() {
		return description;
	}


	public Manager getCreatedBy() {
		return createdBy;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}

	

	public List<CommentProjet> getCommentsProjet() {
		return commentsProjet;
	}



	public void setCommentsProjet(List<CommentProjet> commentsProjet) {
		this.commentsProjet = commentsProjet;
	}



	public void setDescription(String description) {
		this.description = description;
	}


	public void setCreatedBy(Manager createdBy) {
		this.createdBy = createdBy;
	}



	public List<Timesheet> getTimesheets() {
		return timesheets;
	}



	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}



	@Override
	public String toString() {
		return "Projet [id=" + id + ", titre=" + titre + ", description=" + description + ", createdBy=" + createdBy
				+ "]";
	}



	
}
