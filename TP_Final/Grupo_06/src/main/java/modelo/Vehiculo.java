package modelo;
import java.util.Objects;

/**
 * @author Grupo6
 * Clase abstracta que implementa la interfaz IVehiculo que representa las funcionalidades comunes con las que cuentan los tres tipos de vehiculos que ofrece la empresa (Automovil, Moto, Combi). <br>
 *
 */
public abstract class Vehiculo implements IVehiculo {
    private String patente;
    private boolean baul;
    private boolean petFriendly;
    private int maxPasajeros;

    /**
     * Constructor que permite crear un nuevo vehiculo. Dispone de las caracteristicas comunes entre los tres tipos, las cuales seran seteadas dependiendo 
     * del tipo de vehiculo que busque representarse. <br>
     *  
  	 *  <b>Pre: </b> Valor de String patente distinto de null y con formato valido de patente (AA-111-AA o AAA-111), maxPasajeros con valor 1, 4 u 8 dependiendo del tipo de vehiculo. <br>
     * 	<b>Post: </b> Se crea un nuevo Vehiculo en el sistema. <br>
     *
     *  
     * @param patente Parametro de tipo String que representa la patente del vehiculo. <br>
     * @param baul Parametro de tipo boolean que indica si el vehiculo ofrece baul (true) o no (false). <br>
     * @param petFriendly Parametro de tipo boolean que indica si el vehiculo es pet Friendly (true) o no (false). <br>
     * @param maxPasajeros Parametro de tipo int que indica la cantidad maxima de pasajeros que puede llevar el vehiculo. <br>
     */
    public Vehiculo(String patente, boolean baul, boolean petFriendly, int maxPasajeros) {
        super();
        this.patente = patente;
        this.baul = baul;
        this.petFriendly = petFriendly;
        this.maxPasajeros = maxPasajeros;
    }
    
    
    

	public Vehiculo() {
		super();
	}




	public void setBaul(boolean baul) {
		this.baul = baul;
	}



	public void setPetFriendly(boolean petFriendly) {
		this.petFriendly = petFriendly;
	}



	public void setMaxPasajeros(int maxPasajeros) {
		this.maxPasajeros = maxPasajeros;
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
	
	public String getTipo() {
		return null;
	}

	/**
	 * Metodo de tipo boolean que permite saber si un vehiculo cumple con las condiciones de un determinado pedido. <br>
	 * 
	 * @param p Parametro de tipo Pedido que contiene las condiciones que debe cumplir el vehiculo para satisfacerlo. <br>
	 * @return true en caso de que el vehiculo satisfaga las condiciones y false en caso contrario. <br>
	 */
	public boolean cumpleCondicion(Pedido p) {
			if(this.getMaxPasajeros() < p.getCantidadPasajeros())
				return false;
			if (p.isEquipaje() == true && this.isBaul() == false)
				return false;
			if (p.isMascotas() == true && this.isPetFriendly() == false)
				return false;
			return true;
			
	}

	/**
	 * Metodo sobreescrito que devuelve un String con la patente del vehiculo. <br>
	 */
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
