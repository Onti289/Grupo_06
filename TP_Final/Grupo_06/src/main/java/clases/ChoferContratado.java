package clases;

public class ChoferContratado extends Chofer {
    private double gananciaViaje;

    public ChoferContratado(String dNI, String nombre, double gananciaViaje) {
        super(dNI, nombre);
        this.gananciaViaje = gananciaViaje;
    }

    @Override
    public double calculaSueldo() {
        return this.gananciaViaje;
    }

    @Override
	public String toString() {

		return super.toString() + " Contratado \t" + String.valueOf(this.calculaSueldo()) + "\n";
	}



}

