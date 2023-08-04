package p2;

import java.util.HashMap;
import java.util.Map;

//import javax.ws.rs.ApplicationPath;
//import javax.ws.rs.core.Application;

//@ApplicationPath("/apimadang")
public class MadangApplication /* extends Application */{
	public Map<String, Object> getProperties(){
		Map<String, Object> rtn = new HashMap<>();
		
		rtn.put("jersey.config.server.provider.packages", "p");
		
		return rtn;
	}
}
