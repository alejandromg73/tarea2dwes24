package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import modelo.Ejemplar;
import modelo.Planta;
import utils.ConexionBD;

	public class EjemplarDAO implements OperacionesCRUD<Ejemplar> {
		Connection conex;
		private PreparedStatement ps;
		

		public EjemplarDAO(Connection conex) {
			
				this.conex = conex;
		}


		@Override
		public long insertar(Ejemplar ej) {
			try {
				ps = conex.prepareStatement("INSERT INTO ejemplares (nombre, id_planta) values (?,?,?)");
				ps.setString(1, ej.getNombre());
				ps.setString(2, ej.getCodigoPlanta());
				return ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Error al insertar en plantas " + e.getMessage());
			}
			return 0;
		}



		@Override
		public Collection<Ejemplar> verTodos() {
			ArrayList<Ejemplar> todos = new ArrayList<Ejemplar>(); 
		    String consulta = "SELECT * FROM ejemplares"; 
		    try {
		        if (this.conex == null || this.conex.isClosed()) {
		            this.conex = ConexionBD.getConexion();
		        }
		        PreparedStatement ps = conex.prepareStatement(consulta);
		        ResultSet resultado = ps.executeQuery();
		        while (resultado.next()) {
		            Ejemplar ejemplar = new Ejemplar(                
		                resultado.getInt("id"),           
		                resultado.getString("nombre"),
		                resultado.getString("id_planta"));		            
		            todos.add(ejemplar); 
		        }
		        conex.close();
		    } catch (SQLException e) {
		        System.out.println("Error al obtener todas las plantas: " + e.getMessage());
		        e.printStackTrace();
		    
		    }
		    
		    return todos;
		}
		public int contarEjemplares() {
	        String consulta = "SELECT COUNT(*) FROM ejemplares";
	        try (PreparedStatement ps = conex.prepareStatement(consulta);
	             ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1);
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al contar los ejemplares: " + e.getMessage());
	        }
	        return 0;
	    }
		public Ejemplar buscarPorID(long id) {
			Ejemplar ejemplar = null;
	        String consulta = "SELECT * FROM ejemplares WHERE id = ?";
	        try (PreparedStatement ps = conex.prepareStatement(consulta)) {
	            ps.setLong(1, id);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    ejemplar = new Ejemplar();
	                    ejemplar.setId(rs.getLong("id"));
	                    ejemplar.setNombre(rs.getString("nombre"));
	                    ejemplar.setCodigoPlanta(rs.getString("codigoPlanta"));
	                }
	            }
	        } catch (SQLException e) {
	            System.err.println("Error al obtener el " + id + ": " + e.getMessage());
	        }

	        return ejemplar;
		}
		
		public ArrayList<Ejemplar> ejemplaresPorTipoPlanta(String codigoPlanta) {
		    String consulta = "SELECT * FROM ejemplares WHERE id_planta = ?";
		    ArrayList<Ejemplar> ej = new ArrayList<>();
		    try (PreparedStatement ps = conex.prepareStatement(consulta)) {
		        ps.setString(1, codigoPlanta);
		        try (ResultSet rs = ps.executeQuery()) {
		            while (rs.next()) {
		                Ejemplar e = new Ejemplar();
		                e.setId(rs.getLong("id"));
		                e.setNombre(rs.getString("nombre"));
		                e.setCodigoPlanta(codigoPlanta);
		                ej.add(e);
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ej;
		}




		
		
		

		
}

