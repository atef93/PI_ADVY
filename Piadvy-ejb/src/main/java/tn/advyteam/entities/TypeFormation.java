package tn.advyteam.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="typeformation")
public class TypeFormation implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3798331481569268732L;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private String type;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}

