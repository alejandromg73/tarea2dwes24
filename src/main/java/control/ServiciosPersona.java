package control;

import java.util.Collection;

import dao.PersonaDAO;
import dao.PlantaDAO;
import modelo.Persona;
import modelo.Planta;
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
		public boolean modificar(Persona pers) {
			return personaDAO.modificar(pers);
		}

		
		public Collection<Persona> verTodos(){
			return personaDAO.verTodos();
		}
		public Persona buscarPorID(long id) {
			return personaDAO.buscarPorID(id);
		}
		public boolean validarPersona(Persona pers) {
	        boolean ret = false;
	        if(p.getCodigo().isEmpty()) 
	        	return false;
	        if(p.getCodigo().length()<3 || p.getCodigo().length()>20)
	        	return false;
	        
	        return true;
	    }

}

