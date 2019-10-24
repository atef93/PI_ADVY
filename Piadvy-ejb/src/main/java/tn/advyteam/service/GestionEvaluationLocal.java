package tn.advyteam.service;

import java.util.List;

import tn.advyteam.entities.Evaluation;
import tn.advyteam.entities.EvaluationAnnuel;

public interface GestionEvaluationLocal {
	public void addEvaluation(EvaluationAnnuel eva);
	public List<EvaluationAnnuel> getAllEvaluationAnnuel();
	public void deleteEvaluationById(int id);
	public void updateEvaluation(EvaluationAnnuel e);
	public Evaluation FindById(int id);


}
