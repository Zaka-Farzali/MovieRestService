package movierest;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "movie")
public class JSONResponse {
		public Collection<Movie> movie;
		
		public JSONResponse() {
			movie = null;
			}
		public JSONResponse(Collection<Movie> mvs) {
			movie = mvs;
			}
	
}
