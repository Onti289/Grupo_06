package clases;

/**
 * @author Grupo_6
 * 
 * Clase hija de Vehiculo que representa a las motos dentro del sistema. Dentro de ella se define la prioridad con respcto a los demas tipos de vehiculos. <br>
 *
 */
public class Moto extends Vehiculo {

    public Moto(String patente, boolean baul, boolean petFriendly, int maxPasajeros) {
        super(patente, baul, petFriendly, maxPasajeros);
    }

	/**
	 * Metodo de tipo boolean que permite saber la prioridad de un Automovil contra cualquiera de los otros tipos de vehiculos. <br>
	 *
	 * IVehiculo o contiene la referencia al otro vehiculo que se comparara contra algun Automovil. <br>
	 */
	public boolean beats(IVehiculo o) {
		return o.beatsMoto();
	}

	/**
	 * Metodo de tipo boolean que retorna la prioridad de una Moto frente a una Moto. Devuelve siempre false. <br>
	 */
	public boolean beatsMoto() {
		return false;
	}

	/**
	 * Metodo de tipo boolean que retorna la prioridad de una Moto frente a un Automovil. Devuelve siempre true. <br>
	 */
	public boolean beatsAutomovil() {
		return true;
	}

	/**
	 * Metodo de tipo boolean que retorna la prioridad de una Moto frente a una Combi. Devuelve siempre true. <br>
	 */
	public boolean beatsCombi() {
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " \t Moto ";
	}

}
