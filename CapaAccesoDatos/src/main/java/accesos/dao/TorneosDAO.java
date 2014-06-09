package accesos.dao;

import java.util.List;

import modelos.recursos.TorneoModelo;

public interface TorneosDAO {

	public List<Object> getTorneosRegistrados();
	public Boolean existeTorneoRegistrado(String identificador);
	public void modificarTorneo(TorneoModelo torneo);
	
}
