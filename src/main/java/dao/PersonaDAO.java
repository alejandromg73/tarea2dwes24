package dao;

import java.util.ArrayList;
import java.util.List;

import modelo.Ejemplar;
import modelo.Persona;

//Interfaz PersonaDAO donde se definen los métodos que se van a emplear para las operaciones CRUD
//El desarrollo de estos métodos se harán en las clases DAOImpl
public interface PersonaDAO {
	//Insertar una persona
		int insertar(Persona p);
	//Modificar una persona
		int modificar(Persona p);
	//Eliminar una persona
		int eliminar(Persona p);
		Persona findById(int id);
		
		ArrayList<Persona> findByNombre(String nombre);
		List<Persona> findAll();
	}