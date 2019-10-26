package tn.managedBeans.timesheet;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Timesheet;
import tn.advyteam.service.GestionTimesheetRemote;

@ManagedBean
@ViewScoped
public class TimesheetBean {

	private Developpeur developpeur;
	private Timesheet timesheet;
    private Date date1;
    private Date date2;

	@EJB
	GestionTimesheetRemote timesheetServiceImp;
    
    
	public TimesheetBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void addTimesheet() {
		
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


	public Timesheet getTimesheet() {
		return timesheet;
	}



	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}


	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
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

	
	
	
}
