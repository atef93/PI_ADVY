package tn.advyteam.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EvaluationFilePK implements Serializable {

	
	private int idEmploye;
	private int idEvaluationAnnuel;
	
	
	public int getIdEmploye() {
		return idEmploye;
	}
	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}
	public int getIdEvaluationAnnuel() {
		return idEvaluationAnnuel;
	}
	public void setIdEvaluationAnnuel(int idEvaluationAnnuel) {
		this.idEvaluationAnnuel = idEvaluationAnnuel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmploye;
		result = prime * result + idEvaluationAnnuel;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvaluationFilePK other = (EvaluationFilePK) obj;
		if (idEmploye != other.idEmploye)
			return false;
		if (idEvaluationAnnuel != other.idEvaluationAnnuel)
			return false;
		return true;
	}
	
	
	
	

	
	
	
	
}
