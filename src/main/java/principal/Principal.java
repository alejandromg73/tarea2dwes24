package principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Principal {

	public static void main(String[] args) {
		Connection con;
		MysqlDataSource m = new MysqlDataSource();
		Properties prop= null;
		FileInputStream fis;
		String url = "jdbc:mysql://localhost:3306/basededatos";
		String usuario = "root";
		String password = "";
		try {
			con = DriverManager.getConnection(url, usuario, password);
			fis = new FileInputStream("src/main/resources/db.properties");
			prop.load(fis);
			url = prop.getProperty("url");
			usuario = prop.getProperty("usuario");
			password = prop.getProperty("password");
			m.setUrl(url);
			m.setUser(usuario);
			m.setPassword("password");
			con = m.getConnection();
			
			String sql = "INSERT INTO plantas(codigo, nombrecomun, nombrecientifico) VALUES ('"+nueva.getCodigo() + "', '"nueva.getNombrecomun() + "' , '"nueva.getNombreCientifico();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			con.close();
		}
		catch(SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
		catch(IOException e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}
