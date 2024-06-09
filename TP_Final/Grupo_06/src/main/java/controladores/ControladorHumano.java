package controladores;

import java.awt.event.ActionEvent;

import modelo.Modelo;
import vista.IVista;

public class ControladorHumano extends Controlador {

	public ControladorHumano(Modelo modelo, IVista vista)
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
			//incia ventana general y crea pedido (desde main)
	    }

	}

}
