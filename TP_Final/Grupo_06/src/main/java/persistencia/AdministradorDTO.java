package persistencia;

import java.io.Serializable;
import java.util.LinkedList;

import modelo.Chofer;
import modelo.Cliente;
import modelo.IViaje;
import modelo.Vehiculo;

public class AdministradorDTO implements Serializable {
	private String nombre;
	private String contrasena;
	private String nombreReal;
	private LinkedList<ChoferDTO> colaChoferes = new LinkedList<ChoferDTO>();
    private LinkedList<VehiculoDTO> colaVehiculos = new LinkedList<VehiculoDTO>();
    private LinkedList<VehiculoDTO> colaTotalVehiculos = new LinkedList<VehiculoDTO>();
    private LinkedList<ClienteDTO> listaClientes = new LinkedList<ClienteDTO>();
    private LinkedList<IViajeDTO> listaViajes = new LinkedList<IViajeDTO>();
    private LinkedList<ClienteHumanoDTO> listaClientesHumanos = new LinkedList<ClienteHumanoDTO>();
	
    public String getNombre() {
		return nombre;
	}
	
    public String getContrasena() {
		return contrasena;
	}
	
    public LinkedList<VehiculoDTO> getColaTotalVehiculos() {
		return colaTotalVehiculos;
	}

	public void setColaTotalVehiculos(LinkedList<VehiculoDTO> colaTotalVehiculos) {
		this.colaTotalVehiculos = colaTotalVehiculos;
	}

	public LinkedList<ClienteHumanoDTO> getListaClientesHumanos() {
		return listaClientesHumanos;
	}

	public void setListaClientesHumanos(LinkedList<ClienteHumanoDTO> listaClientesHumanos) {
		this.listaClientesHumanos = listaClientesHumanos;
	}

	public String getNombreReal() {
		return nombreReal;
	}
	
    public LinkedList<ChoferDTO> getColaChoferes() {
		return colaChoferes;
	}
	
    public LinkedList<VehiculoDTO> getColaVehiculos() {
		return colaVehiculos;
	}
	
    public LinkedList<ClienteDTO> getListaClientes() {
		return listaClientes;
	}
	
    public LinkedList<IViajeDTO> getListaViajes() {
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
	
    public void setColaChoferes(LinkedList<ChoferDTO> choferesDTO) {
		this.colaChoferes = choferesDTO;
	}
	
    public void setColaVehiculos(LinkedList<VehiculoDTO> colaVehiculos) {
		this.colaVehiculos = colaVehiculos;
	}
	
    public void setListaClientes(LinkedList<ClienteDTO> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
    public void setListaViajes(LinkedList<IViajeDTO> listaViajes) {
		this.listaViajes = listaViajes;
	}
    
}
