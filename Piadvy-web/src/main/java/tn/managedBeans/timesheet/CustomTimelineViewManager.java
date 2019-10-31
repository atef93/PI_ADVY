package tn.managedBeans.timesheet;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;

import tn.advyteam.entities.Timesheet;
import tn.advyteam.service.GestionTimesheetRemote;

@ManagedBean(name = "customTimelineView")
@ViewScoped
public class CustomTimelineViewManager implements Serializable {  
   
    private TimelineModel model;  
    private Date start;  
    private Date end;
 
    private Date dd;
    private Date df;
    
    String etat;
   
    @EJB
	GestionTimesheetRemote timesheetServiceImp;
    
    
    private List<Timesheet> timesheets = new ArrayList<Timesheet>();
    
    @PostConstruct 
    public void init() {  
    	timesheets = timesheetServiceImp.getAllTimesheetsByProject(15);
    	
        // set initial start / end dates for the axis of the timeline  
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));  
        Date now = new Date();  
   
        cal.setTimeInMillis(now.getTime() - 4 * 60 * 60 * 1000);  
        start = cal.getTime();  
   
        cal.setTimeInMillis(now.getTime() + 8 * 60 * 60 * 1000);  
        end = cal.getTime();  
   
        // groups  
        //String[] NAMES = new String[] {"User 1", "User 2", "User 3", "User 4", "User 5", "User 6"}; 
        
        
        //Timesheets pour un employee
        
        
   
        // create timeline model  
        model = new TimelineModel();  
   
       // for (String name : NAMES) {  
        for(Timesheet t: timesheets) {
            now = new Date();  
            Date end = new Date(now.getTime() - 12 * 60 * 60 * 1000);  
   
            for (int i = 0; i < timesheets.size(); i++) {  
                Date start = t.getDateDebut();  
                end = t.getDeadline();
   
                //long r = Math.round(Math.random() * 2);
                //String availability = (r == 0 ? "Unavailable" : (r == 1 ? "Available" : "Maybe"));  
                String availability = null;
                
                if(t.getHeureEstime()-t.getHeurePasse()<0) {
                	etat = "En retard";
                	availability = "Retard";
                }
                else if(t.getHeureEstime()-t.getHeurePasse()>0) {
                	etat = "En avance";
                	availability = "Encours";
                }
                else if(t.getHeureEstime()-t.getHeurePasse() == 0) {
                	etat = "Marge d'estimation exact";
                	availability = "Termine";
                }
                
                // (r == 0 ? "Unavailable" : (r == 1 ? "Available" : "Maybe"));  
                
                // create an event with content, start / end dates, editable flag, group name and custom style class  
                TimelineEvent event = new TimelineEvent(etat, t.getDateDebut(), t.getDeadline(), true, t.getTitre(), availability.toLowerCase());  
                model.add(event);  
            }  
        }  
    }  
   
    public TimelineModel getModel() {  
        return model;  
    }  
   
    public Date getStart() {  
        return start;  
    }  
   
    public Date getEnd() {  
        return end;  
    }

	public Date getDd() {
		return dd;
	}

	public Date getDf() {
		return df;
	}

	public void setDd(Date dd) {
		this.dd = dd;
	}

	public void setDf(Date df) {
		this.df = df;
	}  
    
    
}