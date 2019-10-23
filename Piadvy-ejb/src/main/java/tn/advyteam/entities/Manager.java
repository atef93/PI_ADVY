package tn.advyteam.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "Manager")
public class Manager extends Employee implements Serializable{

	@OneToMany(mappedBy = "createdBy")
	private List<Projet> projets;
	
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}


	public Manager(List<Projet> projets) {
		super();
		this.projets = projets;
	}


	public List<Projet> getProjets() {
		return projets;
	}


	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}
	
	
}
