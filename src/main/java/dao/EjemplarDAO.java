package dao;

import java.util.ArrayList;
import java.util.List;

import modelo.Ejemplar;
import modelo.Planta;

//Interfaz EjemplarDAO donde se definen los métodos que se van a emplear para las operaciones CRUD
//El desarrollo de estos métodos se harán en las clases DAOImpl
public interface EjemplarDAO {
	//Insertar un ejemplar
		int insertar(Ejemplar e);
	//Modificar un ejemplar
		int modificar(Ejemplar e);
	//Eliminar un ejemplar
		int eliminar(Ejemplar e);
		
		Ejemplar findById(int id);
		ArrayList<Ejemplar> findByNombre(String nombre);
		List<Ejemplar> findAll();
	}
