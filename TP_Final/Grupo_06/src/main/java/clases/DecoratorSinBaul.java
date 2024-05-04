package clases;

public class DecoratorSinBaul extends DecoratorBaul {

	public DecoratorSinBaul(IViaje encapsulado) {
		super(encapsulado);
	}


	public double getCosto() {
		return this.encapsulado.getCosto();
	}

}
