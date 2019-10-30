package tn.advyteam.service;

import java.util.List;

import tn.advyteam.entities.Evaluation;
import tn.advyteam.entities.EvaluationAnnuel;
import tn.advyteam.entities.EvaluationFile;

public interface GestionEvaluationLocal {
	public int addEvaluation(EvaluationAnnuel eva);
	public List<EvaluationAnnuel> getAllEvaluationAnnuel();
	public void deleteEvaluationById(int id);
	public void updateEvaluation(EvaluationAnnuel e);
	public Evaluation FindById(int id);
	public int addFile(EvaluationFile f);
	public void updateFile(EvaluationFile f);
	public EvaluationAnnuel FindByIdd(int id);
	public void affecter(int idEval,int idFile);
	public List<EvaluationFile> getAllFile();
	public List<EvaluationFile> getFile(int id) ;
	

}
