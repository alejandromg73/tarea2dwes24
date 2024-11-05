package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.MysqlDataSource;

import control.Controlador;
import control.ServiciosCredenciales;
import control.ServiciosPersona;
import control.ServiciosPlanta;
import fachada.ViveroFachada;
import modelo.Planta;

public class Principal {
	private static Controlador controlador=Controlador.getServicios();

	public static void main(String[] args){
		ViveroFachada portal = ViveroFachada.getPortal();
		Scanner in = new Scanner(System.in);
		System.out.println("GESTIÓN DEL VIVERO");
		int opcion = 0;
		do {
			FachadaInvitado.menuInvitado();
			opcion = in.nextInt();
			if (opcion < 1 || opcion > 3) {
				System.out.println("Opcion no válida.");
				continue;
			}
			switch (opcion) {
			case 1:
				FachadaAdmin.verTodasPlantas();
				break;
			case 2:
				FachadaInvitado.login();
				break;
			}
		} while (opcion != 3);
		System.out.println("Fin del programa");
	}
		
		
		
		
		
		}
		
	

		
		
	
