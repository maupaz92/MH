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
				"Afganist�n", "Albania", "Alemania", "Andorra", "Angola", "Antigua y Barbuda" ,"Arabia Saudita", "Argelia", "Argentina", "Armenia", "Australia", "Austria", "Azerbaiy�n", "Bahamas", "Banglad�s", "Barbados", "Bar�in", "B�lgica", "Belice", "Ben�n", "Bielorrusia", "Birmania", "Bolivia", "Bosnia y Herzegovina", "Botsuana", "Brasil", "Brun�i", "Bulgaria", "Burkina Faso", "Burundi", "But�n", "Cabo Verde", "Camboya", "Camer�n", "Canad�", "Catar", "Chad", "Chile", "China", "Chipre", "Ciudad del Vaticano", "Colombia", "Comoras", "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador", "Emiratos �rabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "Espa�a", "Estados Unidos", "Estonia", "Etiop�a", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gab�n", "Gambia", "Georgia", "Ghana", "Granada", "Grecia", "Guatemala", "Guyana", "Guinea", "Guinea ecuatorial", "Guinea-Bis�u", "Hait�", "Honduras", "Hungr�a", "India", "Indonesia", "Irak", "Ir�n", "Irlanda", "Islandia", "Islas Marshall", "Islas Salom�n", "Israel", "Italia", "Jamaica", "Jap�n", "Jordania", "Kazajist�n", "Kenia", "Kirguist�n", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "L�bano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Madagascar", "Malasia", "Malaui", "Maldivas", "Mal�", "Malta", "Marruecos", "Mauricio", "Mauritania", "M�xico", "Micronesia", "Moldavia", "M�naco", "Mongolia", "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal", "Nicaragua", "N�ger", "Nigeria", "Noruega", "Nueva Zelanda", "Om�n", "Pa�ses Bajos", "Pakist�n", "Palaos", "Panam�", "Pap�a Nueva Guinea", "Paraguay", "Per�", "Polonia", "Portugal", "Reino Unido", "Rep�blica Centroafricana", "Rep�blica Checa", "Rep�blica de Macedonia", "Rep�blica del Congo", "Rep�blica Democr�tica del Congo", "Rep�blica Dominicana", "Rep�blica Sudafricana", "Ruanda", "Ruman�a", "Rusia", "Samoa", "San Crist�bal y Nieves", "San Marino", "San Vicente y las Granadinas", "Santa Luc�a", "Santo Tom� y Pr�ncipe", "Senegal", "Serbia", "Seychelles", "Sierra Leona", "Singapur", "Siria", "Somalia", "Sri Lanka", "Suazilandia", "Sud�n", "Sud�n del Sur", "Suecia", "Suiza", "Surinam", "Tailandia", "Tanzania", "Tayikist�n", "Timor Oriental", "Togo", "Tonga", "Trinidad y Tobago", "T�nez", "Turkmenist�n", "Turqu�a", "Tuvalu", "Ucrania", "Uganda", "Uruguay", "Uzbekist�n","Vanuatu", "Venezuela", "Vietnam", "Yemen", "Yibuti", "Zambia", "Zimbabue" ));
		Registrador reg = new Registrador();
		for (String string : lista) {
			PaisModelo pais = new PaisModelo();
			pais.setNombre(string);
			reg.guardarNuevoRecurso(pais);
		}
		
	}
	*/

}
