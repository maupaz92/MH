package modelos.recursos;



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
public class JugadorModelo {

	private int pasaporte;
	private String nombre;
	private Boolean estado;
	private int equipoActual;
	private String posicion;
	private Double altura;
	private Double peso;
	private String fechaNacimiento;
	
	

	public JugadorModelo(){}

	
	//----------getters & setters
	@XmlAttribute
	public int getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(int pasaporte) {
		this.pasaporte = pasaporte;
	}

	@XmlElement
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
	public int getEquipoActual() {
		return equipoActual;
	}

	public void setEquipoActual(int equipoActual) {
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
	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@XmlElement
	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	@XmlElement
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}

	
	
	

