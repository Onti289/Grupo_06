package persistencia;

import java.io.Serializable;
import java.util.LinkedList;

import clases.Chofer;
import clases.Cliente;
import clases.IViaje;
import clases.Vehiculo;

public class AdministradorDTO implements Serializable {
	private String nombre;
	private String contrasena;
	private String nombreReal;
	private LinkedList<Chofer> colaChoferes = new LinkedList<Chofer>();
    private LinkedList<Vehiculo> colaVehiculos = new LinkedList<Vehiculo>();
    private LinkedList<Cliente> listaClientes = new LinkedList<Cliente>();
    private LinkedList<IViaje> listaViajes = new LinkedList<IViaje>();
	
    public String getNombre() {
		return nombre;
	}
	
    public String getContrasena() {
		return contrasena;
	}
	
    public String getNombreReal() {
		return nombreReal;
	}
	
    public LinkedList<Chofer> getColaChoferes() {
		return colaChoferes;
	}
	
    public LinkedList<Vehiculo> getColaVehiculos() {
		return colaVehiculos;
	}
	
    public LinkedList<Cliente> getListaClientes() {
		return listaClientes;
	}
	
    public LinkedList<IViaje> getListaViajes() {
		return listaViajes;
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
	
    public void setColaChoferes(LinkedList<Chofer> colaChoferes) {
		this.colaChoferes = colaChoferes;
	}
	
    public void setColaVehiculos(LinkedList<Vehiculo> colaVehiculos) {
		this.colaVehiculos = colaVehiculos;
	}
	
    public void setListaClientes(LinkedList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
    public void setListaViajes(LinkedList<IViaje> listaViajes) {
		this.listaViajes = listaViajes;
	}
    
}
