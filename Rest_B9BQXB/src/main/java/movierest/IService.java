package movierest;




import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/MovieDatabase")
public interface IService {
	
//	returns the list of all Movie objects
	@GET
	@Path("/movies")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({"application/xml"})
	public Response getListOfMoviesXml();
	
	@GET
	@Path("/movies")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({"application/json"})
	public Response getListOfMoviesJson();

//	returns the Movie object with the given identifier

	@GET
	@Path("/movies/{id}")
	@Produces({"application/xml", "application/json"})
	public Response getMovieById(@PathParam("id") long id);
	
//	inserts the received Movie object into the database	
	
	@POST
	@Path("/movies")
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/xml", "application/json"})
	public Response postMovie(Movie movie);
	
//	inserts or updates the received Movie object
	
	@PUT
	@Path("/movies/{id}")
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	public void putMovie(Movie movie, @PathParam("id") long id);
	
// deletes the Movie with the given identifier from the database
	
	@DELETE
	@Path("/movies/{id}")
	@Produces({"application/xml", "application/json"})
	public void deleteMovie(@PathParam("id") long id);
	
// returns the list of identifiers of all the Movie objects 
//	which have the year number {year}
//	the list should be sorted according to {field}	
	
	@GET
	@Path("/movies/find")
	@Produces({"application/xml", "application/json"})
	public IdQueryResponse getMoviesByYear(@QueryParam("year") int year, @QueryParam("orderby") String field);
	
}


