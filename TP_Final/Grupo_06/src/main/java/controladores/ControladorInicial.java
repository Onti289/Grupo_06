package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.*;
import vista.*;

public class ControladorInicial extends Controlador{



    public ControladorInicial(Modelo modelo, IVista vista)
    {
        super(modelo, vista);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(IVista.SI))
        {
            this.vista.hayHumano();
            this.modelo.setHayHumano(true);
        }
        else if (e.getActionCommand().equals(IVista.NO))
        {
            this.vista.noHumano();
            this.modelo.setHayHumano(false);
        }
        else if (e.getActionCommand().equals(IVista.NUEVASIM))
        {
            this.modelo.setNuevaSim(true);
            this.vista.setVisible(false);
            
            IVista vSimulacion = new Ventana_Simulacion();
            Controlador cSimulacion = new ControladorNuevaSim(this.modelo, vSimulacion);
            vSimulacion.setControlador(cSimulacion);
            vSimulacion.arranca();
            
        }
        else if (e.getActionCommand().equals(IVista.CARGAULT))
        {
            this.modelo.setNuevaSim(false);
            this.vista.setVisible(false);
            
            //levantar datos persistidos
            
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