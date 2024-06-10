package modelo;

import java.time.LocalDateTime;

/**
 * @author Grupo6
 * 
 * Clase abstacta que permite aplicar el patron Decorator, añadiendo funcionalidades a los viajes en cuanto a si es necesario el uso de baul o no de manera dinamica. <br>
 * Se implementa con el uso de un encapsulado que representa el viaje sin decorar. <br>
 *
 */
public abstract class DecoratorBaul implements IViaje{
  protected IViaje encapsulado;
	public DecoratorBaul(IViaje encapsulado) {
		this.encapsulado = encapsulado;
	}
	
	public void setChofer(Chofer chofer)
	{
		this.encapsulado.setChofer(chofer);
	}
	
	@Override
	public void setVehiculo(Vehiculo v) {
		this.encapsulado.setVehiculo(v);
		
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
	public void setEstado(String e) {
		this.encapsulado.setEstado(e);
	}

	@Override
	public Vehiculo getVehiculo() {
		return this.encapsulado.getVehiculo();
	}

	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
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
