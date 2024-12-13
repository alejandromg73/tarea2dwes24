package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import modelo.Persona;
import utils.ConexionBD;

public class PersonaDAO implements OperacionesCRUD<Persona> {
	Connection conex;
	private PreparedStatement ps;
	private ResultSet rs;

	public PersonaDAO(Connection conex) {

		this.conex = conex;
	}

	@Override
	public long insertar(Persona pers) {
		long id = 0;
		String consulta = "INSERT INTO personas (nombre, email) values (?, ?)";
		try (PreparedStatement ps = conex.prepareStatement(consulta, PreparedStatement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, pers.getNombre());
			ps.setString(2, pers.getEmail());
			int filas = ps.executeUpdate();
			if (filas > 0) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					if (rs.next()) {
						id = rs.getLong(1);
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al insertar la persona: " + e.getMessage());
		}

		return id;
	}

	/**
	 * Comprueba si un email existe o no en la base de datos
	 * 
	 * @param El email que se va a validar
	 * @return true si ya existe, false si no existe
	 *
	 */
	public boolean emailExistente(String email) {

		String emailsExistentes = "SELECT email FROM personas";
		ArrayList<String> listaEmail = new ArrayList<String>();
		try {
			ps = conex.prepareStatement(emailsExistentes);
			rs = ps.executeQuery();
			while (rs.next()) {
				listaEmail.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (listaEmail.contains(email)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Collection<Persona> verTodos() {
		ArrayList<Persona> todas = new ArrayList<Persona>();
		String consulta = "SELECT * FROM personas";
		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexionBD.getConexion();
			}
			PreparedStatement ps = conex.prepareStatement(consulta);
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				Persona persona = new Persona(resultado.getLong("id"), resultado.getString("nombre"),
						resultado.getString("email"));
				todas.add(persona);
			}

		} catch (SQLException e) {
			System.out.println("Error al obtener todas las personas: " + e.getMessage());
			e.printStackTrace();

		}

		return todas;
	}

	/**
	 * Obtiene el id de la persona que está autenticada en el sistema en este
	 * momento
	 * 
	 * @param El usuario que está autenticado en este momento
	 * @return el id de la persona que se le pasa como parámetro
	 *
	 */

	public long IdUsuarioAutenticado(String usuario) {
		long idPersona = -1;
		String consulta = "SELECT personas.id FROM personas INNER JOIN credenciales ON personas.id = idPersona WHERE usuario = ?";
		try (PreparedStatement ps = conex.prepareStatement(consulta)) {
			ps.setString(1, usuario);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					idPersona = rs.getLong("id");
				}
			}
		} catch (SQLException e) {
			System.err.println("Error al obtener el id de: " + usuario + ": " + e.getMessage());
		}
		return idPersona;
	}
	
	public boolean borrarPersona(Long idPersona) {
	    String consulta = "DELETE FROM personas WHERE id = ?";
	    try (Connection connection = ConexionBD.getConexion();
	         PreparedStatement ps = connection.prepareStatement(consulta)) {
	        ps.setLong(1, idPersona);
	        int filas = ps.executeUpdate();
	        return filas > 0;
	    } catch (SQLException e) {
	        System.out.println("Error borrando la persona: " + e.getMessage());
	        return false;
	    }
	}


}
