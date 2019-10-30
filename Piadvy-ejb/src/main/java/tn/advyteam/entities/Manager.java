package tn.advyteam.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "Manager")
public class Manager extends Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "createdBy", fetch = FetchType.EAGER)
	private List<Projet> projets;
	
	
	public Manager() {
		super();
	}

	public Manager(String nom, String prenom) {
		super(nom, prenom);
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
