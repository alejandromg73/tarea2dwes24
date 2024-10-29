package dao;

import java.sql.Connection;
import java.util.Collection;

import modelo.Mensaje;
import modelo.Planta;

public class MensajeDAO implements OperacionesCRUD<Mensaje> {
	Connection conex;


	public MensajeDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}


	@Override
	public boolean insertarConID(Mensaje elemento) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public long insertarSinID(Mensaje elemento) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Mensaje buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<Mensaje> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean modificar(Mensaje elemento) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean eliminar(Mensaje elemento) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
