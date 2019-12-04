package tn.advyteam.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AttestationTest implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTest;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date Date;
	@Column
	private String type ;
	@Column
	private String nom ;
	@OneToOne
    private AutoTest auto;
	@ManyToOne
	private Employee emp;
    
    
  

	public AttestationTest() {
		super();
	}
	public AttestationTest(int idTest, java.util.Date date, String type, String nom, AutoTest auto) {
		super();
		this.idTest = idTest;
		Date = date;
		this.type = type;
		this.nom = nom;
		this.auto = auto;
	}
	public int getIdTest() {
		return idTest;
	}
	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}
	public java.util.Date getDate() {
		return Date;
	}
	public void setDate(java.util.Date date) {
		Date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public AutoTest getAuto() {
		return auto;
	}
	public void setAuto(AutoTest auto) {
		this.auto = auto;
	}

    
}
