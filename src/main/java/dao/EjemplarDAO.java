package dao;

import java.sql.Connection;
import java.util.Collection;

import modelo.Ejemplar;
import modelo.Planta;

	public class EjemplarDAO implements OperacionesCRUD<Ejemplar> {
		Connection conex;


		public EjemplarDAO(Connection conex) {
			if (this.conex == null)
				this.conex = conex;
		}
		
		

		@Override
		public boolean insertarConID(Ejemplar elemento) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public long insertarSinID(Ejemplar elemento) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean modificar(Ejemplar elemento) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean eliminar(Ejemplar elemento) {
			// TODO Auto-generated method stub
			return false;
		}



		@Override
		public Ejemplar buscarPorID(long id) {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public Collection<Ejemplar> buscarTodos() {
			// TODO Auto-generated method stub
			return null;
		}
}

