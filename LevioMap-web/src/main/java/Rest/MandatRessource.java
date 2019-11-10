package Rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entities.Mandat;
import Interfaces.MandatServiceRemote;

@Path("mandats")
@RequestScoped
public class MandatRessource {
	
	@EJB
	MandatServiceRemote ManServRem;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listeMandat")
	public Response getMandats(){
		return Response.ok(ManServRem.getAll()).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listeMandatNotif")
	public Response getMandatsNotif(){
		return Response.ok(ManServRem.getMandatsNotif()).build();
	}
	
	
	
	@POST
    @Path("delete")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteteMandatById(@QueryParam("mandateid") int id) 
	{
	 ManServRem.ArchiveMandat(id);
    }

	

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response SearchRessource(@QueryParam(value = "resourceId") String resid,
			                        @QueryParam(value = "dateM") String dateM) throws ParseException {

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);


		if ((resid == null) && (dateM == null)) {
		
			if (ManServRem.getAll() == null)
				return Response.status(Response.Status.NOT_FOUND).build();

			if (ManServRem.getAll().size() == 0)
				return Response.status(Response.Status.BAD_REQUEST).entity("Pas de contenu").build();

			else
				return Response.ok(ManServRem.getAll(), MediaType.APPLICATION_JSON).build();

		} 
		else if ((resid != null) && (dateM == null)) {
			int resourceId = Integer.parseInt(resid);
			
			if (ManServRem.getMandateByResource(resourceId) == null)
				return Response.status(Response.Status.NOT_FOUND).build();

			if (ManServRem.getMandateByResource(resourceId).size() == 0)
				return Response.status(Response.Status.BAD_REQUEST).entity("Pas de contenu").build();

			else
				return Response.ok(ManServRem.getMandateByResource(resourceId), MediaType.APPLICATION_JSON)
						.header("Access-Control-Allow-Origin", "*").build();

		} else if ((resid == null) && (dateM != null) ) 
		{
			Date FDate = simpleDateFormat.parse(dateM);
			
			if (ManServRem.SearchMandateByDate(FDate) == null)
				return Response.status(Response.Status.NOT_FOUND).build();

			if (ManServRem.SearchMandateByDate(FDate).size() == 0)
				return Response.status(Response.Status.BAD_REQUEST).entity("Pas de contenu").build();

			else
				return Response.ok(ManServRem.SearchMandateByDate(FDate), MediaType.APPLICATION_JSON)
						.header("Access-Control-Allow-Origin", "*").build();

		}

		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Requete eronnée").build();

	}
	
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("edit")
	public Response editMandate(Mandat m) {
		ManServRem.ModifierMandat(m);
		return Response.status(Status.OK).build();

	}
	
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("assign")
	public Response AssignResource(@QueryParam(value = "projetId") int projetId,
			                       @QueryParam(value = "resourceId") int resourceId ,
			                       @QueryParam(value="dateDebut") String dateDebut ,
			                       @QueryParam(value="dateFin") String dateFin) throws ParseException {
		ManServRem.AssignResource(projetId, resourceId, dateDebut, dateFin);
		return Response.status(Status.OK).build();

	}
	
	
	


}
