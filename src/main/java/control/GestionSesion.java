package control;
/*
 * Antes gestionaba la sesión simplemente con una variable String que almacenaba el nombre
 * de usuario autenticado. 
 * Ahora, he creado esta clase GestionSesion para establecer las sesiones correctamente
 * Esta clase almacena los atributos del id del usaurio, el usuario, y el perfil de usuario
 * Además, contiene los métodos para iniciar y cerrar la sesión
 */
public class GestionSesion {
	private static GestionSesion sesion;
	private Long idUsuario;
    private String usuario;
    private PerfilUsuario perfilUsuario; //De tipo perfilUsuario
    
    private GestionSesion() {
    	
    }
    public static GestionSesion getSesion() {
        if (sesion == null) {
            sesion = new GestionSesion();
        }
        return sesion;
    }
    //Método para iniciar la sesión de un usuario cuando se loguea
    public void iniciarSesion(Long idUsuario, String nombreUsuario, PerfilUsuario perfilUsuario) {
        this.idUsuario = idUsuario;
        this.usuario = nombreUsuario;
        this.perfilUsuario = perfilUsuario;
    }
    //Método para cerrar la sesión de un usuario, estableciendo todas sus variables a nulo
    public void cerrarSesion() {
            this.idUsuario = null;
            this.usuario = null;
            this.perfilUsuario = null;
        }

	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}
	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}
	
    








}
    

