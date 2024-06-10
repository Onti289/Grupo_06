package persistencia;

import java.io.Serializable;
import java.time.LocalDateTime;

import modelo.Cliente;
import modelo.ClienteAbstracto;

public class PedidoDTO implements Serializable{
	private LocalDateTime fecha;
    private String zona;
    private boolean mascotas;
    private boolean equipaje;
    private int cantidadPasajeros;
    private ClienteAbstracto cliente;
    private int distancia;
	
    
    public LocalDateTime getFecha() {
		return fecha;
	}
	
    
    public String getZona() {
		return zona;
	}
	public boolean isMascotas() {
		return mascotas;
	}
	public boolean isEquipaje() {
		return equipaje;
	}
	public int getCantidadPasajeros() {
		return cantidadPasajeros;
	}
	public ClienteAbstracto getCliente() {
		return cliente;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public void setMascotas(boolean mascotas) {
		this.mascotas = mascotas;
	}
	public void setEquipaje(boolean equipaje) {
		this.equipaje = equipaje;
	}
	public void setCantidadPasajeros(int cantidadPasajeros) {
		this.cantidadPasajeros = cantidadPasajeros;
	}
	public void setCliente(ClienteAbstracto cliente) {
		this.cliente = cliente;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
    
    
}
