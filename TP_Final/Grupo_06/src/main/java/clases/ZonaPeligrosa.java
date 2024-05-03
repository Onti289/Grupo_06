package clases;

public class ZonaPeligrosa extends Viaje {

	public ZonaPeligrosa(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		super(pedido, chofer, vehiculo);
		// TODO Auto-generated constructor stub
	}

	public int getPax() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getKM() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCosto() {
		double aux = this.getValorBase();
		double incrementopax = aux * 0.1 * this.getPax();
		double incrementodist = aux * 0.2 * this.getKM();
		return aux + incrementopax + incrementodist;
	}

}
