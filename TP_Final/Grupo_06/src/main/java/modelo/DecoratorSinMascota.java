package modelo;

/**
 * @author Grupo6
 * Clase hija de DecoratorMascota que permite agrear las funcionalidades pertinentes de manera dinamica en caso de que el viaje a realizar no cuente con la necesidad de llevar una mascota. <br>
 * En este caso, esta clase no modifica el costo del viaje. <br> 
 **/
public class DecoratorSinMascota extends DecoratorMascota {

	public DecoratorSinMascota(IViaje encapsulado) {
		super(encapsulado);
	}

	public double getCosto() {
		return this.encapsulado.getCosto();
	}

	public String getEstado() {
		return super.getEstado();
	}
  
}
