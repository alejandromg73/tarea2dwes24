package vista;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import control.Controlador;
import modelo.Ejemplar;
import modelo.Mensaje;
import modelo.Planta;

public class FachadaPersonal {
	 private static FachadaPersonal portalPersonal;
	    private FachadaPersonal() {
	    	
	    }
	    public static FachadaPersonal getPortalPersonal() {
	        if (portalPersonal == null) {
	        	portalPersonal = new FachadaPersonal();
	        }
	        return portalPersonal;
	    }
	    private Controlador controlador = Controlador.getServicios();
	    Scanner in = new Scanner(System.in);
	    public void menuPersonal() {
	        int opcion = 0;
	        do {
	        	System.out.println("------MENÚ DEL PERSONAL------");
	            System.out.println("Selecciona una opción:");
	            System.out.println("1. Gestión de plantas.");
	            System.out.println("2. Gestión de ejemplares.");
	            System.out.println("3. Gestión de mensajes.");
	            System.out.println("4. SALIR DEL PROGRAMA.");

	            opcion = in.nextInt();
	            if (opcion < 1 || opcion > 4) {
	                System.out.println("Opción incorrecta.");
	                continue;
	            }
	            switch (opcion) {
	                case 1:
	                    FachadaInvitado.getPortalInvitado().verTodasPlantas();
	                    break;
	                case 2:
	                    menuPersonalEjemplares();
	                    break;
	                case 3:
	                    menuPersonalMensajes();
	                    break;
	                
	            }
	        } while (opcion != 4);
	    }
	    
	    public void menuPersonalEjemplares() {
	    	int opcion = 0;
	    	do {
	        System.out.println("Selecciona una opción:");
	        System.out.println("1. Registrar nuevo ejemplar.");
	        System.out.println("2. Filtrar ejemplares por tipo de planta.");
	        System.out.println("3. Volver al menú principal.");
	        opcion = in.nextInt();
	        if (opcion < 1 || opcion > 3) {
	            System.out.println("Opción incorrecta.");
	            continue;
	        }
	        switch (opcion) {
	            case 1:
	                FachadaAdmin.getPortalAdmin().nuevoEjemplar();
	                break;
	            case 2:
	                //Filtrar ejemplares por tipo de planta
	                break;
	            
	        }
	    } while (opcion != 3);
	    }
	    public void menuPersonalMensajes() {
	    	int opcion = 0;
	    	do {
	        System.out.println("Selecciona una opción:");
	        System.out.println("1. Ver todos los mensajes.");
	        System.out.println("2. Ver mensajes por persona.");
	        System.out.println("3. Ver mensajes por rango de fechas.");
	        System.out.println("4. Ver mensajes por tipo de planta.");
	        System.out.println("5. Volver al menú principal.");
	        opcion = in.nextInt();
	        if (opcion < 1 || opcion > 5) {
	            System.out.println("Opción incorrecta.");
	            continue;
	        }
	        switch (opcion) {
	            case 1:
	            	FachadaAdmin.getPortalAdmin().verTodosMensajes();
	                break;
	            case 2:
	                //VerMensajesPersona();
	                break;
	            case 3:
	                //VerMensajesFechas();
	                break;
	            case 4:
	                //VerMensajesTipoPlanta();
	                break;
	            
	        }
	    } while (opcion != 5);
	    }
	    public void verTodosEjemplares() {
	        ArrayList<Ejemplar> ejemplares = (ArrayList<Ejemplar>) controlador.getServiciosEjemplar().verTodos();
	        if (ejemplares == null || ejemplares.isEmpty()) {
	            System.out.println("Lo siento, no hay ejemplsres para mostrar en la base de datos.");
	            return;
	        }
	        System.out.println("Todos los ejemplares: ");
	        for (Ejemplar e : ejemplares) {
	            System.out.println(e);
	        }
	    }
	    public void nuevoMensaje() {
	        Scanner in = new Scanner(System.in);
	        Mensaje nuevoMensaje = null;
	        int numeroEjemplar = 0;
	        boolean correcto = false;
	        do {
	            try {
	            	verTodosEjemplares();
	                System.out.println("Introduce el número del ejemplar: ");
	                numeroEjemplar = in.nextInt();
	                in.nextLine();
	                if (numeroEjemplar < 1 || numeroEjemplar > controlador.getServiciosEjemplar().contarEjemplares()) {
	                    System.out.println("Debes introducir un número entre el 1 y " + controlador.getServiciosEjemplar().contarEjemplares());
	                } else {
	                    String mensaje = "";
	                    boolean mensajeValido = false;
	                    do {
	                        System.out.println("Introduce el mensaje: ");
	                        mensaje = in.nextLine();
	                        if (!controlador.getServiciosMensaje().validarMensaje(mensaje)) {
	                            System.out.println("Formato de mensaje no válido.");
	                        } else {
	                            mensajeValido = true;
	                            String usuarioAutenticado = controlador.getUsuarioAutenticado();
	                            long idUsuario = controlador.getServiciosPersona().IdUsuarioAutenticado(usuarioAutenticado);
	                            nuevoMensaje = new Mensaje(
	                                    LocalDateTime.now(), 
	                                    mensaje, 
	                                    numeroEjemplar,
	                                    idUsuario);                       
	                            if (controlador.getServiciosMensaje().insertar(nuevoMensaje) > 0) {
	                                System.out.println("Mensaje añadido.");
	                                correcto = true;
	                            } else {
	                                System.out.println("No se ha podido añadir el mensaje.");
	                            }
	                        }
	                    } while (!mensajeValido);
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Debes introducir un número válido.");
	                in.nextLine();
	            }
	        } while (!correcto);
}
}
