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
import vista.FachadaInvitado;
import modelo.Planta;

public class Principal {
    public static void main(String[] args) {
    	FachadaInvitado portalInvitado = FachadaInvitado.getPortalInvitado();
    	
        portalInvitado.menuInvitado();
    }
}
		
		

		
	

		
		
	
