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
			
			
			
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		if (observado != o)
			throw new IllegalArgumentException();
		Administrador a = observado.getAdmin();
		try
		{
			observado.generaViaje(a, observado.sacarPedido(a));
		}
		catch (NoHayChoferesDisponiblesException | NoHayVehiculoException e)
		{
			e.printStackTrace();
		}
		
	}

}
