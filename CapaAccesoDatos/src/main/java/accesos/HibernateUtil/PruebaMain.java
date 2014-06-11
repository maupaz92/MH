package accesos.HibernateUtil;





import modelos.recursos.TorneoModelo;
import accesos.excepciones.RecursoRepetidoException;
import accesos.recursos.AccesoDatosTorneos;

public class PruebaMain {

	public static void main(String[] args) throws RecursoRepetidoException  {	
		TorneoModelo torneoNuevo= new TorneoModelo();
		torneoNuevo.setNombre("Colombia 2008");
		torneoNuevo.setCopa(true);
		torneoNuevo.setTipoSelecciones(true);
		torneoNuevo.setSede("Colombia");
		AccesoDatosTorneos acceso = new AccesoDatosTorneos();
		acceso.crearRecurso(torneoNuevo);
		
	}
}