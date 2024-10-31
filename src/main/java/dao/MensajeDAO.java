package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import modelo.Ejemplar;
import modelo.Mensaje;
import modelo.Persona;
import modelo.Planta;
import utils.ConexionBD;

public class MensajeDAO implements OperacionesCRUD<Mensaje> {
	Connection conex;
	private PreparedStatement ps;
	private ResultSet rs;


	public MensajeDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}


	@Override
	public long insertar(Mensaje m) {
		try {
			ps = conex.prepareStatement("INSERT INTO mensajes (id, fechahora, mensaje, idejemplar, idpersona) values (?,?,?,?,?)");
			ps.setLong(1, m.getId());
			ps.setLocalDateTime(2, m.getFechaHora());
			ps.setString(3, m.getMensaje());
			ps.setLong(4, m.getIdEjemplar());
			ps.setLong(5, m.getIdPersona());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar en plantas " + e.getMessage());
		}
		return 0;
	}


	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Mensaje> buscarPorID(long idEjemplar) {
		ArrayList mensajes = new ArrayList<Mensaje>();
		String consulta = "SELECT mensajes.id, mensajes.fechahora, mensajes.mensaje, " +
                "personas.id, personas.nombre, personas.email " +
                "FROM mensajes " +
                "INNER JOIN personas ON mensajes.idpersona = personas.id " +
                "WHERE mensajes.idejemplar = ? " +
                "ORDER BY mensajes.fechahora;";

		try(PreparedStatement ps = conex.prepareStatement(consulta)) {
		ps.setLong(1, idEjemplar); 
		rs = ps.executeQuery();
		while(rs.next()) {
		Persona persona = new Persona(
		rs.getLong("id"),
		rs.getString("nombre"),
		rs.getString("email"),
		rs.getLong("id_credenciales")
		);
		Mensaje mensaje = new Mensaje(
		rs.getLong("id"), 
		rs.getTimestamp("fechahora").toLocalDateTime(), 
		rs.getString("mensaje"), 
		idEjemplar,
		rs.getLong("idpersona") // Persona que anotó el mensaje
		);
		mensajes.add(mensaje);
		}

		} catch (SQLException e) {
		System.out.println("Error al obtener los mensajesdel ejemplar: " + e.getMessage());
		e.printStackTrace();
		return mensajes;
		}
		}


	@Override
	public Collection<Mensaje> verTodos() {
		ArrayList<Mensaje> todos = new ArrayList<Mensaje>(); 
	    String consulta = "SELECT * FROM mensajes"; 
	    try {
	        if (this.conex == null || this.conex.isClosed()) {
	            this.conex = ConexionBD.getConexion();
	        }
	        PreparedStatement ps = conex.prepareStatement(consulta);
	        ResultSet resultado = ps.executeQuery();
	        while (resultado.next()) {
	            Mensaje mensaje = new Mensaje(                
	                resultado.getInt("id"),                     
	                resultado.getLocalDateTime("fechahora"),      
	                resultado.getString("mensaje"),             
	                resultado.getInt("idejemplar"),            
	                resultado.getInt("idpersona")               
	            );
	            todos.add(mensaje); 
	        }
	        conex.close();
	    } catch (SQLException e) {
	        System.out.println("Error al obtener todas las plantas: " + e.getMessage());
	        e.printStackTrace();
	    
	    }
	    
	    return todos;

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
