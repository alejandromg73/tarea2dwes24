package dao;

import java.sql.Connection;
import java.util.Collection;

import modelo.Credenciales;
import modelo.Planta;

public class CredencialesDAO implements OperacionesCRUD<Credenciales> {
	Connection conex;

	@Override
	public long insertar(Credenciales elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Credenciales buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Credenciales> verTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Credenciales elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Credenciales elemento) {
		// TODO Auto-generated method stub
		return false;
	}


	
	
	
}