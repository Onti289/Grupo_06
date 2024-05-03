package clases;

public class Combi extends Vehiculo {

    public Combi(String patente, boolean baul, boolean petFriendly, int maxPasajeros) {
        super(patente, baul, petFriendly, maxPasajeros);
        // TODO Auto-generated constructor stub
    }

	public boolean beats(IVehiculo o) {
		return o.beatsCombi();
	}

	public boolean beatsMoto() {
		return false;
	}

	public boolean beatsAutomovil() {
		return false;
	}

	public boolean beatsCombi() {
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + " \t Combi \n";
	}

}
