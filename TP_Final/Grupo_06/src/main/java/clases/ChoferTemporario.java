package clases;

public class ChoferTemporario extends Chofer {
    private double sueldoBasico;
    private int aportes;
    private int cantViajes;

    public ChoferTemporario(String dNI, String nombre, double sueldoBasico, int aportes) {
        super(dNI, nombre);
        this.sueldoBasico = sueldoBasico;
        this.aportes = aportes;
        this.cantViajes = 0;
    }

    public double getSueldoBruto() {
        if (this.cantViajes > 40)
            return this.sueldoBasico*1.1;
        return this.sueldoBasico;
    }

    public double getSueldoNeto() {
        return this.getSueldoBruto()*(1-this.aportes/100.0);
    }

    public int getCantViajes() {
		return this.cantViajes;
	}

	public void sumaViaje() {
		this.cantViajes += 1;
	}

	@Override
    public double calculaSueldo()
    {
        return this.getSueldoNeto();
    }

	@Override
	public String toString() {

		return super.toString() + " Temporario \t" + String.valueOf(this.calculaSueldo()) + "\n";
	}

}
