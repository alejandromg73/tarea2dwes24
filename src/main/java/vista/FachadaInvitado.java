package vista;

import java.util.ArrayList;
import java.util.Scanner;

import control.Controlador;
import control.ServiciosCredenciales;
import modelo.Planta;
import utils.ConexionBD;

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
            System.out.println("1. VER TODAS LAS PLANTAS");
            System.out.println("2. LOGUEARSE");
            System.out.println("3. SALIR DEL PROGRAMA");
            System.out.print("Selecciona una opción: ");
            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    verTodasPlantas();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción incorrecta. Por favor, intenta de nuevo.");
            }
        } while (opcion != 3);
    }
    public void login() {
        System.out.print("Introduce usuario: ");
        String usuario = in.nextLine();
        System.out.print("Introduce contraseña: ");
        String contraseña = in.nextLine();
        boolean autenticar = controlador.getServiciosCredenciales().autenticar(usuario, contraseña);
        if (autenticar) {
            System.out.println("Has iniciado sesión como " + usuario);
            if (usuario.equalsIgnoreCase("admin")) {
                FachadaAdmin.getPortalAdmin().menuAdmin(); 
            } else {
                FachadaPersonal.getPortalPersonal().menuPersonal(); 
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }
    public void verTodasPlantas() {
        ArrayList<Planta> plantas = (ArrayList<Planta>) controlador.getServiciosPlanta().verTodos();
        if (plantas == null || plantas.isEmpty()) {
            System.out.println("Lo siento, no hay plantas para mostrar en la base de datos.");
            return;
        }
        System.out.println("Todas las plantas: ");
        for (Planta p : plantas) {
            System.out.println(p);
        }
    }
    
}