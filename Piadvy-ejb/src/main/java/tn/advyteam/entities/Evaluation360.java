package tn.advyteam.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="EvaluationAnnuel")
@DiscriminatorValue(value = "360")
public class Evaluation360 extends Evaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String objectif;
	@Column
	private Date dateDeb;
	@Column
	private Date dateFin;
	
	
	
	public Evaluation360() {
		super();
	}
	public Evaluation360(int id, String objectif, Date dateDeb, Date dateFin) {
		super();
		this.id = id;
		this.objectif = objectif;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	
}
