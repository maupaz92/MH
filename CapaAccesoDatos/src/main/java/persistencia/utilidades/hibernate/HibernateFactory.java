package persistencia.utilidades.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateFactory {

	//Objeto de SessionFactory para el mapeo por XML.
    private static SessionFactory sessionFactory;
    
    
    //Método para la creación del SessionFactory utilizando el archivo "hibernate.cfg.xml" para la configuración.
    private static SessionFactory buildSessionFactory() {
        try {
        	//necesario para linkear el connector a tomcat, sino no lee el driver
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure(HibernateFactory.class.getResource("/hibernate.cfg.xml"));
            System.out.println("Configuración Exitosa");
             
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("ServiceRegistry creado");
             
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
             
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Error en la creación de SessionFactory" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    //Método público para acceso a objeto SessionFactory para conexión con la base de datos.
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
