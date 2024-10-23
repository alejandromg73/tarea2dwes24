package modelo;

import java.time.LocalDateTime;

public class Mensaje {
	private long id;
	private LocalDateTime fechaHora;
	private String mensaje;
	
	public Mensaje() {
		
	}

	public Mensaje(long id, LocalDateTime fechaHora, String mensaje) {
		this.id = id;
		this.fechaHora = fechaHora;
		this.mensaje = mensaje;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public String toString() {
		String ret = "";
		ret += "Id de mensaje: " + this.id;
		ret += "\nFecha y hora: " + this.fechaHora;
		ret += "\nMensaje: " + this.mensaje;
		return ret;
	}
	
	
}
