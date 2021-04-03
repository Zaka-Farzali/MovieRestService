package movierest;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "movies")
public class IdQueryResponse {
	@XmlElement(name="id")
	ArrayList<Long> idlist = new ArrayList<Long>();
	
	public IdQueryResponse() {
		idlist = new ArrayList<Long>();
		}
	public IdQueryResponse(ArrayList<Long> idlist) { 
		this.idlist = idlist;
		};
	
	public ArrayList<Long> getId(){
		return idlist;
		}
}
