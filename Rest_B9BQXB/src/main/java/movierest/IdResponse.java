package movierest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")
public class IdResponse {
		long id;
		
		public IdResponse(long id) { this.id = id; }
		public IdResponse() {id = 0;}
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
}
