package clientes;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import modelos.recursos.ConjuntoDeTorneosModelo;
import modelos.recursos.TorneoModelo;

/**
 * clase que se encarga de comunicarse con el servicio(web service) de MyHistory, 
 * para obtener y proporcionar datos sobre torneos. 
 * Envia las solicitudes a traves de http. 
 * @author maupaz92
 *
 */
public class ClienteTorneos {

	private final String rootResourceURI = "/torneos";
	private Client cliente;
	private final String URI = "http://localhost:8080/CapaServicioMH";
	
	
	public ClienteTorneos()
	{
		//se instancia el cliente
		cliente = ClientBuilder.newClient();
	}
	
	/**
	 * metodo que ejecuta la solicitud para registrar un nuevo torneo
	 * en el servicio.
	 * @param torneo: objeto con los datos del nuevo registro
	 * @return: true si el registro es exitoso, false en caso contrario.
	 */
	public boolean enviarRegistroNuevoTorneo(TorneoModelo torneo)
	{
		//se define la url del servicio que se requiere
		WebTarget urlObjetivo = cliente.target(URI+rootResourceURI);
		//se ejecuta el request con el metodo "post", y se almacena en un objeto "Response"
		Response respuesta = urlObjetivo.request().post(Entity.xml(torneo));
		System.out.println("respuesta del servicio "+respuesta.getStatus());
		respuesta.close();
		return true;
	}
	
	/**
	 * metodo que retorna una lista de todos los torneos que han sido 
	 * registrados en el servicio.
	 * @return: lista con los torneos registrados
	 */
	public List<TorneoModelo> enviarSolcitudTorneosRegistrados()
	{
		List<TorneoModelo> listaRecuperada = null;
		//se define la url del servicio que se requiere
		WebTarget urlObjetivo = cliente.target(URI+rootResourceURI);
		//se ejecuta el request con el metodo "get", y se almacena en un objeto "Response"
		Response respuesta = urlObjetivo.request().get();
		String respuestaString = respuesta.getEntity().toString(); 
		
		FileWriter escritor;
		try {
			escritor = new FileWriter("src/main/webapp/mauricio.txt");
			escritor.write(respuestaString);
			escritor.flush();
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//se obtiene el objeto deseado, y se indica el mapeo segun la clase
		/*
		ConjuntoDeTorneosModelo lista = respuesta.readEntity(ConjuntoDeTorneosModelo.class);
		if(respuesta.getStatus() == 200)
		{
			listaRecuperada = lista.getListaTorneos();
			for(int conteo = 0; conteo < listaRecuperada.size(); conteo++)
			{
				TorneoModelo torneo = listaRecuperada.get(conteo);
				System.out.println(torneo.getNombre());
			}
		}
		else
			System.out.println(respuesta.getStatus());
			
		 */
		respuesta.close();
		
		return listaRecuperada;
	}
	
	
	
	

	
	public static void main(String[] args)
	{
		
		ClienteTorneos cliente = new ClienteTorneos();
		cliente.enviarSolcitudTorneosRegistrados();
		
/*		try {
			FileWriter escritor = new FileWriter("src/main/webapp/mauricio.txt");
			escritor.write("mauricio");
			escritor.flush();
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
