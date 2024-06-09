package prueba;

import modelo.*;
import controladores.*;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clases.*;
import excepciones.*;

public class SubiQueTeLlevo implements ActionListener{

    public static void main(String[] args) throws InterruptedException{
        Modelo modelo = new Modelo();
        IVista vGeneral = new Ventana_Inicial();
        Controlador cGeneral = new ControladorInicial(modelo, vGeneral);
        IVista vHumano = null;
        Controlador cHumano = null;
        IVista vCliente1 = null;
        Controlador cCliente1 = null;
        IVista vChofer1 = null;
        Controlador cChofer1 = null;

        vGeneral.setControlador(cGeneral);
        vGeneral.arranca();
        while (vGeneral.isVisible()) {


            Thread.sleep(500);


        }
        if (modelo.isNuevaSim())
        {
          vGeneral = new Ventana_Simulacion();
          cGeneral = new ControladorNuevaSim(modelo, vGeneral);
          vGeneral.setControlador(cGeneral);
          vGeneral.arranca();
          while (vGeneral.isVisible()) {
          
              Thread.sleep(500);

          }
        }

        if (modelo.isHayHumano())
        {
          vHumano = new Ventana_IniciaSesion();
          cHumano = new ControladorHumano(modelo, vHumano);
          vHumano.setControlador(cHumano);
          vHumano.arranca();
          while (vHumano.isVisible()) {

              Thread.sleep(500);

          }
          
        }
        vGeneral = new Ventana_General();
        cGeneral = new ControladorGeneral(modelo, vGeneral);
        vGeneral.setControlador(cGeneral);
        vGeneral.arranca();
        
        vCliente1 = new Ventana_VistaCliente1();
        cCliente1 = new ControladorCliente1(modelo, vCliente1);
        vCliente1.setControlador(cCliente1);
        vCliente1.arranca();
        
        vGeneral = new Ventana_General();
        cGeneral = new ControladorGeneral(modelo, vGeneral);
        vGeneral.setControlador(cGeneral);
        vGeneral.arranca();
        
        while(modelo.isHayHumano() )//&& hay choferes && tengo viajes disponibles (random v_simu)
        {
        	vHumano = new Ventana_CrearPedido();
            cHumano = new ControladorPedido(modelo, vHumano);
            vHumano.setControlador(cHumano);
            vHumano.arranca();
            while (vHumano.isVisible()) {

                Thread.sleep(500);

            }
            vHumano = new Ventana_ClienteHumanoEnViaje();
            cHumano = new ControladorHumanoViaje(modelo, vHumano);
            vHumano.setControlador(cHumano);
            vHumano.arranca();
            while (vHumano.isVisible()) {
            
                Thread.sleep(500);
                
            }
        }
        
        
        
// arreglar
  /*    vista.dispose();
      if (v_humano != null)
        v_humano.dispose();
        */
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}