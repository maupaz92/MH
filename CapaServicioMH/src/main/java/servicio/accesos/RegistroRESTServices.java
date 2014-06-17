package servicio.accesos;

import java.util.HashSet;
import java.util.Set;
import servicio.accesos.EquiposRESTService;
import servicio.accesos.TorneosRESTService;
import javax.ws.rs.core.Application;

public class RegistroRESTServices  extends Application {
	
	//contiene las clase estilo singleton que recibiran request
	private Set<Object> singletons = new HashSet<Object>();
	
	public RegistroRESTServices(){
		singletons.add(new TorneosRESTService());
		singletons.add(new EquiposRESTService());    
	}
	
	@Override
	public Set<Object> getSingletons()
	{
			return singletons; 
		
	}

}
