package tn.managedBeans.evaluation;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.advyteam.entities.Employee;
import tn.advyteam.entities.Evaluation;
import tn.advyteam.entities.EvaluationAnnuel;
import tn.advyteam.entities.EvaluationFile;
import tn.advyteam.entities.EvaluationType;
import tn.advyteam.entities.Objectifs;
import tn.advyteam.serviceImp.EvaluationServiceImp;

@ManagedBean
@ViewScoped
public class EvaluationBean {

	private int id;
	private String nom;
	private String description;
	private boolean etat;
	private EvaluationType type;
	private String objectif;
	private Date rendezVous;
	private Date dateEcheance;
	
	private EvaluationFile ef = new EvaluationFile();
	private List<EvaluationFile> filee;

	private List<EvaluationAnnuel> eval;
	private EvaluationAnnuel evala= new EvaluationAnnuel();
	
	
	private List<Employee> employee;
	private boolean affiche;
	
	
	private int noteManager;
	private int noteEmploye;
	private List<Objectifs> objectifs;
	private String result;
	
	

	private String objec;

	@EJB
	EvaluationServiceImp evalService;
	
	public int getId() {
		return id;
	}


	
	public void addEval() {
		int khra=evalService.addEvaluation( new EvaluationAnnuel(id, nom,  description,  false,  type, employee, objectif,  rendezVous,  dateEcheance));
		int kaka=evalService.addFile(new EvaluationFile( id, objec, noteManager,  noteEmploye,  result));
		evalService.affecter(khra, kaka);
		//int pipi=evalService.addObjectif(new Objectifs(id, obj1, obj2, obj3));
		//evalService.affecterfile(pipi, kaka);
		FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Evaluation ajoutée avec succès !"));
	}
	
	
	public List<EvaluationAnnuel> getEval() {
		 eval = evalService.getAllEvaluationAnnuel();

return eval;
	
	}

	
	
	
	public List<EvaluationFile> getFilee() {
		return filee;
	}



	public List<EvaluationFile> getFil(int ideval) throws IOException {
		// filee = evalService.getFile();
		
FacesContext.getCurrentInstance().getExternalContext().redirect("fileManager.xhtml");
		
		EvaluationAnnuel r= evalService.FindByIdd(ideval);
		EvaluationFile s= r.getFile();
		 int y = s.getId();
		 
		 filee = evalService.getFile(y);
		 for(EvaluationFile f : filee) {
			 RedirectionBean.F=f;
		 }
		System.out.println();
		return filee;
		 
	}
	
	
	
	
	
/*
	public List<Objectifs> getOb() {
		// filee = evalService.getFile();
		System.out.println();
		ob = evalService.getObjectif(24);

		 return ob;
	}*/
	
	public void modifier(EvaluationAnnuel eval) {
		affiche = true;
		this.setNom(eval.getNom());
		this.setDescription(eval.getDescription());
		this.setEtat(eval.getEtat());
		this.setObjectif(eval.getObjectif());
		this.setDateEcheance(eval.getDateEcheance());
		this.setRendezVous(eval.getRendezVous());
		this.setType(eval.getType());
		this.setId(eval.getId());
		System.out.println("ID est"+ id);
		
		}

	public void mettreAjour() {
		System.out.println("méthode mettreajourID est"+ id);
		//evalService.updateEvaluation(new EvaluationAnnuel(id, nom,  description,  etat,  type, employee, objectif,  rendezVous,  dateEcheance));
	evala.setId(id);
	evala.setNom(nom);
	evala.setDescription(description);
	evala.setEtat(etat);
	evala.setObjectif(objectif);
	evala.setDateEcheance(dateEcheance);
	evala.setRendezVous(rendezVous);
	evala.setType(type);
	evalService.updateEvaluation(evala);
	}
	
	public void supprimer(int ide) {
		System.out.println("supp id"+ide);
		evalService.deleteEvaluationById(ide);
	}
	
	public EvaluationBean() {
		super();
	}

	

	
	public void modifierNoteEmp(EvaluationFile thisid) {
		
		System.out.println("méthode mettreajourID est"+ id);

		ef.setId(thisid.getId());
		ef.setObjec(thisid.getObjec());
	ef.setNoteEmploye(thisid.getNoteEmploye());
	ef.setNoteManager(thisid.getNoteManager());
	evalService.updateFile(ef);
	}
	

	
	public void modifierNoteMan(EvaluationFile thisid) {
		
		System.out.println("méthode mettreajourID est"+ id);

	ef.setId(thisid.getId());
	ef.setNoteManager(thisid.getNoteManager());
	ef.setNoteEmploye(thisid.getNoteEmploye());
	ef.setObjec(thisid.getObjec());
	evalService.updateFile(ef);
	}
	


	public String resultEval(EvaluationFile filee) {
		
		int s=(filee.getNoteEmploye()+filee.getNoteManager())/2;
		String res="";
		if(filee.getNoteEmploye()==0 || filee.getNoteManager()==0){
			res="resultat non affecter";
		}
		if(s>0 && s<=50){
			res="votre score est inferieur a 50 vous avez un prime de 1000DT";
			;
		}if(s>50 && s<=70){
			res="votre score a depassé  50 vous avez un prime de 2000DT";
			
		} if(s>70 && s<=100) {
			res="votre score a depassé 70 vous avez un prime de 3000DT";
			
		}
		
		filee.setResult(res);
		evalService.updateFile(filee);

		FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage(res));
		return res;

	}
	
	
	


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	



	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean getEtat() {
		return etat;
	}


	public void setEtat(boolean etat) {
		this.etat = etat;
	}


	public EvaluationType getType() {
		return type;
	}


	public void setType(EvaluationType type) {
		this.type = type;
	}


	public String getObjectif() {
		return objectif;
	}


	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}


	public Date getRendezVous() {
		return rendezVous;
	}


	public void setRendezVous(Date rendezVous) {
		this.rendezVous = rendezVous;
	}


	public Date getDateEcheance() {
		return dateEcheance;
	}


	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}


	


	public void setFilee(List<EvaluationFile> filee) {
		this.filee = filee;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<Employee> getEmployee() {
		return employee;
	}


	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}


	public EvaluationServiceImp getEvalService() {
		return evalService;
	}


	public void setEvalService(EvaluationServiceImp evalService) {
		this.evalService = evalService;
	}
	public void setEval(List<EvaluationAnnuel> eval) {
		this.eval = eval;
	}


	public EvaluationAnnuel getEvala() {
		return evala;
	}


	public void setEvala(EvaluationAnnuel evala) {
		this.evala = evala;
	}


	public boolean isAffiche() {
		return affiche;
	}


	public void setAffiche(boolean affiche) {
		this.affiche = affiche;
	}

	public int getNoteManager() {
		return noteManager;
	}

	public void setNoteManager(int noteManager) {
		this.noteManager = noteManager;
	}

	public int getNoteEmploye() {
		return noteEmploye;
	}

	public void setNoteEmploye(int noteEmploye) {
		this.noteEmploye = noteEmploye;
	}

	public List<Objectifs> getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(List<Objectifs> objectifs) {
		this.objectifs = objectifs;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}




	public String getObjec() {
		return objec;
	}



	public void setObjec(String objec) {
		this.objec = objec;
	}



	public EvaluationFile getEf() {
		return ef;
	}



	public void setEf(EvaluationFile ef) {
		this.ef = ef;
	}



	


	




	
}
