package dao;

import java.util.*;

public interface OperacionesCRUD<T> {
	
	public boolean insertarConID(T elemento);
	
	public long insertarSinID(T elemento);
	
	public T buscarPorID(long id);
	
	public Collection<T> buscarTodos();
	
	public boolean modificar(T elemento);
	
	public boolean eliminar(T elemento);

}
