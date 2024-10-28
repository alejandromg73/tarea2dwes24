package dao;

import java.util.ArrayList;
import java.util.List;

import modelo.Credenciales;
import modelo.Ejemplar;
import modelo.Mensaje;

//Interfaz MensajeDAO donde se definen los métodos que se van a emplear para las operaciones CRUD
//El desarrollo de estos métodos se harán en las clases DAOImpl
public interface MensajeDAO {
	//Insertar un mensaje
		int insertar(Mensaje c);
	//Modificar un mensaje
		int modificar(Mensaje c);
	//Eliminar un mensaje
		int eliminar(Mensaje c);
		
		Mensaje findById(int id);
		ArrayList<Mensaje> findByNombre(String nombre);
		List<Mensaje> findAll();
	}