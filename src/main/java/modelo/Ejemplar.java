package modelo;

public class Ejemplar {
	private long id;
	private String nombre;
	
	public Ejemplar() {
		
	}
	public Ejemplar(long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		String ret = "";
		ret += "Id de ejemplar: " + this.id;
		ret += "\nNombre de ejemplar: " + this.nombre;
		return ret;
	}
	
	
	
	
}
