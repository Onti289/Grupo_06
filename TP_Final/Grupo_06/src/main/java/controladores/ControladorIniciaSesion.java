package controladores;

import java.awt.event.ActionEvent;

import excepciones.NombreDeUsuarioYaExistenteException;
import modelo.*;
import vista.IVista;
import vista.Ventana_Chofer1;
import vista.Ventana_Cliente1;
import vista.Ventana_CrearPedido;
import vista.Ventana_General;

public class ControladorIniciaSesion extends Controlador {

	public ControladorIniciaSesion(Sistema modelo, IVista vista)
	{
		super(modelo, vista);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(IVista.CREARUSUARIO))
	    {
			if (this.modelo.existeNombreUsuario(this.modelo.getAdmin(), this.vista.getNuevoNomUsua()))
		    	  this.vista.setTextMsjCrea("Nombre de usuario ya existente");
		    else
		    {
		      ClienteAbstracto c = new ClienteHumano(this.vista.getNuevoNomUsua(), this.vista.getNuevaContr(), this.vista.getNombreReal());
		      try
		      {
				this.modelo.agregaCliente(this.modelo.getAdmin(), c);
			  } catch (NombreDeUsuarioYaExistenteException e1) {
				// no va a entrar nunca
			  }
		      this.vista.setTextMsjCrea("Usuario creado exitosamente");
		    //guardar con persistencia
		      this.vista.borraRegistrarse();
		    }
			
			
	    }
		else  if (e.getActionCommand().equals(IVista.INICIARSESION))
	    {
	       if (!this.modelo.existeNombreUsuario(this.modelo.getAdmin(), this.vista.getNomUsua()))
	    	  this.vista.setTextMsjInicSes("Nombre de usuario no existente");
	       else
	         if (!this.modelo.contraseniaCorrecta(this.modelo.getAdmin(), this.vista.getNomUsua(), this.vista.getContr()))
	        	 this.vista.setTextMsjInicSes("Contraseña incorrecta");
	         else
	         {
	        	ClienteAbstracto cliente = this.modelo.getCliente(this.modelo.getAdmin(), this.vista.getNomUsua());
	        	this.modelo.setClienteHumano(this.modelo.getAdmin(), cliente);
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
	        
	        
			//verificar contraseña y mensaje
			
	    }

	}

}
