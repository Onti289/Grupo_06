package modelo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author Grupo6
 *	Clase hija de Chofer que permite representar a los choferes permanentes de la empresa dentro del sistema. Este tipo de choferes reciben en su sueldo un plus por antiguedad y cantidadn de hijos, y tambien un descuento por aportes. <br>
 */
public class ChoferPermanente extends Chofer {
    private double sueldobasico;
    private int antiguedad;
    private int cantHijos;
    private int aportes;
    private int anioIngreso;

    /**
     * Constructor de la clase ChoferPermanente que permite instanciar un nuevo chofer de este tipo. Se debe conocer, ademas de sus datos personales, el sueldo basico, la fecha de ingreso, 
     * la cantidad de hijos y el porcentaje de aportes del mismo. La antiguedad se calcula en base a su fecha de ingreso. <br>
     * 
     * <b>Pre: </b> Valores de los parametros String distintos de null, el sueldo basico debe contener un valor mayor a cero, hijos debe tener un valor igual o amyor a cero, aportes debe ser un numero entre 0 y 100, la fecha de ingreso debe ser valida (no puede ser un dia posterior al actual). <br>
     * <b>Post: </b> Se crea un nuevo ChoferPermanente en el sistema. <br>
     * 
     * El metodo ChronoUnit.YEARS.between(fecha1,fecha2) permite obtener los años de diferencia entre las fechas 1 y 2. En este caso, se utiliza LocalDateTime.now() para obtener la fecha de hoy y asi comparar con la fecha de ingreso para obtener los años de antiguedad del chofer.  
     * 
     * @param DNI Parametro de tipo String que contiene el documento del chofer. <br>
     * @param nombre Parametro de tipo String que contiene el nombre del chofer. <br>
     * @param sueldobasico Parametro de tipo double que contiene el sueldo basico del chofer. <br>
     * @param antiguedad Parametro de tipo int que contiene la antiguedad del chofer en base a su fecha de ingreso a la empresa. <br>
     * @param hijos Parametro de tipo int que contiene la cantidad de hijos del chofer. <br>
     * @param aportes Parametro de tipo int que contiene un valor entre 0 y 100 que representa el porcentaje de aportes del chofer. <br>
     * @param anioIngreso Parametro de tipo int que representa el anio de ingreso del chofer a la empresa. <br>
     */
    public ChoferPermanente(String dni, String nombre, double sueldobasico, int hijos, int aportes, int anioIngreso) {
        super(dni, nombre);
        LocalDateTime fechaActual = LocalDateTime.now();
        this.sueldobasico = sueldobasico;
        this.antiguedad = fechaActual.getYear() - anioIngreso;
        this.cantHijos = hijos;
        this.aportes = aportes;
        this.anioIngreso = anioIngreso;
    }

    
    
    public ChoferPermanente() {
		super();
	}



	public double getSueldobasico() {
		return sueldobasico;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public int getCantHijos() {
		return cantHijos;
	}

	public int getAportes() {
		return aportes;
	}

	public int getAnioIngreso() {
		return anioIngreso;
	}

	public void setSueldobasico(double sueldobasico) {
		this.sueldobasico = sueldobasico;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public void setCantHijos(int cantHijos) {
		this.cantHijos = cantHijos;
	}

	public void setAportes(int aportes) {
		this.aportes = aportes;
	}

	public void setAnioIngreso(int anioIngreso) {
		this.anioIngreso = anioIngreso;
	}

	/**
     * Metodo de tipo double que devuelve el sueldo bruto del chofer en base al sueldo basico, aplicandole al mismo los correspondientes plus por antiguedad y cantidad de hijos. <br>
     * 
     * @return this.sueldobasico*(1.0 + this.antiguedad/100.0 + this.cantHijos/100.0): parametro de tipo double que contiene el valor del sueldo bruto. <br>
     */
    public double getSueldoBruto() {
        return this.sueldobasico*(1.0 + this.antiguedad/100.0 + this.cantHijos/100.0);
    }


    /**
     * Metodo de tipo double que devuelve el sueldo neto del chofer en base a su sueldo bruto, aplicandole al mismo los descuentos correspondientes por aportes. <br>
     * 
     * @return this.getSueldoBruto()*( 1.0 - this.aportes/100.0): parametro de tipo double que contiene el valor del sueldo neto. <br>
     */
    public double getSueldoNeto() {
        return this.getSueldoBruto()*( 1.0 - this.aportes/100.0);
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
     *  Metodo que devuelve String con nombre del chofer, tipo y sueldo para poder listar los diferentes choferes del sistema. <br>
     */
    @Override
	public String toString() {

		return super.toString() + " Permanente \t$" + String.format("%.2f",this.calculaSueldo());
	}


	@Override
	public String getTipo() {
		return "Permanente";
	}
}
