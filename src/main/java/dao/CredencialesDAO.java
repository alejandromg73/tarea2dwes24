package dao;

import java.util.ArrayList;
import java.util.List;

import modelo.Credenciales;
import modelo.Ejemplar;
import modelo.Persona;

//Interfaz CredencialesDAO donde se definen los métodos que se van a emplear para las operaciones CRUD
//El desarrollo de estos métodos se harán en las clases DAOImpl
public interface CredencialesDAO {
	//Insertar una credencial
		int insertar(Credenciales c);
	//Modificar una credencial
		int modificar(Credenciales c);
	//Eliminar una credencial
		int eliminar(Credenciales c);
		
		Credenciales findById(int id);
		ArrayList<Credenciales> findByNombre(String nombre);
		List<Credenciales> findAll();
	}