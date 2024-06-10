package modelo;
import java.util.Objects;

/**
 * @author gc
 * <br>
 * Clase abstracta que representa a los choferes pertenecientes al sistema. Existen tres tipos de choferes: Chofer Contratado, Chofer Permanente y CHofer Temporario. <br>
 *
 */
public abstract class Chofer extends Thread{
    private String DNI;
    private String nombre;
    private int puntos;
    private int viajesMes;
    private double KMrecorridosMes;
    private static int cantMaxViajes;
	private Sistema sistema;

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
        this.sistema = sistema;
    }

    
    
    public Chofer() {
		super();
	}

    public void setCantMaxViajesChofer(int num)
    {
    	cantMaxViajes = num;
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
    
    public abstract String getTipo();

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
	
	public void setViajesMes(int viajesMes) {
		this.viajesMes = viajesMes;
	}

	public void setKMrecorridosMes(double kMrecorridosMes) {
		KMrecorridosMes = kMrecorridosMes;
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

    public void modificaChofer(String nombre) {
        this.nombre = nombre;
    }

	/**
	 * Metodo que devuelve String con nombre del chofer para poder listarlos. <br>
	 */
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

    public void iniciaViaje()
    {
      IViaje viaje = sistema.sacarViaje(sistema.getAdmin());
      
      viaje.setEstado("Iniciado");
      
    }
    
	/**
	 * Metodo de tipo void que permite setear el estado del viaje en "Finalizado", ademas de sumar los kilometros recorridos y suma un viaje al chofer que lo realizo. <br>
	 * 
	 * <b>Pre: </b> parametro viaje distinto de null. <br>
	 * 
	 * @param viaje Parametro de tipo IViaje al cual se le modificara su estado a "Finalizado". <br>
	 */
	public void finalizaViaje(IViaje viaje){
		if (viaje.getEstado().equalsIgnoreCase("Pagado"))
		{
		  viaje.setEstado("Finalizado");
		  this.sumaKMrecorridosMes(viaje.getKM());
		  this.sumaViajesMes();
		}
		
	}
	
	


}
