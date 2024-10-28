package modelo;

public class Persona {
	private long id;
	private String nombre;
	private String email;
	private long idCredencial;
	
	public Persona() {
		
	}
	public Persona(long id, String nombre, String email, long idCredencial) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.idCredencial = idCredencial;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getIdCredencial() {
		return idCredencial;
	}
	public void setIdCredencial(long idCredencial) {
		this.idCredencial = idCredencial;
	}
	@Override
	public String toString() {
		String ret = "";
		ret += "Id: " + this.id;
		ret += "\nNombre: " + this.nombre;
		ret += "\nEmail: " + this.email;
		ret += "\nCredencial: " + this.idCredencial;
		return ret;
	}
	
	
	
}
