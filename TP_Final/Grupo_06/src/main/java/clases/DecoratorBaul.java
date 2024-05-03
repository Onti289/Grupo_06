package clases;

public class DecoratorBaul implements IViaje{
  protected IViaje encapsulado;
	public DecoratorBaul(IViaje encapsulado) {
		this.encapsulado = encapsulado;
	}
	public int getPax() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getKM() {
		// TODO Auto-generated method stub
		return 0;
	}
	public double getCosto() {
		// TODO Auto-generated method stub
		return 0;
	}

}
