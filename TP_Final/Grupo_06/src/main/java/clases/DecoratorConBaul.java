package clases;

public class DecoratorConBaul extends DecoratorBaul {

	public DecoratorConBaul(IViaje encapsulado) {
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
		double aux = this.encapsulado.getCosto();
		double incrementopax = aux * 0.1 * this.encapsulado.getPax();
		double incrementodist = aux * 0.05 * this.encapsulado.getKM();
		return aux + incrementopax + incrementodist;
	}

}
