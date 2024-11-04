package fachada;

import control.Controlador;
import utils.ConexionBD;

public class ViveroFachada {
	private static ViveroFachada portal;
	
	/*ConexionBD conexionBD = (ConexionBD) ConexionBD.getConexion();
	Controlador servicios = control.Controlador.getServicios();
	control.ServiciosEjemplar ejServ = Controlador.getServiciosEjemplar();
	control.ServiciosPlanta plantaServ = Controlador.getServiciosPlanta();
	control.ServiciosPersona personaServ = Controlador.getServiciosPersona();
	control.ServiciosMensaje mensajeServ = Controlador.getServiciosMensaje();
	*/
	public static ViveroFachada getPortal() {
		if (portal==null)
			portal=new ViveroFachada();
		return portal;
	}
	
	public void menuPrincipal() {
		System.out.println("Selecciona una opcion:");
		System.out.println("1.  Gestión de plantas.");
		System.out.println("2.  Gestión de ejemplares.");
		System.out.println("3.  Gestión de mensajes.");
		System.out.println("4.  Gestión de personas.");
		System.out.println("5.  SALIR.");
	}
	
	public void menuPrincipalPlantas() {
		System.out.println("Selecciona una opcion:");
		System.out.println("1.  Ver plantas");
		System.out.println("2.  Crear nueva planta.");
		System.out.println("3.  Modificar datos de una planta.");
		System.out.println("4.  Eliminar una planta.");
		System.out.println("5.  Volver al menú principal.");
	}
	public void menuPrincipalEjemplares() {
		System.out.println("Selecciona una opcion:");
		System.out.println("1.  Registrar nuevo ejemplar.");
		System.out.println("2.  Filtrar ejemplares por tipo de planta.");
		System.out.println("3.  Eliminar un ejemplar.");
		System.out.println("4.  Volver al menú principal.");
	}
	public void menuPrincipalPersonas() {
		System.out.println("Selecciona una opcion:");
		System.out.println("1.  Registrar nueva persona.");
		System.out.println("2.  Ver todas las personas.");
		System.out.println("3.  Eliminar una persona.");
		System.out.println("4.  Volver al menú principal.");
	}
	public void menuPrincipalMensajes() {
		System.out.println("Selecciona una opcion:");
		System.out.println("1.  Nuevo mensaje.");
		System.out.println("2.  Ver mensajes.");
		System.out.println("3.  Volver al menú principal.");
	}
	
	
	public void menuModificarPlantas() {
		System.out.println("Selecciona una opcion:");
		System.out.println("1.  Modificar nombre común.");
		System.out.println("2.  Modificar nombre científico.");
		System.out.println("3.  Volver al menú de plantas.");
	}
	public void menuVerMensajes() {
		System.out.println("1.  Ver mensajes de un ejemplar.");
		System.out.println("2.  Ver mensajes de cada persona.");
		System.out.println("3.  Ver mensajes por rango de fechas.");
		System.out.println("4.  Ver mensajes por tipo de planta.");
		System.out.println("5.  Volver al menú de mensajes.");
	}
}
