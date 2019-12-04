package tn.advyteam.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Examen implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private int note;

	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;

	private String nomExamen;

	private String typeExam;

	private String catExam;

	private String participant ;
	private String formation;
	
	private int idPar; 

	private int idFor;

	public Examen() {
	}

	public int getIdn() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNomExamen() {
		return nomExamen;
	}

	public void setNomExamen(String nomExamen) {
		this.nomExamen = nomExamen;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTypeExam() {
		return typeExam;
	}

	public void setTypeExam(String typeExam) {
		this.typeExam = typeExam;
	}

	public String getCatExam() {
		return catExam;
	}

	public void setCatExam(String catExam) {
		this.catExam = catExam;
	}

	public int getIdPar() {
		return idPar;
	}

	public void setIdPar(int idPar) {
		this.idPar = idPar;
	}

	public int getIdFor() {
		return idFor;
	}

	public void setIdFor(int idFor) {
		this.idFor = idFor;
	}

	public String getParticipant() {
		return participant;
	}

	public void setParticipant(String participant) {
		this.participant = participant;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

}
