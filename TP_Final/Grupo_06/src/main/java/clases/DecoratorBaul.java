package clases;

import java.time.LocalDateTime;

public abstract class DecoratorBaul implements IViaje{
  protected IViaje encapsulado;
	public DecoratorBaul(IViaje encapsulado) {
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
		this.encapsulado.setEstado(e);
	}


	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
		return this.encapsulado.getEstado();
	}

}
