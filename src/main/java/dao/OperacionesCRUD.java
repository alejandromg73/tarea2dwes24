package dao;

import java.util.*;

public interface OperacionesCRUD<T> {
	//Implemento esta interfaz OperacionesCRUD ya que todas las entidades van a insertar y ver elementos de la base de datos
	
	
	/**
	 * Operación CRUD de inserción de un elemento en la base de datos
	 * 
	 * @param El elemento que se va a insertar
	 *
	 */
	public long insertar(T elemento);
	
	/**
	 * Operación CRUD de ver todos los elementos(READ)
	 * 
	 * @return Una colección de todos los elementos de esa entidad en la base de datos
	 *
	 */
	public Collection<T> verTodos();

}
