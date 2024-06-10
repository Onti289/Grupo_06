package persistencia;

import java.io.Serializable;

import modelo.Sistema;

public class ClienteDTO implements Serializable {
	private String nombre;
	private String contrasena;
	private String nombreReal;
	private Sistema sistema;
	
	public Sistema getSistema() {
		return sistema;
	}
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	public String getNombre() {
		return nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public String getNombreReal() {
		return nombreReal;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	
	
}
