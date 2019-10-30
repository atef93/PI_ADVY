package tn.advyteam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="EvaluationFile")
@DiscriminatorValue(value = "evaluationfile")
public class EvaluationFile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String objec;
	
	private int noteManager;
	private int noteEmploye;
	private String result;
	
	
	@OneToOne(mappedBy="file" , cascade=CascadeType.PERSIST)
	private EvaluationAnnuel eva;
	@OneToMany(mappedBy="filee",fetch=FetchType.EAGER)
	private List<Objectifs> objectifs = new ArrayList<Objectifs>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public EvaluationAnnuel getEva() {
		return eva;
	}
	public void setEva(EvaluationAnnuel eva) {
		this.eva = eva;
	}
	public List<Objectifs> getObjectifs() {
		return objectifs;
	}
	public void setObjectifs(List<Objectifs> objectifs) {
		this.objectifs = objectifs;
	}
	
	
	public String getObjec() {
		return objec;
	}
	public void setObjec(String objec) {
		this.objec = objec;
	}
	public EvaluationFile(int id,String objec, int noteManager, int noteEmploye, String result) {
		super();
		this.id = id;
		this.objec=objec;
		this.noteManager = noteManager;
		this.noteEmploye = noteEmploye;
		this.result = result;
	
	}
	public EvaluationFile() {
		super();
	}
	
	
	
}
