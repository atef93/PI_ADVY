package tn.advyteam.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="EvaluationAnnuel")
@DiscriminatorValue(value = "evaluationAnnuel")
public class EvaluationAnnuel extends Evaluation implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String objectif;
	@Column 
	private Date rendezVous;
	@Column
	private Date dateEcheance;
	@OneToMany (mappedBy="evaluationAnnuel")
	private List<EvaluationFile> filee;
	@OneToOne
	private Employee emp;
	
	public EvaluationAnnuel() {
		super();
	}
	public EvaluationAnnuel(int id, String objectif, Date rendezVous, Date dateEcheance) {
		super();
		this.id = id;
		this.objectif = objectif;
		this.rendezVous = rendezVous;
		this.dateEcheance = dateEcheance;
	}
	
	public EvaluationAnnuel(int id, String nom, String description, String etat, EvaluationType type,
			List<Employee> employee,String objectif, Date rendezVous, Date dateEcheance) {
		super( id,nom, description, etat, type, employee);
		// TODO Auto-generated constructor stub
		this.objectif = objectif;
		this.rendezVous = rendezVous;
		this.dateEcheance = dateEcheance;
	}
	
	public EvaluationAnnuel( String nom, String description, String etat, EvaluationType type,
			List<Employee> employee,String objectif, Date rendezVous, Date dateEcheance,int id) {
		super( id,nom, description, etat, type, employee);
		// TODO Auto-generated constructor stub
		this.objectif = objectif;
		this.rendezVous = rendezVous;
		this.dateEcheance = dateEcheance;
		this.id=id;
	}
	public EvaluationAnnuel(String nom, String description, String etat, EvaluationType type) {
		super(nom, description, etat, type);
		// TODO Auto-generated constructor stub
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
	public Date getRendezVous() {
		return rendezVous;
	}
	public void setRendezVous(Date rendezVous) {
		this.rendezVous = rendezVous;
	}
	public Date getDateEcheance() {
		return dateEcheance;
	}
	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}
	public List<EvaluationFile> getFile() {
		return filee;
	}
	public void setFile(List<EvaluationFile> file) {
		this.filee = file;
	}
	public List<EvaluationFile> getFilee() {
		return filee;
	}
	public void setFilee(List<EvaluationFile> filee) {
		this.filee = filee;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public EvaluationAnnuel(String objectif, Date rendezVous, Date dateEcheance, Employee emp) {
		super();
	
		this.objectif = objectif;
		this.rendezVous = rendezVous;
		this.dateEcheance = dateEcheance;
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "EvaluationAnnuel [id=" + id + ", objectif=" + objectif + ", rendezVous=" + rendezVous
				+ ", dateEcheance=" + dateEcheance + ", emp=" + emp + "]";
	}

	
	
}
