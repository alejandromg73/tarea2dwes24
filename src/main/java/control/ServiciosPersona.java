package control;

import java.util.Collection;

import dao.PersonaDAO;
import modelo.Persona;
import utils.ConexionBD;

public class ServiciosPersona {
		private ConexionBD con;
		private PersonaDAO personaDAO;
		
	public ServiciosPersona() {
		con=ConexionBD.getInstance();
		personaDAO = (PersonaDAO) con.getPersonaDAO();
	}

		public long insertar(Persona pers) {
			return personaDAO.insertar(pers);
		}
		
		public Collection<Persona> verTodos(){
			return personaDAO.verTodos();
		}
		public Persona buscarPorID(long id) {
			return personaDAO.buscarPorID(id);
		}
		public boolean emailExistente(String email) {
			return personaDAO.emailExistente(email);
		}
		public boolean validarPersona(Persona pers) {
	        if(pers.getNombre().isEmpty()) 
	        	return false;
	        if(pers.getNombre().length()<3 || pers.getNombre().length()>20)
	        	return false;
	        if(pers.getEmail().isEmpty())
	        	return false;
	        return true;
	    }
		public long IdUsuarioAutenticado(String usuario) {
			return personaDAO.IdUsuarioAutenticado(usuario);
		}
}

