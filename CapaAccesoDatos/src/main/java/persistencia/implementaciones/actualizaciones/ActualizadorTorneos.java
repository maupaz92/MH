package persistencia.implementaciones.actualizaciones;


import org.hibernate.Session;
import org.hibernate.Transaction;



import persistencia.interfaces.ActualizadorDAO;
import persistencia.utilidades.hibernate.HibernateFactory;

/**
 * clase que implementa la actualizacion de recursos
 * tipo torneo en la base de datos utilizando el framework
 * Hibernate
 * @author Mauricio Paz
 *
 */
public class ActualizadorTorneos implements ActualizadorDAO{

	/**
	 * implementacion para actualizar un recurso en la BD
	 * utilizando Hibernate. Se sobreescriben las propiedades
	 * del recurso antiguo por las del nuevo objeto.
	 */
	public void actualizarRecurso(Object recurso) {
		//se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();
		//se inicia la transacciones
		Transaction transaccion = session.beginTransaction();
		//se actualiza el recruso
		session.update(recurso);		
    	transaccion.commit();		
	}

}
