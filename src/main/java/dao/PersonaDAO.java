package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import modelo.Ejemplar;
import modelo.Persona;

public class PersonaDAO implements OperacionesCRUD<Persona> {
	Connection conex;
	private PreparedStatement ps;
	private ResultSet rs;


	public PersonaDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}


	@Override
	public long insertar(Persona p) {
		try {
			ps = conex.prepareStatement("INSERT INTO personas (id, nombre, email, id_credenciales) values (?,?,?)");
			ps.setLong(1, p.getId());
			ps.setString(2, p.getNombre());
			ps.setString(3, p.getEmail());
			ps.setLong(4, p.getIdCredencial());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar en plantas " + e.getMessage());
		}
		
		return 0;
	}


	@Override
	public Persona buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<Persona> verTodos() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean modificar(Persona elemento) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean eliminar(Persona elemento) {
		// TODO Auto-generated method stub
		return false;
	}
	

	
}

