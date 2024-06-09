package persistencia;

import java.io.Serializable;
import java.time.LocalDateTime;

import modelo.*;

public class IViajeDTO implements Serializable {
	private String estado;
	private Cliente cliente;
	private Chofer chofer;
	private Vehiculo vehiculo;
	private double costo;
	private static double valorBase = 1000.0;
	private int distanciaRealRecorrida;
	private int pasajeros;
	private LocalDateTime fecha;
	private Pedido pedido;

	
	public String getEstado() {
		return estado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Chofer getChofer() {
		return chofer;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public double getCosto() {
		return costo;
	}
	public static double getValorBase() {
		return valorBase;
	}
	public int getDistanciaRealRecorrida() {
		return distanciaRealRecorrida;
	}
	public int getPasajeros() {
		return pasajeros;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public static void setValorBase(double valorBase) {
		IViajeDTO.valorBase = valorBase;
	}
	public void setDistanciaRealRecorrida(int distanciaRealRecorrida) {
		this.distanciaRealRecorrida = distanciaRealRecorrida;
	}
	public void setPasajeros(int pasajeros) {
		this.pasajeros = pasajeros;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
}
