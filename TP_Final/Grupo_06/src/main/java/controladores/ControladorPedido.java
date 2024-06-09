package controladores;

import java.awt.event.ActionEvent;
import java.time.LocalDateTime;

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
        	//CREA PEDIDO
			this.modelo.generaViaje(this.modelo.getAdmin(), new Pedido(LocalDateTime.now(), this.vista.getZona(), this.vista.isMascota(), this.vista.isBaul(), this.vista.getCantPax(), cliente, (int) 100*Math.random()));
			this.vista.setVisible(false);
			IVista vHumano = new Ventana_ClienteHumanoEnViaje();
            Controlador cHumano = new ControladorHumanoViaje(modelo, vHumano);
            vHumano.setControlador(cHumano);
            vHumano.arranca();
        }

	}

}
