package dao;

import java.util.ArrayList;
import java.util.List;

import modelo.Planta;

//Interfaz PlantaDAO donde se definen los métodos que se van a emplear para las operaciones CRUD
//El desarrollo de estos métodos se harán en las clases DAOImpl
public interface PlantaDAO {
	//Insertar una planta
		int insertar(Planta p);
	//Modificar una planta
		int modificar(Planta p);
	//Eliminar una planta
		int eliminar(Planta p);
		
		Planta findById(int id);
		ArrayList<Planta> findByNombre(String nombre);
		List<Planta> findAll();
	}

