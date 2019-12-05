package tn.advyteam.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class NoteFrais implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	@Column
	private double montant;
	@Column
	private String libelle;
	@Column
	private Boolean Remboursable  ;
	@Column
	private double tauxderembourssement;
		@ManyToOne
	private Mission m;


	


}
