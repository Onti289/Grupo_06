package modelo;

/**
 * @author Grupo6
 *	Clase hija de Chofer que permite representar a los choferes contratados de la empresa dentro del sistema. Este tipo de choferes reciben en su sueldo un plus por antiguedad y cantidadn de hijos, y tambien un descuento por aportes. <br>
 */
public class ChoferContratado extends Chofer {
    private int gananciaViaje;

    /**
     * Constructor de la clase ChoferContratado que permite instanciar un nuevo chofer de este tipo. Se debe conocer, ademas de sus datos personales, el porcentaje de ganancia que le corresponde por cada viaje realizado. <br>
     * 
     * <b>Pre: </b> Valores de los parametros String distintos de null, gananciaViaje debe ser un numero entre 0 y 100. <br>
     * <b>Post: </b> Se crea un nuevo ChoferContratado en el sistema. <br>
     * 
     * @param dni Parametro de tipo String que contiene el documento del chofer. <br>
     * @param nombre Parametro de tipo String que contiene el nombre del chofer. <br>
     * @param gananciaViaje Parametro de tipo int que contiene el porcentaje de ganancia del chofer por cada viaje realizado. <br>
     */
        
    public ChoferContratado(String dni, String nombre, int gananciaViaje, Sistema sistema) {
        super(dni, nombre, sistema);
        this.gananciaViaje = gananciaViaje;
    }
    
    
    

    public ChoferContratado() {
		super();
	}




	public int getGananciaViaje() {
		return gananciaViaje;
	}



	public void setGananciaViaje(int gananciaViaje) {
		this.gananciaViaje = gananciaViaje;
	}



	/**
     * Metodo sobreescrito que permite obtener el porcentaje de ganancia del chofer. <br>
     */
    @Override
    public double calculaSueldo() {
        return this.gananciaViaje;
    }

    /**
     * Metodo que devuelve String con nombre del chofer, tipo y sueldo para poder listar los diferentes choferes del sistema. <br>
     */
    @Override
	public String toString() {

		return super.toString() + " Contratado \t%" + this.calculaSueldo();
	}

	@Override
	public String getTipo() {
		return "Contratado";
	}






}

