package persistencia;

import java.io.Serializable;
import java.time.LocalDateTime;

import modelo.*;

public class IViajeDTO implements Serializable {
	private String estado;
	private ClienteDTO cliente;
	private ChoferDTO chofer;
	private VehiculoDTO vehiculo;
	private double costo;
	private static double valorBase = 1000.0;
	private int distanciaRealRecorrida;
	private int pasajeros;
	private LocalDateTime fecha;
	private String zona;
	private PedidoDTO pedido;

	
	public String getEstado() {
		return estado;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public ChoferDTO getChofer() {
		return chofer;
	}
	public VehiculoDTO getVehiculo() {
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
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public void setChofer(ChoferDTO chofer) {
		this.chofer = chofer;
	}
	public void setVehiculo(VehiculoDTO vehiculo) {
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
	public String getZona() {
		return zona;
	}
	public PedidoDTO getPedido() {
		return pedido;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public void setPedido(PedidoDTO pedido2) {
		this.pedido = pedido2;
	}
	

	
	
	
	
}
