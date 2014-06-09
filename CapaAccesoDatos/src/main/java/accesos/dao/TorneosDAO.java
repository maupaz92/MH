package accesos.dao;

import java.util.List;

import modelos.recursos.TorneoModelo;

public interface TorneosDAO {

	public List<Object> getTorneosRegistrados();	
	public void modificarTorneo(TorneoModelo torneo);
	
}
