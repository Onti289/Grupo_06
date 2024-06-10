package modelo;

import java.util.Observable;
import java.util.Observer;

import excepciones.NoHayChoferesDisponiblesException;
import excepciones.NoHayVehiculoException;

public class SistemaThread extends Thread implements Observer {
	Sistema observado;
	private boolean viajeNuevo = false;

	public SistemaThread(Sistema sistema) {
		observado = sistema;
		observado.addObserver(this);
	}

	@Override
	public void run() {
		while (Sistema.getCantChoferes() > 0 && Sistema.getCantClientes() > 0)
		{			
			if (viajeNuevo)
			
			
			
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		if (observado != o)
			throw new IllegalArgumentException();
		Administrador a = observado.getAdmin();
		
		
		Pedido p = (Pedido) arg;
		ViajeFactory viajeFactory = new ViajeFactory();
		IViaje viaje = viajeFactory.getViaje(p, null, a.sacarVehiculo(p));
		observado.agregaViaje(viaje);
		viajeNuevo = true;
		
	}

}