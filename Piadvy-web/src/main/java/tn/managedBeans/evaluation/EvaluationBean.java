package tn.managedBeans.evaluation;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.advyteam.entities.Employee;
import tn.advyteam.entities.EvaluationAnnuel;
import tn.advyteam.entities.EvaluationFile;
import tn.advyteam.entities.EvaluationType;
import tn.advyteam.serviceImp.EvaluationServiceImp;

@ManagedBean
@ViewScoped
public class EvaluationBean {

	private int id;
	private String nom;
	private String description;
	private String etat;
	private EvaluationType type;
	private String objectif;
	private Date rendezVous;
	private Date dateEcheance;
	private List<EvaluationFile> filee;
	private List<EvaluationAnnuel> eval;
	private EvaluationAnnuel evala= new EvaluationAnnuel();
	
	private int evalToUpdate;
	
	private List<Employee> employee;
	private boolean affiche;
	
	
	@EJB
	EvaluationServiceImp evalService;
	
	public int getId() {
		return id;
	}

	
	public void addEval() {
		evalService.addEvaluation(new EvaluationAnnuel(id, nom,  description,  etat,  type, employee, objectif,  rendezVous,  dateEcheance));
	}
	public List<EvaluationAnnuel> getEval() {
		 eval = evalService.getAllEvaluationAnnuel();

return eval;
	
	}
	
	public void modifier(EvaluationAnnuel eval) {
		affiche = true;
		this.setNom(eval.getNom());
		this.setDescription(eval.getDescription());
		this.setEtat(eval.getEtat());
		this.setObjectif(eval.getObjectif());
		this.setDateEcheance(eval.getDateEcheance());
		this.setRendezVous(eval.getRendezVous());
		this.setEmployee(eval.getEmployee());
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
	evala.setEmployee(employee);
	evala.setType(type);
	evalService.updateEvaluation(evala);
	}
	
	public void supprimer(int ide) {
		evalService.deleteEvaluationById(ide);
	}
	
	public EvaluationBean() {
		super();
	}


	public EvaluationBean(String nom, String description, String etat, EvaluationType type, String objectif,
			Date rendezVous, Date dateEcheance, Employee employee,int id) {
		super();
		this.nom = nom;
		this.description = description;
		this.etat = etat;
		this.type = type;
		this.objectif = objectif;
		this.rendezVous = rendezVous;
		this.dateEcheance = dateEcheance;
		this.id=id;
	}


	public EvaluationBean(String nom, String description, EvaluationType type, List<Employee> employee) {
		super();
		this.nom = nom;
		this.description = description;
		this.type = type;
		this.employee = employee;
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


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
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


	public List<EvaluationFile> getFilee() {
		return filee;
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
	public int getEvalToUpdate() {
		return evalToUpdate;
	}
	public void setEvalToUpdate(int evalToUpdate) {
		this.evalToUpdate = evalToUpdate;
	}
	

}
