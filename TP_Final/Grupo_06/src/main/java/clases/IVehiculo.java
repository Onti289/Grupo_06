package clases;

/**
 * @author Grupo6
 * Interfaz que establece el contrato a utilizar por las clases concretas de vehiculos (Automovil, Moto, Combi) para poder comparar los ordenes de prioridad entre las mismas. En este caso, esta clase se no modifica el costo del viaje. <br>
 */
public interface IVehiculo {
	public boolean beats(IVehiculo o);
	public boolean beatsMoto();
	public boolean beatsAutomovil();
	public boolean beatsCombi();
}
