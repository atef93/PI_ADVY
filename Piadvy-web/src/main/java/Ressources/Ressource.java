package Ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
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


import tn.advyteam.entities.DemandeMission;
import tn.advyteam.entities.Mission;
import tn.advyteam.serviceImp.GestionMissionService;

@Path("Mission")
@RequestScoped
public class Ressource {
	@EJB
	GestionMissionService cm;

	public static List<Mission> S;
	
	
	public Ressource() {
		super();
	}



	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response AllMission() {
		S = cm.findAllMission();
		return Response.status(Status.OK).entity(S).build();			}

	
	
	@POST
	@Path("new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMission (Mission e) throws Exception{
		return Response.status(Status.OK).entity(cm.AddMission(e)).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMission(@PathParam("id") int id) {
	
		    cm.deletemissionfromdb(id);
			return Response.status(Response.Status.OK).entity("la suppression est effectuée").build();	
	}


}

