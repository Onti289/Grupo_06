package clases;

public class Automovil extends Vehiculo {

    public Automovil(String patente, boolean baul, boolean petFriendly, int maxPasajeros) {
        super(patente, baul, petFriendly, maxPasajeros);
        // TODO Auto-generated constructor stub
    }


	public boolean beats(IVehiculo o) {
		return o.beatsAutomovil();
	}

	public boolean beatsMoto() {
		return false;
	}

	public boolean beatsAutomovil() {
		return false;
	}

	public boolean beatsCombi() {
		return true;
	}


	@Override
	public String toString() {
		return super.toString() + " \t Automovil \n";
	}



}
