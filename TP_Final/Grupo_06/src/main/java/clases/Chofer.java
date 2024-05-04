package clases;
import java.util.Objects;

import excepciones.NoHayPlataException;
/**
 * @author gc
 * <br>
 * Clase abstracta que representa a los choferes pertenecientes al sistema. Existen tres tipos de choferes: Chofer Contratado, Chofer Permanente y CHofer Temporario. <br>
 *
 */
public abstract class Chofer {
    private String DNI;
    private String nombre;
    private int puntos;
    private int viajesMes;
    private double KMrecorridosMes;

    /**
     * Constructor con dos parametros para setear el documento y el nombre del nuevo chofer perteneciente al sistema. <br>
     *
     * @param DNI parametro de tipo String que contiene el DNI del nuevo chofer. <br>
     * @param nombre parametro de tipo String que contiene el nombre del nuevo chofer. <br>
     *
     * Los parametros de puntos, viajesMes y KMrecorridos se setean en cero al agregar al nuevo chofer. <br>
     */
    public Chofer(String DNI, String nombre) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.puntos = 0;
        this.viajesMes = 0;
        this.KMrecorridosMes = 0.0;
    }

    public String getDNI() {
        return DNI;
    }
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo abstracto de tipo double que retorna el sueldo del Chofer, el cual depende del tipo del mismo.
     *
     */
    public abstract double calculaSueldo();

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos += puntos;
	}

	public int getViajesMes() {
		return viajesMes;
	}

	public void setViajesMes() {
		this.viajesMes = 0;
	}

	public void sumaViajesMes() {
		this.viajesMes++;
	}

	public double getKMrecorridosMes() {
		return KMrecorridosMes;
	}

	public void setKMrecorridosMes() {
		this.KMrecorridosMes = 0;
	}

    public void sumaKMrecorridosMes(double kilometros)
    {
    	this.KMrecorridosMes += kilometros;
    }

    public void modificaChofer(String DNI, String nombre) {
    	this.DNI = DNI;
        this.nombre = nombre;
    }

	@Override
	public String toString() {
		return nombre + " \t";
	}
	@Override
    public boolean equals(Object o) {
        if (this == o)
        	return true;
        if (o == null || getClass() != o.getClass())
        	return false;
        Chofer chofer = (Chofer) o;
        return Objects.equals(DNI, chofer.DNI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DNI);
    }

	public void finalizaViaje(IViaje viaje) throws NoHayPlataException{
		if (viaje.getEstado().equalsIgnoreCase("Pagado"))
		{
		  viaje.setEstado("Finalizado");
		  this.sumaKMrecorridosMes(viaje.getKM());
		  this.sumaViajesMes();
		}
		else
		  throw new NoHayPlataException("El cliente es un rata, no me pago");
	}


}
