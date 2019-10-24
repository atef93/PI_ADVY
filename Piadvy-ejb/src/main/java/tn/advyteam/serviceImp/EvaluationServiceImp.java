package tn.advyteam.serviceImp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.advyteam.entities.Evaluation;
import tn.advyteam.entities.EvaluationAnnuel;
import tn.advyteam.service.GestionEvaluationLocal;

@Stateless
@LocalBean
public class EvaluationServiceImp implements GestionEvaluationLocal{

	@PersistenceContext()
	EntityManager entityMan;

	@Override
	public void addEvaluation(EvaluationAnnuel eva) {
		// TODO Auto-generated method stub
		System.out.println("eval ajouté");
		entityMan.persist(eva);	
	}

	@Override
	public List<EvaluationAnnuel> getAllEvaluationAnnuel() {
		// TODO Auto-generated method stub
		TypedQuery<EvaluationAnnuel> query =
				entityMan.createQuery("select e from EvaluationAnnuel e",
						EvaluationAnnuel.class);
		return query.getResultList();
	}

	@Override
	public void deleteEvaluationById(int id) {
		// TODO Auto-generated method stub
System.out.println("Deleting ...");

		Evaluation e = FindById(id);
		entityMan.remove(e);
		
	}

	@Override
	public void updateEvaluation(EvaluationAnnuel e) {
		// TODO Auto-generated method stub
		entityMan.merge(e);
	}
	
	
	
	@Override
	public Evaluation FindById(int id) {
		// TODO Auto-generated method stub
		return entityMan.find(Evaluation.class, id);

	}



}
