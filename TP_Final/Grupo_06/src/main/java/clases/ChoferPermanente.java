package clases;

public class ChoferPermanente extends Chofer {
    private double sueldobasico;
    private int antiguedad;
    private int cantHijos;
    private int aportes;
    private String fechaIngreso;

    public ChoferPermanente(String dNI, String nombre, double sueldobasico, int antiguedad, int hijos, int aportes,
            String fechaIngreso) {
        super(dNI, nombre);
        this.sueldobasico = sueldobasico;
        this.antiguedad = antiguedad;
        this.cantHijos = hijos;
        this.aportes = aportes;
        this.fechaIngreso = fechaIngreso;
    }


    public double getSueldoBruto() {
        return this.sueldobasico*(1.0 + this.antiguedad/100.0 + this.cantHijos/100.0);
    }


    public double getSueldoNeto() {
        return this.getSueldoBruto()*( 1.0 - this.aportes/100.0);
    }

    @Override
    public double calculaSueldo()
    {
        return this.getSueldoNeto();
    }

    @Override
	public String toString() {

		return super.toString() + " Permanente \t" + String.valueOf(this.calculaSueldo()) + "\n";
	}
}
