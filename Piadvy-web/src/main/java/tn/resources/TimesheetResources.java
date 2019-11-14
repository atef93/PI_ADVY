package tn.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.advyteam.entities.Timesheet;

import tn.advyteam.service.GestionTimesheetRemote;

@Path("timesheet")
public class TimesheetResources {
	

	@EJB
	GestionTimesheetRemote timesheetServiceImp;
	
	
	public TimesheetResources() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Timesheet> getAllTimesheet() {
		return timesheetServiceImp.getAllTimesheetsByDeveloperJPQL(5);
		
	}


}
