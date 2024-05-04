package clases;

public class DecoratorConMascota extends DecoratorMascota {

	public DecoratorConMascota(IViaje encapsulado) {
		super(encapsulado);
	}

	public double getCosto() {
		double aux = this.encapsulado.getCosto();
		double incrementopax = aux * 0.1 * this.encapsulado.getPax();
		double incrementodist = aux * 0.2 * this.encapsulado.getKM();
		return aux + incrementopax + incrementodist;
	}

	

}
