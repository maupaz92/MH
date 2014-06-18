package modelos.recursos;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * clase que modela una entidad jugador, 
 * anotada para soporte de conversion a formato xml
 * @author maupaz92
 *
 */
@XmlRootElement
public class JugadorModelo{

	private Integer pasaporte;
	private String nombre;
	private Boolean estado;	
	private String posicion;
	private Integer altura;
	private Integer peso;
	private Date fechaNacimiento;
	private EquipoModelo equipoActual;
	private PaisModelo pais;

	
	
	public JugadorModelo(){
		/*
		pasaporte = -1;
		nombre = "";
		estado = true;
		posicion = "";
		altura = -1;
		peso = -1;
		fechaNacimiento = new Date(1);
		equipoActual = new EquipoModelo();
		pais = new PaisModelo();
		*/	
	}
	
	public JugadorModelo(JugadorModelo jugador){
		pasaporte = jugador.getPasaporte();
		nombre = jugador.getNombre();
		estado = jugador.getEstado();
		posicion = jugador.getPosicion();
		altura = jugador.getAltura();
		peso = jugador.getPeso();
		fechaNacimiento = jugador.getFechaNacimiento();
		equipoActual = new EquipoModelo(jugador.getEquipoActual());
		pais = new PaisModelo(jugador.getPais());
	}

	@Override
	public String toString() {
		return "Jugador: "+nombre+" pasaporte: "+pasaporte+" es activo: "+estado+" posicion: "+posicion+
				" altura: "+altura+" peso: "+peso+" fechaNacimiento: "+fechaNacimiento+" "+equipoActual.toString()+
				" pais "+pais.toString();
	}
	
	
	
	//----------getters & setters
	@XmlAttribute
	public Integer getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(int pasaporte) {
		this.pasaporte = pasaporte;
	}

	@XmlAttribute
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@XmlElement
	public EquipoModelo getEquipoActual() {
		return equipoActual;
	}

	public void setEquipoActual(EquipoModelo equipoActual) {
		this.equipoActual = equipoActual;
	}

	@XmlElement
	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	@XmlElement
	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	@XmlElement
	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	@XmlElement
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	@XmlElement
	public PaisModelo getPais() {
		return pais;
	}

	public void setPais(PaisModelo pais) {
		this.pais = pais;
	}
	
	
	public static void main(String[] args){
		JugadorModelo j = new JugadorModelo();
		j.setAltura(12);
		
	}

}

	
	
	

