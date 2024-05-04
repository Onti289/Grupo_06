package clases;

public class DecoratorSinMascota extends DecoratorMascota {

	public DecoratorSinMascota(IViaje encapsulado) {
		super(encapsulado);
	}

	public double getCosto() {
		return this.encapsulado.getCosto();
	}

}
