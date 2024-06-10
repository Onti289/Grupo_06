package modelo;

import java.time.LocalDateTime;

/**
 * @author Grupo6
 * 
 * Clase abstacta que permite aplicar el patron Decorator, añadiendo funcionalidades a los viajes en cuanto a si es necesario el traslado de mascotas o no de manera dinamica. <br>
 * Se implementa con el uso de un encapsulado que representa el viaje sin decorar. <br>
 *
 */
public abstract class DecoratorMascota implements IViaje{
  protected IViaje encapsulado;

	public DecoratorMascota(IViaje encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}
	
	public int getPax() {
		return this.encapsulado.getPax();
	}

	public int getKM() {
		return this.encapsulado.getKM();
	}
	
	public Chofer getChofer() {
		return this.encapsulado.getChofer();
	}
	
	public LocalDateTime getFecha() {
		return this.encapsulado.getFecha();
	}
	
	public ClienteAbstracto getCliente() {
		return this.encapsulado.getCliente();
	}
	
	@Override
	public Vehiculo getVehiculo() {
		return this.encapsulado.getVehiculo();
	}
	
	@Override
	public void setEstado(String e) {
		encapsulado.setEstado(e);
	}

	@Override
	public String getEstado() {

		return this.encapsulado.getEstado();
	}
	@Override
	public String toString() {
		return encapsulado.toString();
	}
	
	@Override
	public Pedido getPedido() {
		return encapsulado.getPedido();
	}

}
