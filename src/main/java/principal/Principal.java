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

import control.ServiciosPersona;
import control.ServiciosPlanta;
import fachada.ViveroFachada;
import modelo.Planta;

public class Principal {

	public static void main(String[] args){
		ViveroFachada portal = ViveroFachada.getPortal();
		Scanner in = new Scanner(System.in);
		System.out.println("GESTIÓN DEL VIVERO");
		int opcion = 0;
		do {
			portal.menuPrincipal();
			opcion = in.nextInt();
			if (opcion < 1 || opcion > 8) {
				System.out.println("Opcion no válida.");
				continue;
			}
			switch (opcion) {
			case 1:
				portal.menuPrincipalPlantas();
				break;
			case 2:
				portal.menuPrincipalEjemplares();
				break;
			case 3:
				portal.menuPrincipalMensajes();
				break;
			case 4:
				portal.menuPrincipalPersonas();
				break;
			}
		} while (opcion != 5);
		System.out.println("Fin del programa");
	}
		
	}

		
		
	
