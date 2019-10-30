package tn.managedBeans.timesheet;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import tn.advyteam.entities.Timesheet;
import tn.advyteam.entities.TimesheetEtat;
import tn.advyteam.service.GestionTimesheetRemote;

@ManagedBean
@ApplicationScoped
public class TimesheetDeveloperBean implements Serializable {

	private TimesheetEtat state;
	private String to;

	@EJB
	GestionTimesheetRemote timesheetServiceImp;

	List<Timesheet> alltimesheet;
	List<Timesheet> todo;
	List<Timesheet> doing;
	List<Timesheet> done;

	public TimesheetDeveloperBean() {
		alltimesheet = new ArrayList<>();
		todo = new ArrayList<Timesheet>();
		doing = new ArrayList<Timesheet>();
		done = new ArrayList<Timesheet>();
	}

	@PostConstruct
	public void init() {

		alltimesheet = timesheetServiceImp.getAllTimesheetsByDeveloperJPQL(3);

		for (Timesheet ts : alltimesheet) {
			if (ts.getTimesheetEtat().equals(TimesheetEtat.TODO)) {
				todo.add(ts);
			} else if (ts.getTimesheetEtat().equals(TimesheetEtat.DOING)) {
				doing.add(ts);
			} else {
				done.add(ts);
			}
		}
	}

	public List<Timesheet> getAlltimesheet() {
		return alltimesheet;
	}

	public List<Timesheet> getTodo() {
		return todo;
	}

	public List<Timesheet> getDoing() {
		return doing;
	}

	public List<Timesheet> getDone() {
		return done;
	}

	public void setAlltimesheet(List<Timesheet> alltimesheet) {
		this.alltimesheet = alltimesheet;
	}

	public void setTodo(List<Timesheet> todo) {
		this.todo = todo;
	}

	public void setDoing(List<Timesheet> doing) {
		this.doing = doing;
	}

	public void setDone(List<Timesheet> done) {
		this.done = done;
	}

	public TimesheetEtat getState() {
		return state;
	}

	public void setState(TimesheetEtat state) {
		this.state = state;
	}

	public void changeState() {

	}

	public void addMessage(Timesheet timesheet) {
		String summary = "Checked" + "Unchecked";
		System.out.println(timesheet);
		System.out.println(summary);
	}

    
    public void todo(Timesheet timesheet) throws IOException {
    	
    	timesheet.setTimesheetEtat(TimesheetEtat.TODO);
    	timesheetServiceImp.updateTimesheetState(timesheet);
    	refresch();
		FacesContext.getCurrentInstance().getExternalContext().redirect("listeTimesheet.xhtml");

    	//return "listeTimesheet.xhtml";

    }
    
    public void doing(Timesheet timesheet) throws IOException {
    	timesheet.setTimesheetEtat(TimesheetEtat.DOING);
    	timesheetServiceImp.updateTimesheetState(timesheet);
		FacesContext.getCurrentInstance().getExternalContext().redirect("listeTimesheet.xhtml");
    	refresch();
    	//return "listeTimesheet.xhtml";	
    }
    
   public void done(Timesheet timesheet) throws IOException {
   	timesheet.setTimesheetEtat(TimesheetEtat.DONE);
   	timesheetServiceImp.updateTimesheetState(timesheet);
	FacesContext.getCurrentInstance().getExternalContext().redirect("listeTimesheet.xhtml");
	refresch();

   	
	//return "listeTimesheet.xhtml";

    }
   
   
   public void startTracking() {
	   timesheetServiceImp.startTracking();
   }
   
   public void endTraking(Timesheet timesheet) {
	   //timesheetServiceImp.updateHeureMinuteTimesheet();
	   timesheetServiceImp.stopTracking(timesheet);
   }
   

	public String getTo() {
		System.out.println("hello");
		return to;
	}

	public void setTo(String to) {
		System.out.println("hello");

		this.to = to;
	}
	
    //=====================================================================//
	

	public void refresch() {
		alltimesheet = timesheetServiceImp.getAllTimesheetsByDeveloperJPQL(3);
		todo = new ArrayList<>();
		doing = new ArrayList<>();
		done = new ArrayList<>();
		for(Timesheet ts: alltimesheet) {
			if(ts.getTimesheetEtat().equals(TimesheetEtat.TODO)) {
				todo.add(ts);
			}
			else if(ts.getTimesheetEtat().equals(TimesheetEtat.DOING)) {
				doing.add(ts);
			}
			else {
				done.add(ts);
			}
		}
	}

}
