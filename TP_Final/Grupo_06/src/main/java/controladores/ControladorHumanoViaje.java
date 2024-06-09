package controladores;

import java.awt.event.ActionEvent;

import modelo.*;
import vista.IVista;
import vista.Ventana_CrearPedido;

public class ControladorHumanoViaje extends Controlador {

	public ControladorHumanoViaje(Sistema modelo, IVista vista) {
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
			/*if // hay choferes && tengo viajes disponibles (random v_simu)
	        {
			  IVista vHumano = new Ventana_CrearPedido();
              Controlador cHumano = new ControladorPedido(modelo, vHumano);
              vHumano.setControlador(cHumano);
              vHumano.arranca();
	        }*/
        }
		

	}

}
