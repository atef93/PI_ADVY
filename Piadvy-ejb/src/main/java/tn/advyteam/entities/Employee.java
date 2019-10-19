package tn.advyteam.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	
	@Id
	private int id;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
