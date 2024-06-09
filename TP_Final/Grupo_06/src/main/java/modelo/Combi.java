package modelo;

/**
 * @author Grupo_6
 * 
 * Clase hija de Vehiculo que representa a las combis dentro del sistema. Dentro de ella se define la prioridad con respcto a los demas tipos de vehiculos. <br>
 *
 */
public class Combi extends Vehiculo {

    public Combi(String patente, boolean baul, boolean petFriendly, int maxPasajeros) {
        super(patente, baul, petFriendly, maxPasajeros);
        // TODO Auto-generated constructor stub
    }

	/**
	 * Metodo de tipo boolean que permite saber la prioridad de una Combi contra cualquiera de los otros tipos de vehiculos. <br>
	 *
	 * IVehiculo o contiene la referencia al otro vehiculo que se comparara contra algun Automovil. <br>
	 */
	public boolean beats(IVehiculo o) {
		return o.beatsCombi();
	}

	/**
	 * Metodo de tipo boolean que retorna la prioridad de una Combi frente a una Moto. Devuelve siempre false. <br>
	 */
	public boolean beatsMoto() {
		return false;
	}

	/**
	 * Metodo de tipo boolean que retorna la prioridad de una Combi frente a un Automovil Devuelve siempre false. <br>
	 */
	public boolean beatsAutomovil() {
		return false;
	}

	/**
	 * Metodo de tipo boolean que retorna la prioridad de una Combi frente a una Combi. Devuelve siempre false. <br>
	 */
	public boolean beatsCombi() {
		return false;
	}

	@Override
	public String getTipo() {
		return "Combi";
	}
	
	@Override
	public String toString() {
		return super.toString() + " \t Combi ";
	}

}
