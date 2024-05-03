package clases;
import java.util.Objects;

public abstract class Vehiculo implements IVehiculo {
    private String patente;
    private boolean baul;
    private boolean petFriendly;
    private int maxPasajeros;

    public Vehiculo(String patente, boolean baul, boolean petFriendly, int maxPasajeros) {
        super();
        this.patente = patente;
        this.baul = baul;
        this.petFriendly = petFriendly;
        this.maxPasajeros = maxPasajeros;
    }

	public int compareTo(Vehiculo otroVehiculo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getPatente() {
		return patente;
	}

	public boolean isBaul() {
		return baul;
	}

	public boolean isPetFriendly() {
		return petFriendly;
	}

	public int getMaxPasajeros() {
		return maxPasajeros;
	}


	public void setPatente(String patente) {
		this.patente = patente;
	}

	public boolean cumpleCondicion(Pedido p) {
		return
			this.isBaul() == p.isEquipaje() &&
			this.isPetFriendly() == p.isMascotas() &&
			this.getMaxPasajeros() >= p.getCantidadPasajeros();
	}

	@Override
	public String toString() {
		return this.getPatente();
	}
	@Override
    public boolean equals(Object o) {
        if (this == o)
        	return true;
        if (o == null || getClass() != o.getClass())
        	return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(patente, vehiculo.patente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patente);
    }

}
