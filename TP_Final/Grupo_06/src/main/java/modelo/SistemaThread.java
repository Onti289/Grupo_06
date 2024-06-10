package modelo;

import java.util.Observable;
import java.util.Observer;

import excepciones.NoHayChoferesDisponiblesException;
import excepciones.NoHayVehiculoException;

public class SistemaThread extends Thread implements Observer {
	Sistema observado;

	public SistemaThread(Sistema sistema) {
		observado = sistema;
		observado.addObserver(this);
	}

	@Override
	public void run() {
		while (Sistema.getCantChoferes() > 0 && Sistema.getCantClientes() > 0)
		{			
			
			Administrador a = observado.getAdmin();
			
			
			Pedido p = (Pedido) arg;
			ViajeFactory viajeFactory = new ViajeFactory();
			IViaje viaje = viajeFactory.getViaje(p, null, a.sacarVehiculo(p));
			a.agregarViaje(viaje);
			
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		if (observado != o)
			throw new IllegalArgumentException();
		
		
	}

}
