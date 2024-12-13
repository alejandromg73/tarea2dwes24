package control;

import java.util.ArrayList;
import java.util.Collection;

import dao.EjemplarDAO;
import modelo.Ejemplar;
import utils.ConexionBD;

public class ServiciosEjemplar {
	private ConexionBD con;
	private EjemplarDAO ejemplarDAO;

	public ServiciosEjemplar() {
		con = ConexionBD.getInstance();
		ejemplarDAO = (EjemplarDAO) con.getEjemplarDAO();
	}

	public long insertar(Ejemplar e) {
		return ejemplarDAO.insertar(e);
	}

	public boolean cambiarNombre(long idEjemplar, String nuevoNombre) {
		return ejemplarDAO.cambiarNombre(idEjemplar, nuevoNombre);
	}

	public Collection<Ejemplar> verTodos() {
		return ejemplarDAO.verTodos();
	}

	public Ejemplar buscarPorID(long id) {
		return ejemplarDAO.buscarPorID(id);
	}

	public int contarEjemplares() {
		return ejemplarDAO.contarEjemplares();
	}

	public ArrayList<Ejemplar> ejemplaresPorTipoPlanta(String codigo) {
		return ejemplarDAO.ejemplaresPorTipoPlanta(codigo);
	}
	
	public boolean borrarEjemplar (long id) {
		return ejemplarDAO.borrarEjemplar(id);
	}

	/**
	 * Método para ver validar un ejemplar
	 * 
	 * 
	 * @param Un objeto de tipo ejmplar que se quiere validar
	 * @return True si se ha validado, false si no se ha validado
	 *
	 */
	public boolean validarEjemplar(Ejemplar e) {
		if (e.getCodigoPlanta().isEmpty())
			return false;
		if (e.getCodigoPlanta().length() < 3 || e.getCodigoPlanta().length() > 20)
			return false;
		return true;
	}

}
