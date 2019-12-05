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
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.wildfly.httpclient.common.ContentType;

import tn.advyteam.entities.Projet;
import tn.advyteam.entities.Timesheet;
import tn.advyteam.entities.TimesheetEtat;
import tn.advyteam.service.GestionTimesheetRemote;

@ManagedBean
@ApplicationScoped
@Path("api")
public class TimesheetDeveloperBean implements Serializable {

	private TimesheetEtat state;
	private String to;

	public static List<Timesheet> timesheets = new ArrayList<>();
	
	@EJB
	public static GestionTimesheetRemote timesheetServiceImp;

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
   
   
   public void startTracking(Timesheet timesheet) {
	   timesheetServiceImp.startTracking(timesheet);
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
	/////////////////////////////////////////////////////////////////////////////////////////
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTimesheet(@PathParam(value = "id") int id) {
		timesheets=timesheetServiceImp.getAllTimesheetsByDeveloperJPQL(id);
		return Response.status(Status.OK).entity(timesheets).build();
	}
	
	@GET
	@Path("/projets/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProject(@PathParam(value = "id") int id) {
		return Response.status(Status.OK).entity(timesheetServiceImp.getAllProjectsByManager(id)).build();
	}
	
	@POST
	@Path("new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProject(Projet p) throws Exception{
		
		return Response.status(Status.OK).entity(timesheetServiceImp.addProject(p)).build();	
	}
	
	@PUT
	@Path("update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProjet(Projet p, @PathParam(value = "id") int id) throws Exception{
		timesheetServiceImp.updateProject(p, id);
		return Response.status(Status.CREATED).entity(p).build();	
	}
	
	@DELETE
	@Path("delete/{id}")
	@Consumes("application/json")
	public Response deleteProjet(Projet p, @PathParam(value = "id") int id) {	
		timesheetServiceImp.deleteProjectById(id);
		return Response.status(Status.ACCEPTED).entity(p).build();
		
	}
	
}
