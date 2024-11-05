package vista;

import java.util.Scanner;

import control.Controlador;

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
}
