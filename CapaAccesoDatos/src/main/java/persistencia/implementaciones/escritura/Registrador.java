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
	
	/*
	public static void main(String[] args){
		ArrayList<String> lista = new ArrayList<String>(Arrays.asList(
				"Afganistán", "Albania", "Alemania", "Andorra", "Angola", "Antigua y Barbuda" ,"Arabia Saudita", "Argelia", "Argentina", "Armenia", "Australia", "Austria", "Azerbaiyán", "Bahamas", "Bangladés", "Barbados", "Baréin", "Bélgica", "Belice", "Benín", "Bielorrusia", "Birmania", "Bolivia", "Bosnia y Herzegovina", "Botsuana", "Brasil", "Brunéi", "Bulgaria", "Burkina Faso", "Burundi", "Bután", "Cabo Verde", "Camboya", "Camerún", "Canadá", "Catar", "Chad", "Chile", "China", "Chipre", "Ciudad del Vaticano", "Colombia", "Comoras", "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador", "Emiratos Árabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "España", "Estados Unidos", "Estonia", "Etiopía", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gabón", "Gambia", "Georgia", "Ghana", "Granada", "Grecia", "Guatemala", "Guyana", "Guinea", "Guinea ecuatorial", "Guinea-Bisáu", "Haití", "Honduras", "Hungría", "India", "Indonesia", "Irak", "Irán", "Irlanda", "Islandia", "Islas Marshall", "Islas Salomón", "Israel", "Italia", "Jamaica", "Japón", "Jordania", "Kazajistán", "Kenia", "Kirguistán", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "Líbano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Madagascar", "Malasia", "Malaui", "Maldivas", "Malí", "Malta", "Marruecos", "Mauricio", "Mauritania", "México", "Micronesia", "Moldavia", "Mónaco", "Mongolia", "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal", "Nicaragua", "Níger", "Nigeria", "Noruega", "Nueva Zelanda", "Omán", "Países Bajos", "Pakistán", "Palaos", "Panamá", "Papúa Nueva Guinea", "Paraguay", "Perú", "Polonia", "Portugal", "Reino Unido", "República Centroafricana", "República Checa", "República de Macedonia", "República del Congo", "República Democrática del Congo", "República Dominicana", "República Sudafricana", "Ruanda", "Rumanía", "Rusia", "Samoa", "San Cristóbal y Nieves", "San Marino", "San Vicente y las Granadinas", "Santa Lucía", "Santo Tomé y Príncipe", "Senegal", "Serbia", "Seychelles", "Sierra Leona", "Singapur", "Siria", "Somalia", "Sri Lanka", "Suazilandia", "Sudán", "Sudán del Sur", "Suecia", "Suiza", "Surinam", "Tailandia", "Tanzania", "Tayikistán", "Timor Oriental", "Togo", "Tonga", "Trinidad y Tobago", "Túnez", "Turkmenistán", "Turquía", "Tuvalu", "Ucrania", "Uganda", "Uruguay", "Uzbekistán","Vanuatu", "Venezuela", "Vietnam", "Yemen", "Yibuti", "Zambia", "Zimbabue" ));
		Registrador reg = new Registrador();
		for (String string : lista) {
			PaisModelo pais = new PaisModelo();
			pais.setNombre(string);
			reg.guardarNuevoRecurso(pais);
		}
		
	}
	*/

}
