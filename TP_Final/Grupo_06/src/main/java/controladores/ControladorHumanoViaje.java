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
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.vista.setVisible(false);
        }

	}

}
