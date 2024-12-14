package vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import control.Controlador;
import control.GestionSesion;
import control.PerfilUsuario;
import modelo.Planta;

public class FachadaInvitado {
	private static FachadaInvitado portalInvitado;

	private FachadaInvitado() {

	}

	public static FachadaInvitado getPortalInvitado() {
		if (portalInvitado == null) {
			portalInvitado = new FachadaInvitado();
		}
		return portalInvitado;
	}

	private Controlador controlador = Controlador.getServicios();
	private Scanner in = new Scanner(System.in);

	public void menuInvitado() {
		int opcion = 0;
		do {
			System.out.println("\t\t\t\t\t------GESTIÓN DEL VIVERO------");
			System.out.println();
			System.out.println("\t\t\t\t\tSelecciona una opción: ");
			System.out.println("\t\t\t\t\t───────────────────────────────");
			System.out.println("\t\t\t\t\t1. VER TODAS LAS PLANTAS");
			System.out.println("\t\t\t\t\t2. LOGUEARSE");
			System.out.println("\t\t\t\t\t3. SALIR DEL PROGRAMA");
			System.out.println("\t\t\t\t\t───────────────────────────────");
			try {
				opcion = in.nextInt();
				switch (opcion) {
				case 1:
					verTodasPlantas();
					break;
				case 2:
					login();
					break;
				case 3:
					System.out.println("Has salido del programa");
					break;
				default:
					System.out.println("Opción incorrecta.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes ingresar un número.");
				in.nextLine();
				opcion = 0;
			}
		} while (opcion != 3);
	}

	/**
	 * Método para hacer login en el programa. Compara si las credenciales que ha
	 * introducido el usuario son iguales que las que hay almacenadas en la base de
	 * datos, y en función de eso dirige al programa a la fachada de administrador o
	 * a la de personal (si el login falla, te devuelve al menú de invitado)
	 */
	public void login() {
	    in.nextLine(); 
	    System.out.print("Introduce usuario: ");
	    String usuario = in.nextLine().trim();
	    System.out.print("Introduce contraseña: ");
	    String contraseña = in.nextLine().trim();
	    try {
	        boolean autenticar = controlador.getServiciosCredenciales().autenticar(usuario, contraseña);
	        if (autenticar) {
	            System.out.println("Has iniciado sesión como: " + usuario);
	            long id = controlador.getServiciosPersona().IdUsuarioAutenticado(usuario);
	            PerfilUsuario perfil;
	            if ("admin".equalsIgnoreCase(usuario)) {
	                perfil = PerfilUsuario.ADMIN;
	            } else {
	                perfil = PerfilUsuario.PERSONAL;
	            }
	            GestionSesion.getSesion().iniciarSesion(id, usuario, perfil);
	            if (perfil == PerfilUsuario.ADMIN) {
	                System.out.println("Eres el usuario administrador");
	                FachadaAdmin.getPortalAdmin().menuAdmin();
	            } else {
	                System.out.println("Eres un usuario del personal del vivero");
	                FachadaPersonal.getPortalPersonal().menuPersonal();
	            }
	        } else {
	            System.out.println("Usuario o contraseña incorrectos");
	        }
	    } catch (Exception e) {
	        System.out.println("No se ha podido iniciar sesión: " + e.getMessage());
	    }
	}
	
	public void verTodasPlantas() {
		ArrayList<Planta> plantas = (ArrayList<Planta>) controlador.getServiciosPlanta().verTodos();
		if (plantas == null || plantas.isEmpty()) {
			System.out.println("Lo siento, no hay plantas para mostrar en la base de datos.");
			return;
		}
		System.out.println("Todas las plantas: ");
		System.out.println();
		for (Planta p : plantas) {
			System.out.println(p);
			System.out.println();
		}
	}

}