package movierest;

import java.util.HashMap;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;

public class Service implements IService {
	static HashMap<Long, Movie> movieidmap  = new HashMap<Long, Movie>();
	static Long id = Long.valueOf(0);

	@Override
	public Response getListOfMoviesXml() {
		
		return Response.ok(new XMLResponse(movieidmap.values())).build();
	}

	@Override
	public Response getListOfMoviesJson() {
		return Response.ok(new JSONResponse(movieidmap.values())).build();
	}
	
	@Override
	public Response getMovieById(long id) {
		// TODO Auto-generated method stub
		Movie movie;
		if((movie = movieidmap.get(id)) != null)
			return Response.ok(movie).build();
		return Response.status(404).build();
	}

	@Override
	public Response postMovie(Movie movie) {
		movieidmap.put(id, movie);
		Response resp = Response.status(201).entity(new IdResponse(id)).build(); 
		id++;
		return  resp;
	}

	@Override
	public void putMovie(Movie movie, long id) {
		// TODO Auto-generated method stub
		Movie m;
		if((m = movieidmap.get(id)) != null) {
			movieidmap.replace(id, movie);
		}
		else {
			movieidmap.put(id, movie);
		}
		
	}

	@Override
	public void deleteMovie(long id) {
		// TODO Auto-generated method stub
		movieidmap.remove(id);
	}

	@Override
	public IdQueryResponse getMoviesByYear(int year, String field) {
		// TODO Auto-generated method stub
		ArrayList<Long> idlist = new ArrayList<Long>();
		ArrayList<String> fieldlist = new ArrayList<String>();		
		HashMap<String,Long> idfieldmap = new HashMap<String,Long>();
		if(field.equals("Title")) {
			System.out.println("girir");
			for(Entry<Long, Movie> entry : movieidmap.entrySet()) {
				if (entry.getValue().getYear() == year) {
					fieldlist.add(entry.getValue().getTitle());
					idfieldmap.put(entry.getValue().getTitle(),entry.getKey());
				}
			}
			java.util.Collections.sort(fieldlist, Collator.getInstance());
			for (String f : fieldlist){
				idlist.add(idfieldmap.get(f));
			}
		}
			
		else {
			System.out.println("girir");
			for(Entry<Long, Movie> entry : movieidmap.entrySet()) {
				if (entry.getValue().getYear() == year) {
					fieldlist.add(entry.getValue().getDirector());
					idfieldmap.put(entry.getValue().getDirector(),entry.getKey());
				}
			}
			java.util.Collections.sort(fieldlist, Collator.getInstance());
			for (String f : fieldlist){
				idlist.add(idfieldmap.get(f));
			}

		}
		return new IdQueryResponse(idlist);
	}
	
	
}
