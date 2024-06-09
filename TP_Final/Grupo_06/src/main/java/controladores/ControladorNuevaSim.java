package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.*;
import vista.*;

public class ControladorNuevaSim extends Controlador{

    public ControladorNuevaSim(Sistema modelo, IVista vista) {
        super(modelo, vista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(IVista.INICIASIM))
        {
        	this.modelo.persistir();
        	this.vista.setVisible(false);
        	if (modelo.isHayHumano())
            {
              IVista vHumano = new Ventana_IniciaSesion();
              Controlador cHumano = new ControladorIniciaSesion(modelo, vHumano);
              vHumano.setControlador(cHumano);
              vHumano.arranca(); 
            }
        	else
        	{
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
        	}
        }
    }

}