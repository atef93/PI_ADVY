package tn.advyteam.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Timesheet {

	
	@EmbeddedId
	private TimesheetPK timesheetPk;
	@Column
	private TimesheetEtat timesheetEtat;
	@OneToMany(mappedBy = "timesheet")
	private List<CommentTimesheet> commentsTimesheet;
	@Column
	private Date dateDebut;
	@Column
	private Date deadline;
	@OneToMany(mappedBy = "timesheet")
	private List<Tache> taches;
	
	@ManyToOne
	@JoinColumn(name = "idDeveloppeur", referencedColumnName = "id", insertable=false, updatable=false)
	private Developpeur developpeur;
	
	@ManyToOne
	@JoinColumn(name="idProjet", referencedColumnName = "id", insertable=false, updatable=false)
	private Projet projet;
	
	
	public Timesheet() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Timesheet(TimesheetEtat timesheetEtat, Date dateDebut, Date deadline) {
		super();
		this.timesheetEtat = timesheetEtat;
		this.dateDebut = dateDebut;
		this.deadline = deadline;
	}



	public Date getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}



	public TimesheetEtat getTimesheetEtat() {
		return timesheetEtat;
	}

	public List<CommentTimesheet> getCommentsTimesheet() {
		return commentsTimesheet;
	}

	public void setTimesheetEtat(TimesheetEtat timesheetEtat) {
		this.timesheetEtat = timesheetEtat;
	}

	public void setCommentsTimesheet(List<CommentTimesheet> commentsTimesheet) {
		this.commentsTimesheet = commentsTimesheet;
	}



	public Date getDeadline() {
		return deadline;
	}



	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}



	public TimesheetPK getTimesheetPk() {
		return timesheetPk;
	}



	public List<Tache> getTaches() {
		return taches;
	}



	public Developpeur getDeveloppeur() {
		return developpeur;
	}



	public Projet getProjet() {
		return projet;
	}



	public void setTimesheetPk(TimesheetPK timesheetPk) {
		this.timesheetPk = timesheetPk;
	}



	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}



	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}



	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
		
}
