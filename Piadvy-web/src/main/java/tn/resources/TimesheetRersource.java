package tn.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.advyteam.entities.Timesheet;
import tn.advyteam.service.GestionTimesheetLocal;

/**
 * Session Bean implementation class TimesheetRersource
 */
@Stateful
@LocalBean
@Path("timesheet")
public class TimesheetRersource implements Serializable {

	/**
	 * Default constructor.
	 */
	@EJB
	public static GestionTimesheetLocal timesheetServiceImp;

	List<Timesheet> t;

	public TimesheetRersource() {
		t = new ArrayList<>();
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Timesheet> getAllTimesheet(@PathParam(value = "id") int id) {

		t=timesheetServiceImp.getAllTimesheetsByDeveloperJPQL(id);
		//return Response.status(Status.OK).entity(timesheetServiceImp.getAllTimesheetsByDeveloperJPQL(id)).build();
		return t;
	}

}
