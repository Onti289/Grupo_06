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

        vGeneral.setControlador(cGeneral);
        vGeneral.arranca();
        
        
        
        
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}