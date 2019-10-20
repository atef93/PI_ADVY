package tn.advyteam.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "projetcom")
public class CommentProjet extends Commentaire implements Serializable {

	
	
	@ManyToOne
	private Projet projet;
	
	public CommentProjet() {
		super();
	}

	
	public CommentProjet(Projet projet) {
		super();
		this.projet = projet;
	}


	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
	
}
