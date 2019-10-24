package tn.advyteam.entities;



import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class EvaluationFile {

	@EmbeddedId
	private EvaluationFilePK filepk;
	
	@ManyToOne
	@JoinColumn(name="idEmploye", referencedColumnName="id", insertable=false, updatable=false ) 
	private Employee employe;
	@ManyToOne
	@JoinColumn(name="idEvaluationAnnuel", referencedColumnName="id", insertable=false, updatable=false ) 
	private EvaluationAnnuel evaluationAnnuel;
	
	
	private int noteManager;
	private int noteEmploye;
	private String object;
	private String result;
	
	
	
	
	public EvaluationFile() {
		super();
	}
	
	public EvaluationFile(EvaluationFilePK filepk, Employee employe, EvaluationAnnuel evaluationAnnuel, int noteManager,
			int noteEmploye, String object, String result) {
		super();
		this.filepk = filepk;
		this.employe = employe;
		this.evaluationAnnuel = evaluationAnnuel;
		this.noteManager = noteManager;
		this.noteEmploye = noteEmploye;
		this.object = evaluationAnnuel.getObjectif();
		this.result = result;
	}

	public EvaluationFilePK getFilepk() {
		return filepk;
	}
	public void setFilepk(EvaluationFilePK filepk) {
		this.filepk = filepk;
	}
	

	public Employee getEmploye() {
		return employe;
	}

	public void setEmploye(Employee employe) {
		this.employe = employe;
	}

	public EvaluationAnnuel getEvaluationAnnuel() {
		return evaluationAnnuel;
	}

	public void setEvaluationAnnuel(EvaluationAnnuel evaluationAnnuel) {
		this.evaluationAnnuel = evaluationAnnuel;
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
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}
