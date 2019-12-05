package tn.managedBeans.notefrais;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.management.Notification;
import javax.persistence.Embedded;

import tn.advyteam.entities.DemandeMission;
import tn.advyteam.entities.Employee;
import tn.advyteam.entities.Mission;
import tn.advyteam.serviceImp.GestionMissionService;
import tn.managedBeans.employee.EmployeBean;

/**
 * Session Bean implementation class MissionBean
 */
@ManagedBean
@javax.faces.view.ViewScoped
public class MissionBean implements Serializable {
	private List<Mission> Missions;
	Mission m = new Mission();
	DemandeMission d = new DemandeMission();
	private List<DemandeMission> Demandes;
	private String message="vous n etes pas asser experimente pour faire des missions a l internationnal";
	private int id;
	private boolean etat;
	private String libelle;
	private String description;
	private int ha;
	private Date datee;
	@EJB
	GestionMissionService Gestion ;
    /**
     * Default constructor. 
     */
 
	/*public Mission getM() {
		return m;
	}
	public void setM(Mission m) {
		this.m = m;
	}
	public String getGestion() {
		Date d1 = new Date(2000, 11, 21); 
		m.setDuree(d1);
		m.toString();
		Gestion.AddMission(m);
		return "";
	}
	
	public void setGestion(GestionMissionService gestion) {
		Gestion = gestion;
	}*/
	public List<Mission> getMissions(){
		Missions = Gestion.findAllMission();
		
		return Missions;
	}
	public List<DemandeMission> getDemandes(){
		int i =0;
		Demandes = Gestion.findAllDemandeMission();
		for(DemandeMission dm : Demandes) {
			if(dm.getEtat()==true) {
				i=i+1;
			}
		}
		if (i>3) {
			message="vous pouvez faire des mission international";
		}
		
				     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Executed", "vous ne pouvez plus participer"));	
		
		
		return Demandes;
	}
	public void addMission() {
		 ha=Gestion.AddMission(new Mission(id, libelle, description));
	}
	public void ajout() {
		ha=Gestion.AddMission(m);
	}
	public void addDemande2(DemandeMission m ) {
		Gestion.modifier(m);
	}
	public void addDemande(Mission m) {
		System.out.println("iddddd"+ m.getId());
		int kaka= Gestion.addDemandeMission(new DemandeMission(id, etat)) ;
		Gestion.affecter(kaka,m.getId());

		
	}
	
	
	/*public void GetDemandeMission(Mission m) throws IOException {
		Employee E = new Employee();
		E.setId(1);
		E.setNom("foulen");
		E.setPrenom("sdqds");jhhjhjhjhj
		sdsddsds
	
	// FacesContext.getCurrentInstance().
    //getExternalContext().redirect("AjouterMission.xhtml");
	}*/

	public void setMissions(List<Mission> missions) {
		Missions = missions;
	}
	
	public int getHa() {
		return ha;
	}
	public void setHa(int ha) {
		this.ha = ha;
	}
	public Date getDatee() {
		return datee;
	}
	public void setDatee(Date datee) {
		this.datee = datee;
	}
	public Mission getM() {
		return m;
	}
	public void setM(Mission m) {
		this.m = m;
	}
	public DemandeMission getD() {
		return d;
	}
	public void setD(DemandeMission d) {
		this.d = d;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getha() {
		return ha;
	}
	public void setKhra(int ha) {
		this.ha = ha;
	}
	public GestionMissionService getGestion() {
		return Gestion;
	}
	public void setGestion(GestionMissionService gestion) {
		Gestion = gestion;
	}
	public void setDemandes(List<DemandeMission> demandes) {
		Demandes = demandes;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}