package vista;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import control.Controlador;
import control.GestionSesion;
import modelo.Ejemplar;
import modelo.Mensaje;

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
			System.out.println("\t\t\t\t\t------MENÚ DEL PERSONAL------");
			System.out.println("\t\t\t\t\tSelecciona una opción:");
			System.out.println(" \t\t\t\t\t ───────────────────────────────");
			System.out.println("\t\t\t\t\t1. VER TODAS LAS PLANTAS.");
			System.out.println("\t\t\t\t\t2. Gestión de ejemplares.");
			System.out.println("\t\t\t\t\t3. Gestión de mensajes.");
			System.out.println("\t\t\t\t\t4. CERRAR SESIÓN.");
			System.out.println("\t\t\t\t\t  ───────────────────────────────");
			try {
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
				case 4:
					GestionSesion.getSesion().cerrarSesion();;
					return;

				}
			} catch (InputMismatchException e) {
				System.out.println("Debes ingresar un número.");
				in.nextLine();
				opcion = 0;
			}
		} while (opcion != 4);
	}

	public void menuPersonalEjemplares() {
		int opcion = 0;
		do {
			System.out.println("\t\t\t\t\tSelecciona una opción:");
			System.out.println(" \t\t\t\t\t ───────────────────────────────");
			System.out.println("\t\t\t\t\t1. Registrar nuevo ejemplar.");
			System.out.println("\t\t\t\t\t2. Filtrar ejemplares por tipo de planta.");
			System.out.println("\t\t\t\t\t3. Ver mensajes de un ejemplar.");
			System.out.println("\t\t\t\t\t4. Volver al menú principal.");
			System.out.println("\t\t\t\t\t ───────────────────────────────");
			try {
				opcion = in.nextInt();
				if (opcion < 1 || opcion > 4) {
					System.out.println("Opción incorrecta.");
					continue;
				}
				switch (opcion) {
				case 1:
					FachadaAdmin.getPortalAdmin().nuevoEjemplar();
					break;
				case 2:
					filtrarEjemplaresPorCodigoPlanta();
					break;
				case 3:
					FachadaAdmin.getPortalAdmin().verMensajesEjemplar();
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes ingresar un número.");
				in.nextLine();
				opcion = 0;
			}
		} while (opcion != 4);
	}

	public void menuPersonalMensajes() {
		int opcion = 0;
		do {
			System.out.println("\t\t\t\t\tSelecciona una opción:");
			System.out.println("\t\t\t\t\t ───────────────────────────────");
			System.out.println("\t\t\t\t\t1. Nuevo mensaje.");
			System.out.println("\t\t\t\t\t2. Ver todos los mensajes.");
			System.out.println("\t\t\t\t\t3. Ver mensajes por persona.");
			System.out.println("\t\t\t\t\t4. Ver mensajes por rango de fechas.");
			System.out.println("\t\t\t\t\t5. Ver mensajes por tipo de planta.");
			System.out.println("\t\t\t\t\t6. Volver al menú principal.");
			System.out.println("\t\t\t\t\t ───────────────────────────────");
			try {
				opcion = in.nextInt();
				if (opcion < 1 || opcion > 6) {
					System.out.println("Opción incorrecta.");
					continue;
				}
				switch (opcion) {
				case 1:
					nuevoMensaje();
					break;
				case 2:
					FachadaAdmin.getPortalAdmin().verTodosMensajes();
					break;
				case 3:
					verMensajesPersona();
					break;
				case 4:
					verMensajeFechas();
					break;
				case 5:
					verMensajeTipoPlanta();
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println("Debes ingresar un número.");
				in.nextLine();
				opcion = 0;
			}
		} while (opcion != 6);
	}

	public void verTodosEjemplares() {
		ArrayList<Ejemplar> ejemplares = (ArrayList<Ejemplar>) controlador.getServiciosEjemplar().verTodos();
		if (ejemplares == null || ejemplares.isEmpty()) {
			System.out.println("Lo siento, no hay ejemplsres para mostrar en la base de datos.");
			return;
		}
		System.out.println("Todos los ejemplares: ");
		System.out.println();
		for (Ejemplar e : ejemplares) {
			System.out.println(e);
			System.out.println();
		}
	}

	/**
	 * Método para crear un nuevo mensaje sobre un ejemplar de la base de datos.
	 * Primero se muestran todos para que el usuario elija
	 */
	public void nuevoMensaje() {
		Mensaje nuevoMensaje = null;
		int idEjemplar = 0;
		boolean correcto = false;
		do {
			try {
				verTodosEjemplares();
				System.out.println();
				System.out.println("Introduce el id del ejemplar para ponerle un mensaje: ");
				idEjemplar = in.nextInt();
				in.nextLine();
				if (idEjemplar < 1 || idEjemplar > controlador.getServiciosEjemplar().contarEjemplares()) {
					System.out.println("Debes introducir un número entre el 1 y el"
							+ controlador.getServiciosEjemplar().contarEjemplares());
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
							String usuarioAutenticado = GestionSesion.getSesion().getUsuario();
							long idUsuario = controlador.getServiciosPersona().IdUsuarioAutenticado(usuarioAutenticado);
							nuevoMensaje = new Mensaje(LocalDateTime.now(), mensaje, idEjemplar, idUsuario);
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

	public void filtrarEjemplaresPorCodigoPlanta() {
		in.nextLine();
		FachadaInvitado.getPortalInvitado().verTodasPlantas();
		try {
			System.out.print("Introduce el código de la planta para ver los ejemplares: ");
			System.out.println();
			String codigo = in.nextLine().trim().toUpperCase();
			boolean valido = controlador.getServiciosPlanta().codigoExistente(codigo);
			if (valido) {
				ArrayList<Ejemplar> ejemplares = controlador.getServiciosEjemplar().ejemplaresPorTipoPlanta(codigo);
				if (ejemplares.isEmpty()) {
					System.out.println("No hay ejemplares para la planta con código: " + codigo);
				} else {
					System.out.println("Ejemplares con el código " + codigo + ":");
					System.out.println();
					for (Ejemplar e : ejemplares) {
						System.out.println(e);
						System.out.println();
					}
				}
			} else {
				System.out.println("No se encontró ninguna planta con el código especificado: " + codigo);
			}
		} catch (Exception e) {
			System.out.println("Error al intentar filtrar los ejemplares: " + e.getMessage());
		}
	}

	public void verMensajesPersona() {
		FachadaAdmin.getPortalAdmin().verTodasPersonas();
		System.out.print("Introduce el id de una persona para ver sus mensajes: ");
		try {
			long idPersona = in.nextLong();
			ArrayList<Mensaje> mensajes = controlador.getServiciosMensaje().verMensajesPorPersona(idPersona);
			if (mensajes.isEmpty()) {
				System.out.println("No se encontraron mensajes para la persona: " + idPersona);
			} else {
				System.out.println("Mensajes:");
				System.out.println();
				for (Mensaje m : mensajes) {
					System.out.println(m);
					System.out.println();
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Debes introducir un número válido.");
			in.nextLine();
		} catch (Exception e) {
			System.out.println("Se produjo un error al intentar obtener los mensajes: " + e.getMessage());
		}
	}

	public void verMensajeTipoPlanta() {
		in.nextLine();
		FachadaInvitado.getPortalInvitado().verTodasPlantas();
		System.out.print("Introduce el código de una planta: ");
		String codigo = in.nextLine().trim().toUpperCase();
		try {
			boolean valido = controlador.getServiciosPlanta().validarCodigo(codigo);
			if (!valido) {
				System.out.println("El código de la planta no es válido.");
				return;
			}
			String usuario = GestionSesion.getSesion().getUsuario();
			boolean existe = controlador.getServiciosPlanta().codigoExistente(codigo);
			if (existe) {
				ArrayList<Mensaje> mensajes = controlador.getServiciosMensaje().verMensajesPorCodigoPlanta(codigo);
				if (mensajes.isEmpty()) {
					System.out.println("No se encontraron mensajes de la planta");
				} else {
					System.out.println("Mensajes para la planta con el código " + codigo);
					System.out.println();
					for (Mensaje m : mensajes) {
						System.out.println("Id del mensaje: " + m.getId());
						System.out.println("Fecha: " + m.getFechaHora().getDayOfMonth() + "-" + m.getFechaHora().getMonthValue() + "-" + m.getFechaHora().getYear() + " Hora: " + m.getFechaHora().getHour() + ":" + m.getFechaHora().getMinute());
						System.out.println("Mensaje: " + m.getMensaje());
						System.out.println("Id del ejemplar: " + m.getIdEjemplar());
						System.out.println("Usuario: " + usuario);
						System.out.println();
						System.out.println();
					}
				}
			} else {
				System.out.println("No se encontró ninguna planta con ese código");
			}
		} catch (Exception e) {
			System.out.println("Se produjo un error al intentar obtener los mensajes: " + e.getMessage());
		}
	}

	public void verMensajeFechas() {
		in.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDateTime fechaInicio = null;
		LocalDateTime fechaFin = null;
		do {
			try {
				System.out.print("Introduce la primera fecha y la hora con el formato: dd-MM-yyyy HH:mm ");
				String fechaInicioIntro = in.nextLine();
				fechaInicio = LocalDateTime.parse(fechaInicioIntro, formatter);
			} catch (DateTimeParseException e) {
				System.out.println("Formato de fecha no válido.");
			}
		} while (fechaInicio == null);
		do {
			try {
				System.out.print("Introduce la segunda fecha y la hora con el formato: dd-MM-yyyy HH:mm ");
				String fechaFinIntro = in.nextLine();
				fechaFin = LocalDateTime.parse(fechaFinIntro, formatter);
				if (fechaFin.isBefore(fechaInicio)) {
					System.out.println("La fecha de fin no puede ser anterior a la fecha de inicio.");
					fechaFin = null;
				}
			} catch (DateTimeParseException e) {
				System.out.println("Formato de fecha no válido.");
			}
		} while (fechaFin == null);
		ArrayList<Mensaje> mensajes = controlador.getServiciosMensaje().verMensajesFecha(fechaInicio, fechaFin);
		if (mensajes.isEmpty()) {
			System.out.println("No se encontraron mensajes en el rango de fechas proporcionado.");
		} else {
			System.out.println("Mensajes encontrados:");
			System.out.println();
			for (Mensaje m : mensajes) {
				System.out.println(m);
				System.out.println();

			}
		}
	}
}
