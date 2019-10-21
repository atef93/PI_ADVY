package tn.advyteam.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class Timesheet implements Serializable {

	
	@EmbeddedId
	private TimesheetPK timesheetPk;
	@Column
	private String titre;
	@Column
	private String description;
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
	@Column
	private float heureEstime;
	@Column
	private float heurePasse;
	@Transient
	private Timer timer;
	@Transient
	private TimerTask timerTask;	
	
	@ManyToOne
	@JoinColumn(name = "idDeveloppeur", referencedColumnName = "id", insertable=false, updatable=false, nullable = true)
	private Developpeur developpeur;
	
	@ManyToOne
	@JoinColumn(name="idProjet", referencedColumnName = "id", insertable=false, updatable=false, nullable = true)
	private Projet projet;
	
	
	public Timesheet() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Timesheet(String titre, String description, TimesheetEtat timesheetEtat,
						Date dateDebut, Date deadline, float heureEstime) {
		super();
		this.timesheetEtat = timesheetEtat;
		this.dateDebut = dateDebut;
		this.deadline = deadline;
		this.heureEstime = heureEstime;
		this.titre=titre;
		this.description=description;
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



	public float getHeureEstime() {
		return heureEstime;
	}



	public float getHeurePasse() {
		return heurePasse;
	}



	public Timer getTimer() {
		return timer;
	}



	public void setHeureEstime(float heureEstime) {
		this.heureEstime = heureEstime;
	}



	public void setHeurePasse(float heurePasse) {
		this.heurePasse = heurePasse;
	}



	public void setTimer(Timer timer) {
		this.timer = timer;
	}



	public String getTitre() {
		return titre;
	}



	public String getDescription() {
		return description;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "Timesheet [titre=" + titre + ", description=" + description + ", timesheetEtat=" + timesheetEtat
				+ ", dateDebut=" + dateDebut + ", deadline=" + deadline + ", heureEstime=" + heureEstime
				+ ", heurePasse=" + heurePasse + ", developpeur=" + developpeur + ", projet=" + projet + "]";
	}
	
		
	
}
