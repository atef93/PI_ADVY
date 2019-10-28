package tn.advyteam.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Timesheet implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Embedded
	private TimesheetPK timesheetPk;
	@Column
	private String titre;
	@Column
	private String description;
	@Enumerated(EnumType.STRING)
	private TimesheetEtat timesheetEtat;
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date deadline;
	
	@OneToMany(mappedBy = "timesheet")
	private List<Tache> taches;
	@Column
	private long heureEstime;
	@Column
	private long heurePasse;
	@Column(name = "minutePasse")
	private long minutePasse;
	
	
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
						Date dateDebut, Date deadline, long heureEstime) {
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



	public void setTimesheetEtat(TimesheetEtat timesheetEtat) {
		this.timesheetEtat = timesheetEtat;
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



	public long getHeurePasse() {
		return heurePasse;
	}



	public void setHeureEstime(long heureEstime) {
		this.heureEstime = heureEstime;
	}



	public void setHeurePasse(long f) {
		this.heurePasse = f;
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

	


	public long getMinutePasse() {
		return minutePasse;
	}



	public void setMinutePasse(long minutePasse) {
		this.minutePasse = minutePasse;
	}

	


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "id= "+ id +", Timesheet titre=" + titre + ", description=" + description + ", timesheetEtat=" + timesheetEtat
				+ ", dateDebut=" + dateDebut + ", deadline=" + deadline + ", heureEstime=" + heureEstime
				+ ", heurePasse=" + heurePasse + ", developpeur=" + developpeur + ", projet=" + projet + "]";
	}
	
		
	
}
