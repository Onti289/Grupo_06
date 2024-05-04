package clases;

public class DecoratorConBaul extends DecoratorBaul {

	public DecoratorConBaul(IViaje encapsulado) {
		super(encapsulado);
	}

	public double getCosto() {
		double aux = this.encapsulado.getCosto();
		double incrementopax = aux * 0.1 * this.encapsulado.getPax();
		double incrementodist = aux * 0.05 * this.encapsulado.getKM();
		return aux + incrementopax + incrementodist;
	}

}
