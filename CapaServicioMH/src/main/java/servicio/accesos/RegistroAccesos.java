package servicio.accesos;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * clase encargada de registrar las clases del servicio que estaran 
 * disponibles para recibir "request" http desde la web.
 * @author maupaz92
 *
 */
public class RegistroAccesos extends Application{
	
	//contiene las clase estilo singleton que recibiran request
	private Set<Object> singletons = new HashSet<Object>();
	
	public RegistroAccesos()
	{
		singletons.add(new AccesoTorneos());
	
	}
	
	@Override
	public Set<Object> getSingletons()
	{
			return singletons; 
		
	}

}