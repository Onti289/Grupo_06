package clases;

public class DecoratorSinBaul extends DecoratorBaul {

	public DecoratorSinBaul(IViaje encapsulado) {
		super(encapsulado);
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
		return this.encapsulado.getCosto();
	}

}
