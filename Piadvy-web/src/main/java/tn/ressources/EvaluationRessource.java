package tn.ressources;

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


import tn.advyteam.entities.Evaluation;
import tn.advyteam.entities.EvaluationAnnuel;
import tn.advyteam.serviceImp.EvaluationServiceImp;



@Path("evaluation")
@RequestScoped
public class EvaluationRessource {
	@EJB
	 EvaluationServiceImp service;
	private List<Evaluation> E;

	
	public EvaluationRessource() {
		super();
	}

	
	
	@GET
	@Path("eva")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEvaluationAnnuel() {
		E = service.getAllEvaluationAnnuel();
return Response.status(Status.OK).entity(E).build();		
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEvaluation(@PathParam("id") int id) {
	
		    service.deleteEvaluationById(id);
			return Response.status(Response.Status.OK).entity("la suppression est effectuée").build();	
	}
	
	@PUT
	@Path("update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEvaluation(@PathParam(value="id") int id, EvaluationAnnuel e) throws Exception {		
		
		 e = service.FindByIdd(id);
		 System.out.println("avant");
		 return Response.status(Status.OK).entity(service.updateEvaluation(e)).build();
	}
	
	@POST
	@Path("new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEvaluation (EvaluationAnnuel e) throws Exception{
		return Response.status(Status.OK).entity(service.addEvaluation(e)).build();
	}
	


}
