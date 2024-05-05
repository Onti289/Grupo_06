package clases;

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
	
	public Cliente getCliente() {
		return this.encapsulado.getCliente();
	}
	
	@Override
	public void setEstado(String e) {
		encapsulado.setEstado(e);
	}

	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
		return this.encapsulado.getEstado();
	}
}
