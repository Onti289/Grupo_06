package modelo;

public abstract class ClienteAbstracto extends Usuario {

	public static int CANTCLIENTESDISPONIBLES;
	
	public ClienteAbstracto(String nombre, String contr, String nombreReal) {
		super(nombre, contr, nombreReal);
	}

	public abstract Sistema getSistema();

	public void setViaje(IViaje viaje) {
		// TODO Auto-generated method stub
		
	}


}
