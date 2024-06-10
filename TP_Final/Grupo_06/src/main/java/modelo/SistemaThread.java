package modelo;

import java.util.Observable;
import java.util.Observer;

import excepciones.NoHayChoferesDisponiblesException;
import excepciones.NoHayVehiculoException;

public class SistemaThread extends Thread implements Observer {
	Sistema observado;
	private boolean viajeNuevo = false;
	private IViaje viaje = null;

	public SistemaThread(Sistema sistema) {
		observado = sistema;
		observado.addObserver(this);
	}

	@Override
	public void run() {
		while (Chofer.CANTCHOFERESDISPONIBLES > 0 && ClienteAbstracto.CANTCLIENTESDISPONIBLES > 0)
		{
			if (viaje != null)
			{
			  this.viaje.setVehiculo(observado.sacarVehiculoDeDisponibles(this.viaje));
			  this.viaje = null;
			}
			
			
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		if (observado != o)
			throw new IllegalArgumentException();
		Administrador a = Sistema.getAdmin();
		
		
		this.viaje = (IViaje) arg;
		
		viajeNuevo = true;
		
	}

}
