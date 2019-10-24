package tn.advyteam.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Evaluation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "e_type")
public class Evaluation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String nom;
	@Column
	private String description;
	@Column 
	private String etat;
	@Column
	private EvaluationType type;
	
	@ManyToMany (mappedBy ="evaluation")
	private List<Employee> employee;
	
	public Evaluation() {
		// TODO Auto-generated constructor stub
	}
	
	public Evaluation(String nom, String description, String etat, EvaluationType type) {
		super();
		this.nom = nom;
		this.description = description;
		this.etat = etat;
		this.type = type;
	}

	public Evaluation(int id, String nom, String description, String etat, EvaluationType type,
			List<Employee> employee) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.etat = etat;
		this.type = type;
		this.employee = employee;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public EvaluationType getType() {
		return type;
	}

	public void setType(EvaluationType type) {
		this.type = type;
	}


	
	
	
}
