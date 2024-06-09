package controladores;

import java.awt.event.ActionEvent;

import modelo.Modelo;
import vista.IVista;
import vista.Ventana_Chofer1;
import vista.Ventana_Cliente1;
import vista.Ventana_CrearPedido;
import vista.Ventana_General;

public class ControladorIniciaSesion extends Controlador {

	public ControladorIniciaSesion(Modelo modelo, IVista vista)
	{
		super(modelo, vista);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(IVista.CREARUSUARIO))
	    {
	        //if (!existe nombre usuario) usar hashmap
			//mensaje si se creo o no
			//guardar con persistencia
			//borrar campos
			
	    }
		else  if (e.getActionCommand().equals(IVista.INICIARSESION))
	    {
	        //verificar nombre de usuario y mensaje
			//verificar contraseña y mensaje
			this.vista.setVisible(false);
			IVista vGeneral = new Ventana_General();
    		Controlador cGeneral = new ControladorGeneral(modelo, vGeneral);
            vGeneral.setControlador(cGeneral);
            vGeneral.arranca();
            
            IVista vCliente1 = new Ventana_Cliente1();
            Controlador cCliente1 = new ControladorCliente1(modelo, vCliente1);
            vCliente1.setControlador(cCliente1);
            vCliente1.arranca();
            
            IVista vChofer1 = new Ventana_Chofer1();
            Controlador cChofer1 = new ControladorChofer1(modelo, vChofer1);
            vChofer1.setControlador(cChofer1);
            vChofer1.arranca();
			
            IVista vHumano = new Ventana_CrearPedido();
            Controlador cHumano = new ControladorPedido(modelo, vHumano);
            vHumano.setControlador(cHumano);
            vHumano.arranca();
	    }

	}

}
