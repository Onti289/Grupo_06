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
        IVista vista = new Ventana_Inicial();
        Controlador control = new ControladorInicial(modelo, vista);
        IVista v_humano = null;
        Controlador controlHum = null;

        vista.setControlador(control);
        vista.arranca();
        while (vista.isVisible()) {


            Thread.sleep(500);


        }
        if (modelo.isNuevaSim())
        {
          vista = new Ventana_Simulacion();
          control = new ControladorNuevaSim(modelo, vista);
          vista.setControlador(control);
          vista.arranca();
          while (vista.isVisible()) {
          
              Thread.sleep(500);

          }
        }

        if (modelo.isHayHumano())
        {
          v_humano = new Ventana_Humano();
          controlHum = new ControladorHumano(modelo, v_humano);
          v_humano.setControlador(controlHum);
          v_humano.arranca();
          while (v_humano.isVisible()) {

              Thread.sleep(500);

          }
          
        }
       /* vista = new Ventana_General();
        control = new ControladorGeneral(modelo, vista);
        vista.setControlador(control);
        vista.arranca();*/
        
        while(modelo.isHayHumano() )//&& hay choferes && tengo viajes disponibles (random v_simu)
        {
        	v_humano = new Ventana_CrearPedido();
            controlHum = new ControladorPedido(modelo, v_humano);
            v_humano.setControlador(controlHum);
            v_humano.arranca();
            while (v_humano.isVisible()) {

                Thread.sleep(500);

            }
            v_humano = new Ventana_Cliente_HumanoEnViaje();
            controlHum = new ControladorHumanoViaje(modelo, v_humano);
            v_humano.setControlador(controlHum);
            v_humano.arranca();
            while (v_humano.isVisible()) {
            
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