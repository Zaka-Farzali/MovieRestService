package movierest;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="movies")
public class XMLResponse {
	
	public Collection<Movie> movies;
	
	public XMLResponse() {
		movies = null;
		}
	public XMLResponse(Collection<Movie> mvs) {
		movies = mvs;
		}
}
