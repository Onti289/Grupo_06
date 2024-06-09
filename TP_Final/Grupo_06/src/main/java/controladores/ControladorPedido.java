package controladores;

import java.awt.event.ActionEvent;
import java.time.LocalDateTime;

import excepciones.NoHayChoferesDisponiblesException;
import excepciones.NoHayVehiculoException;
import modelo.*;
import vista.IVista;
import vista.Ventana_ClienteHumanoEnViaje;

public class ControladorPedido extends Controlador {

	public ControladorPedido(Sistema modelo, IVista vista) {
		super(modelo, vista);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(IVista.ACEPTAR))
        {
        	LocalDateTime fecha = LocalDateTime.now();
        	String zona = this.vista.getZona();
        	boolean mascota = this.vista.isMascota();
        	boolean baul = this.vista.isBaul();
        	int cantPax = this.vista.getCantPax();
        	Cliente clienteHumano = this.modelo.getClienteHumano();
        	int km = (int) (100*Math.random());
			try {
				this.modelo.generaViaje(this.modelo.getAdmin(), new Pedido(fecha, zona, mascota, baul, cantPax, clienteHumano, km));
			}
			catch (NoHayChoferesDisponiblesException | NoHayVehiculoException e1)
			{
				e1.printStackTrace();
			}
			this.vista.setVisible(false);
			IVista vHumano = new Ventana_ClienteHumanoEnViaje();
            Controlador cHumano = new ControladorHumanoViaje(modelo, vHumano);
            vHumano.setControlador(cHumano);
            vHumano.arranca();
        }

	}

}
