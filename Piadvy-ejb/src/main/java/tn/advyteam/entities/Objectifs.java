package tn.advyteam.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Objectifs")
@DiscriminatorValue(value = "objectifs")
public class Objectifs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String obj1;
	private String obj2;
	private String obj3;
	
	@ManyToOne
	private EvaluationFile filee;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObj1() {
		return obj1;
	}
	public void setObj1(String obj1) {
		this.obj1 = obj1;
	}
	public String getObj2() {
		return obj2;
	}
	public void setObj2(String obj2) {
		this.obj2 = obj2;
	}
	public EvaluationFile getFilee() {
		return filee;
	}
	public void setFilee(EvaluationFile filee) {
		this.filee = filee;
	}
	public String getObj3() {
		return obj3;
	}
	public void setObj3(String obj3) {
		this.obj3 = obj3;
	}
	public Objectifs(int id, String obj1, String obj2, String obj3, EvaluationFile filee) {
		super();
		this.id = id;
		this.obj1 = obj1;
		this.obj2 = obj2;
		this.obj3 = obj3;
		this.filee=filee;
	
		
	
	}
	public Objectifs(int id, String obj1, String obj2, String obj3) {
		super();
		this.id = id;
		this.obj1 = obj1;
		this.obj2 = obj2;
		this.obj3 = obj3;
	
		
	
	}
	public Objectifs() {
		super();
	}
	
	
}
