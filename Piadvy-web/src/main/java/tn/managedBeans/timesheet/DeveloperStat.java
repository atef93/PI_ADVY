package tn.managedBeans.timesheet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Projet;
import tn.advyteam.service.GestionTimesheetRemote;

@ManagedBean
public class DeveloperStat {

	

    private List<Developpeur> developpeurs = new ArrayList<>();
    private Developpeur developpeur;
    private List<Projet> projet = new ArrayList<>();
    private int idD;
    private int idP;
    
    @EJB
	GestionTimesheetRemote timesheetServiceImp;
    
	public DeveloperStat() {
	
	}
	
	@PostConstruct
	public void init() {
		
		developpeurs = timesheetServiceImp.getAllDeveloppeur();
	
	}
	
	
	public String consulteDevPr(int id) throws IOException {
		
		projet = timesheetServiceImp.getAllProjetByEmploye(id);
		idD=id;
		return "projetsDev.xhtml";
		
		//FacesContext.getCurrentInstance().getExternalContext().redirect("projetsDev.xhtml");
	}
	
	
	
	
	
	
	
	
	public List<Developpeur> getDeveloppeurs() {
		return developpeurs;
	}

	public void setDeveloppeurs(List<Developpeur> developpeurs) {
		this.developpeurs = developpeurs;
	}

	public Developpeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}

	public List<Projet> getProjet() {
		return projet;
	}

	public void setProjet(List<Projet> projet) {
		this.projet = projet;
	}

	public int getIdD() {
		return idD;
	}

	public void setIdD(int idD) {
		this.idD = idD;
	}

	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
	}
	
	
	
	
	
	
}
