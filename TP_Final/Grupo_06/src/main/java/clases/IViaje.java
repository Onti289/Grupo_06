package clases;

import java.time.LocalDateTime;

/**
 * @author Grupo6
 * Interfaz que establece el contrato a utilizar por las clases concretas de viajes (ZonaPeligrosa, Estandar, CalleSinAsfaltar) y sus respectivos decoradores (con o sin baul, con o sin mascota) 
 * para la correcta aplicacion del patron Decorator, con el fin de agregar funcionalidades de manera dinamica a los distintos tipos de viajes. <br>
 *
 */
public interface IViaje {
	int getPax();
	int getKM();
	double getCosto();
	Chofer getChofer();
	LocalDateTime getFecha();
	String getEstado();
	Cliente getCliente();
	void setEstado(String e);
	String toString();
	Vehiculo getVehiculo();
}
