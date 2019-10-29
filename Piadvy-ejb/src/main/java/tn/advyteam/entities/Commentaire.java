package tn.advyteam.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_com")
public class Commentaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String comment;
	
	public Commentaire() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public String getComment() {
		return comment;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	
	
}
