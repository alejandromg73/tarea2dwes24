package dao;

import java.sql.Connection;
import java.util.Collection;

import modelo.Credenciales;
import modelo.Planta;

public class CredencialesDAO implements OperacionesCRUD<Credenciales> {
	Connection conex;


	public CredencialesDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}


	@Override
	public boolean insertarConID(Credenciales elemento) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public long insertarSinID(Credenciales elemento) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Credenciales buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<Credenciales> buscarTodos() {
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