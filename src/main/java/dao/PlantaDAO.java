package dao;

import java.sql.Connection;
import java.util.Collection;

import modelo.Planta;

public class PlantaDAO implements OperacionesCRUD<Planta> {
		Connection conex;


		public PlantaDAO(Connection conex) {
			if (this.conex == null)
				this.conex = conex;
		}
		
		@Override
		public boolean insertarConID(Planta elemento) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public long insertarSinID(Planta elemento) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Planta buscarPorID(long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Collection<Planta> buscarTodos() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean modificar(Planta elemento) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean eliminar(Planta elemento) {
			// TODO Auto-generated method stub
			return false;
		}
}

