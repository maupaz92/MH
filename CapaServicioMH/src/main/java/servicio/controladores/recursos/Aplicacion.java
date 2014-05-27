package servicio.controladores.recursos;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


public class Aplicacion extends Application{
	
	private Set<Object> singletons = new HashSet<Object>();
	
	public Aplicacion()
	{
		singletons.add(new EquiposRecursos());
		
	}
	
	@Override
	public Set<Object> getSingletons()
	{
			return singletons; 
		
	}

}
