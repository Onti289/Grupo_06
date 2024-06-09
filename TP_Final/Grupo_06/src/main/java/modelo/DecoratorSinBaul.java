package modelo;

/**
 * @author Grupo6
 * Clase hija de DecoratorBaul que permite agrear las funcionalidades pertinentes de manera dinamica en caso de que el viaje a realizar no necesite del uso de baul. <br>
 * En este caso, esta clase no modifica el costo del viaje. <br>
 */
public class DecoratorSinBaul extends DecoratorBaul {

	public DecoratorSinBaul(IViaje encapsulado) {
		super(encapsulado);
	}


	public double getCosto() {
		return this.encapsulado.getCosto();
	}

	public String getEstado() {
		return super.getEstado();
	}

}
