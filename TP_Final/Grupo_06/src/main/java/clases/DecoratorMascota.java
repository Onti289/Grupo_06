package clases;

import java.time.LocalDateTime;

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

}
