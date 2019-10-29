package tn.advyteam.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "evalcom")
public class CommentEvaluation extends Commentaire implements Serializable {

	
	@ManyToOne
	private Evaluation evaluation;

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}
	
	
	
}
