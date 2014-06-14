package persistencia.implementaciones.escritura;

import org.hibernate.Session;

import persistencia.interfaces.RegistradorDAO;
import persistencia.utilidades.hibernate.HibernateFactory;

/**
 * clase que implementa la interface IGuardarDAO para proveer
 * una implementacion para guardar recursos en la base de datos
 * utilizando el framework Hibernate y sus utilidades.
 * @author Mauricio Paz
 *
 */
public class Registrador implements RegistradorDAO{

	/**
	 * metodo que guarda en la base de datos del sistema
	 * el recurso
	 */
	public void guardarNuevoRecurso(Object nuevoRecurso) {
		//Get Session
		System.out.println("CreandoRecurso");
        Session session1 = HibernateFactory.getSessionFactory().openSession();
        //start transaction
        session1.beginTransaction();
        //Save the Model object
        System.out.println("Guardando en DB");
        session1.save(nuevoRecurso);
        //Commit transaction
        session1.getTransaction().commit();
	}

}
