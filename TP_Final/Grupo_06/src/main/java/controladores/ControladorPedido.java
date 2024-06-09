package controladores;

import java.awt.event.ActionEvent;

import modelo.Modelo;
import vista.IVista;

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
        }

	}

}
