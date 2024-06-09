package controladores;

import java.awt.event.ActionEvent;

import modelo.Modelo;
import vista.IVista;

public class ControladorHumanoViaje extends Controlador {

	public ControladorHumanoViaje(Modelo modelo, IVista vista) {
		super(modelo, vista);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(IVista.PAGAR))
        {
        	//PAGA PEDIDO
			Thread.sleep(3000);
			this.vista.setVisible(false);
        }

	}

}
