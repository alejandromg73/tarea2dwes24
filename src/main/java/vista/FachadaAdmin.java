package vista;

import java.util.ArrayList;
import java.util.Scanner;

import control.Controlador;
import modelo.Ejemplar;
import modelo.Mensaje;
import modelo.Persona;
import modelo.Planta;
import utils.ConexionBD;

public class FachadaAdmin {
    private static FachadaAdmin portalAdmin;
    private FachadaAdmin() {
    	
    }
    public static FachadaAdmin getPortalAdmin() {
        if (portalAdmin == null) {
            portalAdmin = new FachadaAdmin();
        }
        return portalAdmin;
    }
    private Controlador controlador = Controlador.getServicios();
    Scanner in = new Scanner(System.in);
    
    public void menuAdmin() {
        int opcion = 0;
        do {
        	System.out.println("------MENÚ DE ADMINISTRADOR------");
            System.out.println("Selecciona una opción:");
            System.out.println("1. Gestión de plantas.");
            System.out.println("2. Gestión de ejemplares.");
            System.out.println("3. Gestión de mensajes.");
            System.out.println("4. Gestión de personas.");
            System.out.println("5. SALIR DEL PROGRAMA.");

            opcion = in.nextInt();
            if (opcion < 1 || opcion > 5) {
                System.out.println("Opción incorrecta.");
                continue;
            }
            switch (opcion) {
                case 1:
                    menuAdminPlantas();
                    break;
                case 2:
                    menuAdminEjemplares();
                    break;
                case 3:
                    menuAdminMensajes();
                    break;
                case 4:
                    menuAdminPersonas();
                    break;
            }
        } while (opcion != 5);
        System.out.println("Fin del programa");
    }
    public void menuAdminPlantas() {
        int opcion = 0;
        do {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Ver plantas.");
            System.out.println("2. Crear nueva planta.");
            System.out.println("3. Modificar datos de una planta.");
            System.out.println("4. Volver al menú principal.");

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
                    nuevaPlanta();
                    break;
                case 3:
                    menuAdminModificarPlantas();
                    break;
            }
        } while (opcion != 4);
    }
    public void menuAdminModificarPlantas() {
    	int opcion = 0;
        do {
        System.out.println("Selecciona una opción:");
        System.out.println("1. Modificar nombre común.");
        System.out.println("2. Modificar nombre científico.");
        System.out.println("3. Volver al menú de plantas.");
        opcion = in.nextInt();
        if (opcion < 1 || opcion > 3) {
            System.out.println("Opción incorrecta.");
            continue;
        }
        switch (opcion) {
            case 1:
                //modificarNombreComun();
                break;
            case 2:
                //modificarNombreCientifico();
                break;
            
        }
    } while (opcion != 3);
    }

    public void menuAdminEjemplares() {
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
                nuevoEjemplar();
                break;
            case 2:
                //Filtrar ejemplares por tipo de planta
                break;
            
        }
    } while (opcion != 3);
    }

    public void menuAdminPersonas() {
    	int opcion = 0;
    	do {
        System.out.println("Selecciona una opción:");
        System.out.println("1. Registrar nueva persona.");
        System.out.println("2. Ver todas las personas.");
        System.out.println("3. Volver al menú principal.");
        opcion = in.nextInt();
        if (opcion < 1 || opcion > 3) {
            System.out.println("Opción incorrecta.");
            continue;
        }
        switch (opcion) {
            case 1:
            	//nuevaPersona();
                break;
            case 2:
                verTodasPersonas();
                break;
            
        }
    } while (opcion != 3);
    }

    public void menuAdminMensajes() {
    	int opcion = 0;
    	do {
        System.out.println("Selecciona una opción:");
        System.out.println("1. Nuevo mensaje.");
        System.out.println("2. Ver mensajes.");
        System.out.println("3. Volver al menú principal.");
        opcion = in.nextInt();
        if (opcion < 1 || opcion > 3) {
            System.out.println("Opción incorrecta.");
            continue;
        }
        switch (opcion) {
            case 1:
            	//nuevoMensaje();
                break;
            case 2:
                menuAdminVerMensajes();
                break;
            
        }
    } while (opcion != 3);
    }
    public void menuAdminVerMensajes() {
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
            	verTodosMensajes();
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
    

    public Planta nuevaPlanta() {
        Planta p;
        boolean correcto = false;
        do {
            p = new Planta();
            System.out.println("Introduce los datos para una nueva planta:");
            System.out.print("Código: ");
            String codigo = in.nextLine().trim().toUpperCase();
            p.setCodigo(codigo);
            System.out.print("Nombre común: ");
            String nombrecomun = in.nextLine();
            p.setNombrecomun(nombrecomun);
            System.out.print("Nombre científico: ");
            String nombrecientifico = in.nextLine();
            p.setNombrecientifico(nombrecientifico);
            correcto = controlador.getServiciosPlanta().validarPlanta(p);
            if (!correcto) {
                System.out.println("Los datos que has introducido no son correctos.");
            }
        } while (!correcto);
        try {
            controlador.getServiciosPlanta().insertar(p);
            System.out.println("Planta insertada");
        } catch (Exception ex) {
            System.out.println("Error al insertar la planta: " + ex.getMessage());
        }
        return p;
    }

    public Ejemplar nuevoEjemplar() {
        Ejemplar e;
        boolean correcto = false;
        do {
            e = new Ejemplar();
            System.out.println("Introduce los datos para crear un nuevo ejemplar:");
            System.out.print("Código de la planta del ejemplar: ");
            String codigoPlanta = in.nextLine();
            e.setCodigoPlanta(codigoPlanta);
            System.out.print("Nombre del ejemplar: ");
            String nombre = in.nextLine();
            e.setNombre(nombre);
            correcto = controlador.getServiciosEjemplar().validarEjemplar(e);
            if (!correcto) {
                System.out.println("Los datos que has introducido no son correctos.");
            }
        } while (!correcto);
        try {
            controlador.getServiciosEjemplar().insertar(e);
            System.out.println("Ejemplar insertado");
        } catch (Exception ex) {
            System.out.println("Error al insertar el ejemplar: " + ex.getMessage());
        }
        return e;
    }
    public Persona nuevaPersona() {
        Persona pers;
        boolean correcto = false;
        do {
            pers = new Persona();
            System.out.println("Introduce los datos para registrar una nueva persona:");
            System.out.print("Nombre: ");
            String nombre = in.nextLine();
            pers.setNombre(nombre);
            System.out.print("Email: ");
            String email = in.nextLine();
            pers.setEmail(email);
            System.out.println("Usuario: ");
            String usuario = in.nextLine();
            System.out.println("Contraseña: ");
            String contraseña = in.nextLine();
            correcto = controlador.getServiciosPlanta().validarPersona(pers);
            if (!correcto) {
                System.out.println("Los datos que has introducido no son correctos.");
            }
        } while (!correcto);
        try {
            controlador.getServiciosPersona().insertar(pers);
            System.out.println("Persona insertada");
        } catch (Exception ex) {
            System.out.println("Error al insertar la persona nueva: " + ex.getMessage());
        }
        return pers;
    }
    public void verTodasPersonas() {
        ArrayList<Persona> personas = (ArrayList<Persona>) controlador.getServiciosPersona().verTodos();
        if (personas == null || personas.isEmpty()) {
            System.out.println("Lo siento, no hay personas para mostrar en la base de datos.");
            return;
        }
        System.out.println("Todas las personas: ");
        for (Persona pers : personas) {
            System.out.println(pers);
        }
    }
    public void verTodosMensajes() {
        ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) controlador.getServiciosMensaje().verTodos();
        if (mensajes == null || mensajes.isEmpty()) {
            System.out.println("Lo siento, no hay mensajes para mostrar en la base de datos.");
            return;
        }
        System.out.println("Todos los mensajes: ");
        for (Mensaje m: mensajes) {
            System.out.println(m);
        }
    }
    
    public void modificarNombreComun() {
    	    boolean valido = false;
    	    String codigo = "";
    	    
    	    do {
    	        System.out.print("Introduce el código de la planta de la que quieres modificar el nombre común: ");
    	        codigo = in.nextLine().trim().toUpperCase();
    	        valido = controlador.getServiciosPlanta().validarCodigo(codigo);
    	        if (valido==false) {
    	            System.out.println("El código de la planta que has introducido no es válido");
    	        }
    	    } while (valido==false);
    	    System.out.print("Introduce el nuevo nombre común de la planta: ");
    	    String nuevoNombreComun = in.nextLine().trim();
    	    try {
    	        boolean nuevo = controlador.getServiciosPlanta().actualizarNombreComun(codigo, nuevoNombreComun);
    	        if (nuevo) {
    	            System.out.println("El nombre común de la planta con código " + codigo + "ha sido actualizado, ahora el nombre es" + nuevoNombreComun);
    	        } else {
    	            System.out.println("Error al intentar actualizar el nombre común");
    	        }
    	    } catch (Exception ex) {
    	        System.out.println("Error al actualizar el nombre común: " + ex.getMessage());
    	    }
    }
    
    public void modificarNombrecientifico() {
    	boolean valido = false;
	    String codigo = "";
	    do {
	        System.out.print("Introduce el código de la planta de la que quieres modificar el nombre científico: ");
	        codigo = in.nextLine().trim().toUpperCase();
	        valido = controlador.getServiciosPlanta().validarCodigo(codigo);
	        if (valido==false) {
	            System.out.println("El código de la planta que has introducido no es válido");
	        }
	    } while (valido==false);
	    System.out.print("Introduce el nuevo nombre común de la planta: ");
	    String nuevoNombreComun = in.nextLine().trim();
	    try {
	        boolean nuevo = controlador.getServiciosPlanta().actualizarNombreComun(codigo, nuevoNombreComun);
	        if (nuevo) {
	            System.out.println("El nombre común de la planta con código " + codigo + "ha sido actualizado, ahora el nombre es" + nuevoNombreComun);
	        } else {
	            System.out.println("Error al intentar actualizar el nombre común");
	        }
	    } catch (Exception ex) {
	        System.out.println("Error al actualizar el nombre común: " + ex.getMessage());
	    }

    }
}

