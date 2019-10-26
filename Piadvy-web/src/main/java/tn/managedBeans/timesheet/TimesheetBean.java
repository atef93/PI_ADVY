package tn.managedBeans.timesheet;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Timesheet;

@ManagedBean
@ViewScoped
public class TimesheetBean {

	private Developpeur developpeur;
	private Timesheet timesheet;
	private boolean skip;
	
	
	public void index() throws IOException {
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("footer.xhtml");
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


	public boolean isSkip() {
		return skip;
	}


	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}


	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
	}


	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
	
	
	
}
