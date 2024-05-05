package clases;

/**
 * @author Grupo6
 * Clase hija de DecoratorBaul que permite agrear las funcionalidades pertinentes de manera dinamica en caso de que el viaje a realizar cuente con la necesidad del uso de baul. <br>
 * Esta clase se encarga de modificar el costo del viaje en base a ciertos porcentajes aplicandos sobre la cantiadad de pasajeros y los kilometros a recorrer. <br>
 */
public class DecoratorConBaul extends DecoratorBaul {

	public DecoratorConBaul(IViaje encapsulado) {
		super(encapsulado);
	}

	/**
	 * Metodo de tipo double que modifica el valor del viaje, sumandole un 10% por cantidad de pasajeros al valor base y un 5% por cantidad de kilometros recorridos al valor base. <br>
	 */
	public double getCosto() {
		double aux = this.encapsulado.getCosto();
		double incrementopax = aux * 0.1 * this.encapsulado.getPax();
		double incrementodist = aux * 0.05 * this.encapsulado.getKM();
		return aux + incrementopax + incrementodist;
	}

	
	public String getEstado() {
		return super.getEstado();
	}

}
