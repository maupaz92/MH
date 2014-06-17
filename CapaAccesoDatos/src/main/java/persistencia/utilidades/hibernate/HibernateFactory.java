package persistencia.utilidades.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateFactory {

	//Objeto de SessionFactory para el mapeo por XML.
    private static SessionFactory sessionFactory;
    
    
    //M�todo para la creaci�n del SessionFactory utilizando el archivo "hibernate.cfg.xml" para la configuraci�n.
    private static SessionFactory buildSessionFactory() {
        try {
        	//necesario para linkear el connector a tomcat, sino no lee el driver
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure(HibernateFactory.class.getResource("/hibernate.cfg.xml"));
            System.out.println("Configuraci�n Exitosa");
             
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("ServiceRegistry creado");
             
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
             
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Error en la creaci�n de SessionFactory" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    //M�todo p�blico para acceso a objeto SessionFactory para conexi�n con la base de datos.
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
