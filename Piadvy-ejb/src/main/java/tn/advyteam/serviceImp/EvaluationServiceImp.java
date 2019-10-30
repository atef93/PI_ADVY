package tn.advyteam.serviceImp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.advyteam.entities.Evaluation;
import tn.advyteam.entities.EvaluationAnnuel;
import tn.advyteam.entities.EvaluationFile;
import tn.advyteam.entities.Objectifs;
import tn.advyteam.service.GestionEvaluationLocal;

@Stateless
@LocalBean
public class EvaluationServiceImp implements GestionEvaluationLocal{

	@PersistenceContext()
	EntityManager entityMan;



	@Override
	public int addEvaluation(EvaluationAnnuel evala) {
		// TODO Auto-generated method stub
		System.out.println("eval ajouté");
		entityMan.persist(evala);
		return evala.getId();
	


	}

	@Override
	public List<EvaluationAnnuel> getAllEvaluationAnnuel() {
		// TODO Auto-generated method stub
		TypedQuery<EvaluationAnnuel> query =
				entityMan.createQuery("select e from EvaluationAnnuel e",
						EvaluationAnnuel.class);
		return query.getResultList();
	}
	
	public List<EvaluationAnnuel> getEvaluationAnnuelbyEmp(int idemp) {
		// TODO Auto-generated method stub
		TypedQuery<EvaluationAnnuel> query =
				entityMan.createQuery("select e from EvaluationAnnuel e where e.emp=:idemp",
						EvaluationAnnuel.class).setParameter("idemp", idemp);
		return query.getResultList();
	}
	
	
	
	@Override
	public void deleteEvaluationById(int id) {
		// TODO Auto-generated method stub

		System.out.println("Deleting ..."+id);
		EvaluationAnnuel e = FindByIdd(id);
		entityMan.remove(e);
		System.out.println("Deleting ...");
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

	@Override
	public EvaluationAnnuel FindByIdd(int id) {
		// TODO Auto-generated method stub
		return entityMan.find(EvaluationAnnuel.class, id);
	}


//file
	@Override
	public int addFile(EvaluationFile f) {
		// TODO Auto-generated method stub
		System.out.println("file ajouté");
				
		entityMan.persist(f);	
		
	return f.getId();
	}

	@Override
	public void updateFile(EvaluationFile f) {
		// TODO Auto-generated method stub
		entityMan.merge(f);
	}

	

	@Override
	public List<EvaluationFile> getAllFile() {
		// TODO Auto-generated method stub
		TypedQuery<EvaluationFile> query1 =
				entityMan.createQuery("select e from EvaluationFile e ",
						EvaluationFile.class);
		return query1.getResultList();
		
	}
	
	@Override
	public List<EvaluationFile> getFile(int ide) {
		// TODO Auto-generated method stub
		TypedQuery<EvaluationFile>  query1 =
				entityMan.createQuery("select e from EvaluationFile e where id=:ide",
						EvaluationFile.class).setParameter("ide", ide);
		
		return  query1.getResultList();
		
	}
	
	


	@Override
	public void affecter(int idEval, int idFile) {
		// TODO Auto-generated method stub
		EvaluationFile e = entityMan.find(EvaluationFile.class, idFile);
		EvaluationAnnuel ev =entityMan.find(EvaluationAnnuel.class,idEval);
		ev.setFile(e);
	}
	/*
public void  fin(int ide) {
	TypedQuery<EvaluationAnnuel> query2 = entityMan.createQuery("select e from EvaluationAnnuel e where e.file=:ide",
			EvaluationAnnuel.class).setParameter("ide", ide);
	EvaluationAnnuel s = query2.getSingleResult();
	s.setEtat(true);
	entityMan.merge(s);
	
}*/

	/*@Override
	public void affecterfile(int idObj, int idFile) {
		// TODO Auto-generated method stub
		EvaluationFile e = entityMan.find(EvaluationFile.class, idFile);
		Objectifs ob =entityMan.find(Objectifs.class,idObj);
		ob.setFilee(e);
	}*/

	


	public Integer getAllEvalNv1() {
		Query query = entityMan.createQuery("select e from EvaluationFile e where e.noteManager<50",EvaluationFile.class);
		
		
	 
		return query.getResultList().size();
	}
	
	public Integer getAllEvalNv2() {
		Query query = entityMan.createQuery("select e from EvaluationFile e where e.noteManager>50 and e.noteManager<70",EvaluationFile.class);
		
		return query.getResultList().size();
	}

	public Integer getAllEvalNv3() {
		Query query = entityMan.createQuery("select e from EvaluationFile e where e.noteManager>70 ",EvaluationFile.class);
		
		return query.getResultList().size();
	}
}
