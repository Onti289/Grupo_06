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
        System.out.println(vista.isActive());
        while (vista.isActive()) {


            Thread.sleep(1000);


        }
        System.out.println("Sale while");
        if (modelo.isNuevaSim())
        {
            System.out.println("Entra if 1");vista = new Ventana_Simulacion();
          control = new ControladorNuevaSim(modelo, vista);
          vista.setControlador(control);
          vista.arranca();

        }

        if (modelo.isHayHumano()) //completar
        {
            System.out.println("Entra if 2"); Ventana_Humano v_humano = new Ventana_Humano();
          //Controlador controlHum = new ControladorHumano(modelo, v_humano);
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}