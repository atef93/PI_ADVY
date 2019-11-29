package tn.managedBeans.timesheet;

import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.MoveEvent;
import org.primefaces.event.SelectEvent;

import tn.advyteam.entities.Manager;
import tn.advyteam.entities.Projet;
import tn.advyteam.entities.Timesheet;
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
    private Date date1;
    private Date date2;
	private String color;
	
	private Projet projetToUpdate;
	
	
	private List<Timesheet> timesheets = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		projets = timesheetServiceImp.getAllProjectsByManager(idManager);
		selectedProjet = new Projet();
	}
	
	
	public ProjectBean() {
		// TODO Auto-generated constructor stub
	}
	
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    
	
    public void save() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :");
        FacesContext.getCurrentInstance().addMessage(null, msg);
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
	

	public List<Timesheet> getTimesheets() {
		return timesheets;
	}


	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
	
	
	public String getColor() {
		return this.color;
	}


	public void setColor(String color) {
		this.color = color;
	}

	

	public Date getDate1() {
		return date1;
	}


	public Date getDate2() {
		return date2;
	}


	public void setDate1(Date date1) {
		this.date1 = date1;
	}


	public void setDate2(Date date2) {
		this.date2 = date2;
	}


	public void addProject() throws IOException {
		Projet projet = new Projet();
		projet.setTitre(titre);
		projet.setDescription(description);
		projet.setDateDebut(date1);
		projet.setDeadline(date2);
		Manager manager = new Manager();
		manager.setId(idManager);
		projet.setCreatedBy(manager);
		timesheetServiceImp.addProject(projet);
		projets.add(projet);
		FacesContext.getCurrentInstance().getExternalContext().redirect("listeProjet.xhtml");

	}
	
	
	public String voirProjet(int projet) throws IOException {
		selectedProjet=timesheetServiceImp.getProjectById(projet);
		timesheets=timesheetServiceImp.getAllTimesheetsByProject(selectedProjet.getId());
		
		for(Timesheet time: timesheets) {
			System.out.println(time);
		}
		
		System.out.println(selectedProjet);
		return "voirProjet.xhtml";
		//FacesContext.getCurrentInstance().getExternalContext().redirect("voirProjet.xhtml");
	}
	
	
	
	public void supprimerProjet(int id) throws IOException {
		timesheetServiceImp.deleteProjectById(id);
		FacesContext.getCurrentInstance().getExternalContext().redirect("listeProjet.xhtml");

	}
	
	public void modifierProjet() throws IOException {
		int id = 0 ;
		Map<String, String> paramMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		if(paramMap.get("id") != null) {
			id = Integer.parseInt(paramMap.get("id"));
		}
		
		projetToUpdate = timesheetServiceImp.getProjectById(id);
		
		
		
		//selectedProjet=timesheetServiceImp.getProjectById(id);
		//projet.setId(selectedProjet.getId());
		//projet.setTitre(selectedProjet.getTitre());
		//projet.setDescription(selectedProjet.getDescription());	
		timesheetServiceImp.updateProject(projetToUpdate, id);
		FacesContext.getCurrentInstance().getExternalContext().redirect("listeProjet.xhtml");

	}
	
	public void supprimertimesheet(int id) throws IOException {
		System.out.println("methode delete...");
		timesheetServiceImp.deleteTimesheetById(id);
		FacesContext.getCurrentInstance().getExternalContext().redirect("listeProjet.xhtml");
	}
	
	
	public String goToPage(int id) {
		return "modifierProjet.xhtml?id="+id;
	}
	
	
	
	
	//========================================== Create Filter =========================//
	
	private List<Timesheet> filteredTimesheet;
	
	   public boolean filterByPrice(Object value, Object filter, Locale locale) {
	        String filterText = (filter == null) ? null : filter.toString().trim();
	        if(filterText == null||filterText.equals("")) {
	            return true;
	        }
	         
	        if(value == null) {
	            return false;
	        }
	         
	        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
	}
	   public boolean filterByTitre(String titre) {
	        String filterText = (titre == null) ? null : titre.toString().trim();
	        if(filterText == null||filterText.equals("")) {
	            return true;
	        }
	         
	        
	        return false; 
	}
	
	    List<String> titres = new ArrayList<>();

	   
	   public List<String> getTitres() {
	        for(Timesheet t: timesheets) {
	        	titres.add(t.getTitre());
	        }
	        return titres;
	    }


	public List<Timesheet> getFilteredTimesheet() {
		return filteredTimesheet;
	}


	public void setFilteredTimesheet(List<Timesheet> filteredTimesheet) {
		this.filteredTimesheet = filteredTimesheet;
	}


	public void setTitres(List<String> titres) {
		this.titres = titres;
	}


	public Projet getProjetToUpdate() {
		return projetToUpdate;
	}


	public void setProjetToUpdate(Projet projetToUpdate) {
		this.projetToUpdate = projetToUpdate;
	}
	
	//////////////////////////////////////////
	   public void handleClose(CloseEvent event) {
	        addMessage(event.getComponent().getId() + " closed", "So you don't like nature?");
	    }
	     
	    public void handleMove(MoveEvent event) {
	        addMessage(event.getComponent().getId() + " moved", "Left: " + event.getLeft() + ", Top: " + event.getTop());
	    }
	     
	    public void destroyWorld() {
	        addMessage("System Error", "Please try again later.");
	    }
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	
	     
//	    public List<String> getColors() {
//	        return service.getColors();
//	    }
//	     
//	    public List<Car> getCars() {
//	        return cars;
//	    }
//	 
//	    public List<Car> getFilteredCars() {
//	        return filteredCars;
//	    }
//	 
//	    public void setFilteredCars(List<Car> filteredCars) {
//	        this.filteredCars = filteredCars;
//	    }
//	 
//	    public void setService(CarService service) {
//	        this.service = service;
//	    }
	   
	   
}