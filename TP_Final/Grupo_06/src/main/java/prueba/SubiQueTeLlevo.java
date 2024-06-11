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
    	
    	
    	Sistema sistema = Sistema._getInstancia();
    	sistema.despersistir();
        vGeneral = new Ventana_Inicial();
        Controlador cGeneral = new ControladorInicial(sistema, vGeneral);
        
        vGeneral.setControlador(cGeneral);
        vGeneral.arranca();
        
        
        
        
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}