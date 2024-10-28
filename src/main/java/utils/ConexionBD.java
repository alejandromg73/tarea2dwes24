package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

import dao.CredencialesDAO;
import dao.EjemplarDAO;
import dao.MensajeDAO;
import dao.PersonaDAO;
import dao.PlantaDAO;
import dao.SeguimientoDAO;

public class ConexionBD {
	private Connection con;
	
	private static ConexionBD f;
	
	private ConexionBD() {
		Properties prop = new Properties();
		MysqlDataSource m = new MysqlDataSource();
		FileInputStream fis;
	
	
	
	try {
		fis = new FileInputStream("src/main/resources/db.properties");
		prop.load(fis);
		m.setUrl(prop.getProperty("url"));
		m.setPassword(prop.getProperty("password"));
		m.setUser(prop.getProperty("usuario"));
		con = m.getConnection();
	} catch (FileNotFoundException e) {
		System.out.println("Error al acceder al fichero properties " + e.getMessage());
	} catch (IOException e) {
		System.out.println("Error al leer las propiedades del fichero properties" + e.getMessage());
	} catch (SQLException e) {
		System.out.println("Error al conectar a la base de datos");
	}
}


public EjemplarDAO getEjemplarDAO() {
	return new EjemplarDAOImpl(con);
}

public MensajeDAO getMensajeDAO() {
	return new MensajeDAOImpl(con);
}

public PlantaDAO getPlantaDAO() {
	return new PlantaDAOImpl(con);
}

public SeguimientoDAO getSeguimientoDAO() {
	return new SeguimientoDAOImpl(con);
}
public PersonaDAO getPersonaDAO() {
	return new PersonaDAOImpl(con);
}
public CredencialesDAO getCredencialesDAO() {
	return new CredencialesDAOImpl(con);
}



public static ConexionBD getCon() {
	if (f==null)
		f=new ConexionBD();
	return f;
}
}
