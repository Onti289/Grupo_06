package clases;

/**
 * @author Grupo6
 *
 * Clase hija de Viaje que representa a aquellos viajes donde la zona en la cual se realizara se considera peligrosa. Esta condicion afecta al
 * costo final del viaje, aplicandose un porcentaje determinado dependiendo de la cantidad de pasajeros y de los kilometros que deberan recorrerse. <br>
 */
public class ZonaPeligrosa extends Viaje {

	public ZonaPeligrosa(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		super(pedido, chofer, vehiculo);
	}

	/**
	 * Metodo del tipo double que a partir del valor base de viaje aplica un 10% de plus por cada pasajero y un 20% de plus por cada kilometro que debera recorrerse. <br>
	 * Devuelve el total o subtotal del costo del viaje, dependiendo de las caracteristicas del mismo. <br>
	 */
	@Override
	public double getCosto() {
		double aux = this.getValorBase();
		double incrementopax = aux * 0.1 * this.getPax();
		double incrementodist = aux * 0.2 * this.getKM();
		return aux + incrementopax + incrementodist;
	}
}
