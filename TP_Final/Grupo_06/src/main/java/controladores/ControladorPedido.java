package controladores;

import java.awt.event.ActionEvent;

import modelo.Modelo;
import vista.IVista;
import vista.Ventana_ClienteHumanoEnViaje;

public class ControladorPedido extends Controlador {

	public ControladorPedido(Modelo modelo, IVista vista) {
		super(modelo, vista);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(IVista.ACEPTAR))
        {
        	//CREA PEDIDO
			this.vista.setVisible(false);
			IVista vHumano = new Ventana_ClienteHumanoEnViaje();
            Controlador cHumano = new ControladorHumanoViaje(modelo, vHumano);
            vHumano.setControlador(cHumano);
            vHumano.arranca();
        }

	}

}
