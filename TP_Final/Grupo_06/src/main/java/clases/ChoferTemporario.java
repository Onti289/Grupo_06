package clases;

/**
 * @author Grupo6
 *	Clase hija de Chofer que permite representar a los choferes temporarios de la empresa dentro del sistema. Este tipo de choferes reciben en su sueldo un plus por cantidad de viajes luego de superar los 40 viajes, y tambien un descuento por aportes. <br>
 */
public class ChoferTemporario extends Chofer {
    private double sueldoBasico;
    private int aportes;
    private int cantViajes;

    /**
     * * Constructor de la clase ChoferTemporario que permite instanciar un nuevo chofer de este tipo. Se debe conocer, ademas de sus datos personales, el sueldo basico y el porcentaje de aportes. La cantidad de viajes se setea siempre en cero al instanciarse. <br>
     * 
     * <b>Pre: </b> Valores de los parametros String distintos de null, el sueldo basico debe contener un valor mayor a cero, aportes debe ser un numero entre 0 y 100. <br>
     * <b>Post: </b> Se crea un nuevo ChoferTemporario en el sistema. <br>
     * 
     * @param dni Parametro de tipo String que contiene el documento del chofer. <br>
     * @param nombre Parametro de tipo String que contiene el nombre del chofer. <br>
     * @param sueldoBasico Parametro de tipo double que contiene el valor del sueldo basico del chofer. <br>
     * @param aportes Parametro de tipo int que contiene un valor entre 0 y 100 que representa el porcentaje de aportes del chofer. <br> 
     */
    public ChoferTemporario(String dni, String nombre, double sueldoBasico, int aportes) {
        super(dni, nombre);
        this.sueldoBasico = sueldoBasico;
        this.aportes = aportes;
        this.cantViajes = 0;
    }

    /**
     * Metodo de tipo double que devuelve el sueldo bruto del chofer en base al sueldo basico, aplicandole al mismo el plus correspondiente por cantidad de viajes en caso de que supere los 40 viajes. <br>
     * 
     * @return parametro de tipo double que contiene el valor del sueldo bruto. <br>
     */
    public double getSueldoBruto() {
        if (this.cantViajes > 40)
            return this.sueldoBasico*1.1;
        return this.sueldoBasico;
    }

    /**
     * Metodo de tipo double que devuelve el sueldo neto del chofer en base a su sueldo bruto, aplicandole al mismo los descuentos correspondientes por aportes. <br>
     * 
     * @return this.getSueldoBruto()*( 1.0 - this.aportes/100.0): parametro de tipo double que contiene el valor del sueldo neto. <br>
     */
    public double getSueldoNeto() {
        return this.getSueldoBruto()*(1.0-this.aportes/100.0);
    }

    public int getCantViajes() {
		return this.cantViajes;
	}

	public void sumaViaje() {
		this.cantViajes += 1;
	}

	
	/**
     * Metodo de tipo double que devuelve el sueldo del chofer. <br>
     */
	@Override
    public double calculaSueldo()
    {
        return this.getSueldoNeto();
    }

	
	/**
     * Metodo que devuelve String con nombre del chofer, tipo y sueldo para poder listar los diferentes choferes del sistema. <br>
     */
	@Override
	public String toString() {

		return super.toString() + " Temporario \t$" + String.format("%.2f",this.calculaSueldo());
	}

	@Override
	public String getTipo() {
		return "Temporario";
	}

}
