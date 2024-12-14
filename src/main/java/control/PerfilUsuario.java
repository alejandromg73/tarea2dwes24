package control;
/*
 * Clase enum para gestionar los dos tipos de perfiles de podemos
 * tener logeados en el programa, no cuento el invitado porque el programa arranca
 * por la propia fachada del invitado y en ningún momento está logeado, entonces las variables
 * están a nulo hasta que se loguea el administrador o un personal
 */
public enum PerfilUsuario {
	ADMIN,
    PERSONAL;
}
