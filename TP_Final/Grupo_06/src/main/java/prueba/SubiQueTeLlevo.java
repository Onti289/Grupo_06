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

        if (modelo.isHayHumano()) //completar
        {
          IVista v_humano = new Ventana_Humano();
          Controlador controlHum = new ControladorHumano(modelo, v_humano);
          v_humano.setControlador(controlHum);
          v_humano.arranca();
          while (vista.isVisible()) {

        	  System.out.println("isHayHumano");
              Thread.sleep(500);


          }
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}