package tn.managedBeans.timesheet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Projet;
import tn.advyteam.service.GestionTimesheetRemote;

@ManagedBean
@ApplicationScoped
public class TimesheetBean {

	private Developpeur developpeur;
	private Projet projet;
	private String titre;
    private Date date1;
    private Date date2;
    private int heureEstime;
    private List<String> names;
    private String selectedName;
    private String description;
    private List<Developpeur> developpeurs = new ArrayList<>();
    
	@EJB
	GestionTimesheetRemote timesheetServiceImp;
    
    
	public TimesheetBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		
		names = new ArrayList<String>();
		
		names.add("Atef");
		names.add("wassim");
		names.add("arafet");
		
//		Developpeur dev = new Developpeur("Atef", "Jlassi");
//		Developpeur dev2 = new Developpeur("Foulen", "Ben foulen");
//		Developpeur dev3 = new Developpeur("3ellen", "ben 3ellen");
//		
//		dev.setId(20);
//		dev2.setId(21);
//		dev3.setId(22);
//		
//		developpeurs.add(dev);
//		developpeurs.add(dev2);
//		developpeurs.add(dev3);
		
//		developpeurs = timesheetServiceImp.getAllDeveloppeur();
//		
//		for(Developpeur dev: developpeurs) {
//			names.add(dev.getNom());
//		}
	
	}
	
	public void addTimesheet() {
		
		System.out.println(titre);
		System.out.println(heureEstime+" heure");
		System.out.println(description);
		System.out.println(date1);
		System.out.println(date2);
	}
	
	
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    
	
    public void save() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + developpeur.getNom());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	

    
	public Developpeur getDeveloppeur() {
		return developpeur;
	}


	


	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
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


	public int getHeureEstime() {
		return heureEstime;
	}


	public void setHeureEstime(int heureEstime) {
		this.heureEstime = heureEstime;
	}


	public List<String> getNames() {
		return names;
	}


	public void setNames(List<String> names) {
		this.names = names;
	}


	public String getSelectedName() {
		return selectedName;
	}


	public void setSelectedName(String selectedName) {
		this.selectedName = selectedName;
	}

	public Projet getProjet() {
		return projet;
	}

	public String getTitre() {
		return titre;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Developpeur> getDeveloppeurs() {
		return developpeurs;
	}

	public void setDeveloppeurs(List<Developpeur> developpeurs) {
		this.developpeurs = developpeurs;
	}
	
	

	
	
	
	
}
