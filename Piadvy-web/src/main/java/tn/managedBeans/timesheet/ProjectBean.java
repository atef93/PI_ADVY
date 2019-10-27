package tn.managedBeans.timesheet;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import tn.advyteam.entities.Manager;
import tn.advyteam.entities.Projet;
import tn.advyteam.service.GestionTimesheetRemote;

@ManagedBean(name = "projectBean" , eager = true)
@ApplicationScoped
public class ProjectBean implements Serializable{
	
	
	@EJB
	GestionTimesheetRemote timesheetServiceImp;
	
	private String titre;
	private String description;
	private List<Projet> projets=new ArrayList<Projet>();
	private int idManager=1;
	private int idProjet;
	private Projet selectedProjet;
	
	@PostConstruct
	public void init() {
		projets = timesheetServiceImp.getAllProjectsByManager(idManager);
		selectedProjet = new Projet();
	}
	
	
	public ProjectBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String getTitre() {
		return titre;
	}
	public String getDescription() {
		return description;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Projet> getProjets() {
		return projets;
	}
	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}
	
	
	public int getIdManager() {
		return idManager;
	}


	
	
	
	public int getIdProjet() {
		return idProjet;
	}


	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}


	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}


	
	


	public Projet getSelectedProjet() {
		return selectedProjet;
	}


	public void setSelectedProjet(Projet selectedProjet) {
		this.selectedProjet = selectedProjet;
	}


	public void addProject() throws IOException {
		Projet projet = new Projet();
		projet.setTitre(titre);
		projet.setDescription(description);
		Manager manager = new Manager();
		manager.setId(idManager);
		projet.setCreatedBy(manager);
		timesheetServiceImp.addProject(projet);
		projets.add(projet);
		FacesContext.getCurrentInstance().getExternalContext().redirect("listeProjet.xhtml");

	}
	
	
	public String voirProjet(int projet) throws IOException {
		selectedProjet=timesheetServiceImp.getProjectById(projet);
		System.out.println(selectedProjet);
		return "voirProjet.xhtml";
		//FacesContext.getCurrentInstance().getExternalContext().redirect("voirProjet.xhtml");
	}
	
	
	
	public void supprimerProjet(int id) throws IOException {
		timesheetServiceImp.deleteProjectById(id);
		FacesContext.getCurrentInstance().getExternalContext().redirect("listeProjet.xhtml");

	}
	
	public void modifierProjet(int id) {
		Projet projet = new Projet();
		
		selectedProjet=timesheetServiceImp.getProjectById(id);
		//projet.setId(selectedProjet.getId());
		projet.setTitre(selectedProjet.getTitre());
		projet.setDescription(selectedProjet.getDescription());
		
		timesheetServiceImp.updateProject(selectedProjet, selectedProjet.getId());
		

	}
	
}
