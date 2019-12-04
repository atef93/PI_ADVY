package tn.advyteam.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Formation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;

	private Date dateDebut;

	private Date dateFin;

	private String type;

	private String refnamepar;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Participant participant;

	// Une formation a plusieurs participants et un participant peut s'inscrire a
	// plusieures formations

	// @OneToMany(mappedBy="participants", cascade=CascadeType.ALL)
	/*
	 * @JoinTable( name = "formations_participants", joinColumns = {@JoinColumn(name
	 * = "formation_id", referencedColumnName = "id",insertable=false,
	 * updatable=false)}, inverseJoinColumns = {@JoinColumn(name = "participant_id",
	 * referencedColumnName = "id",insertable=false, updatable=false)})
	 */
	// private List<Participant> participants;

	/*
	 * @OneToOne(mappedBy = "formation", cascade = CascadeType.ALL) private Examen
	 * examen;
	 */

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

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/*
	 * public List<Participant> getParticipant() { return participants; }
	 * 
	 * public void setEmployee(List<Participant> participants) { this.participants =
	 * participants; }
	 */

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRefnamepar() {
		return refnamepar;
	}

	public void setRefnamepar(String refnamepar) {
		this.refnamepar = refnamepar;
	}

}
