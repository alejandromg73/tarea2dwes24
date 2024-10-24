package principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.MysqlDataSource;

import modelo.Planta;

public class Principal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Dame el codigo de la nueva Planta:");
		String codigo = in.nextLine().trim().toUpperCase();
		System.out.println("Dame el nombre común de la nueva planta");
		String nombre_comun = in.nextLine();
		System.out.println("Dame el nombre cientifico de la nueva planta");
		String nombre_cientifico = in.nextLine();
		
		Planta nueva = new Planta(codigo, nombre_comun, nombre_cientifico);
		Connection con;
		MysqlDataSource m = new MysqlDataSource();
		Properties prop= null;
		FileInputStream fis;
		String url = "jdbc:mysql://localhost:3306/basededatos";
		String usuario = "root";
		String password = "";
		System.out.println("");
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
	
			String sql = "INSERT INTO plantas(codigo, nombrecomun, nombrecientifico) VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nueva.getCodigo());
			ps.setString(2, nueva.getNombrecomun());
			ps.setString(3, nueva.getNombrecientifico());
			
			ps.execute();
			ps.close();
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
