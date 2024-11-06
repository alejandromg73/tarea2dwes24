package control;

import java.util.Collection;

import dao.MensajeDAO;
import modelo.Mensaje;
import utils.ConexionBD;

public class ServiciosMensaje {
	private ConexionBD con;
	private MensajeDAO mensajeDAO;
	
public ServiciosMensaje() {
	con=ConexionBD.getInstance();
	mensajeDAO = (MensajeDAO) con.getMensajeDAO();
}

	public long insertar(Mensaje m) {
		return mensajeDAO.insertar(m);
	}
	

	
	
	public Collection<Mensaje> verTodos(){
		return mensajeDAO.verTodos();
	}
	public Mensaje buscarPorID(long id) {
		return mensajeDAO.buscarPorID(id);
	}

	public boolean validarMensaje(String mensaje) {
		if (mensaje ==null || mensaje.trim().isEmpty()) {
	        System.out.println("El mensaje está vacio.");
	        return false;
	    }
	    if (mensaje.length() > 500) {
	        System.out.println("El mensaje es muy largo");
	        return false;
	    }
		return false;
	}
}
