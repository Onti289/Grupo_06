package prueba;

import modelo.*;
import controladores.*;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubiQueTeLlevo implements ActionListener{

    public static void main(String[] args) throws InterruptedException{
        IVista vGeneral = new Ventana_DeCarga();
        vGeneral.arranca();
        Thread.sleep(0);
        vGeneral.setVisible(false);
    	
    	
    	Sistema modelo = Sistema._getInstancia();
        vGeneral = new Ventana_Inicial();
        Controlador cGeneral = new ControladorInicial(modelo, vGeneral);

        vGeneral.setControlador(cGeneral);
        vGeneral.arranca();
        
        
        
        
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}