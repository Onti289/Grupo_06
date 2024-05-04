package clases;

public class CalleSinAsfaltar extends Viaje {

	public CalleSinAsfaltar(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		super(pedido, chofer, vehiculo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getCosto() {
		double aux = getValorBase();
		double incrementopax = aux * 0.2 * this.getPax();
		double incrementodist = aux * 0.15 * this.getKM();
		return aux + incrementopax + incrementodist;
	}

}
