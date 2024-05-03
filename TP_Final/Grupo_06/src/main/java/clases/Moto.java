package clases;

public class Moto extends Vehiculo {

    public Moto(String patente, boolean baul, boolean petFriendly, int maxPasajeros) {
        super(patente, baul, petFriendly, maxPasajeros);
    }

	public boolean beats(IVehiculo o) {
		return o.beatsMoto();
	}

	public boolean beatsMoto() {
		return false;
	}

	public boolean beatsAutomovil() {
		return true;
	}

	public boolean beatsCombi() {
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " \t Moto \n";
	}

}
