package dao;

import java.sql.Connection;
import java.util.Collection;

import modelo.Ejemplar;
import modelo.Persona;

public class PersonaDAO implements OperacionesCRUD<Persona> {
	Connection conex;


	public PersonaDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}
	

	@Override
	public boolean insertarConID(Persona elemento) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public long insertarSinID(Persona elemento) {
		// TODO Auto-generated method stub
		return 0;
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


	@Override
	public Persona buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<Persona> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}

