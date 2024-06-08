package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.*;
import vista.*;

public class ControladorNuevaSim extends Controlador{

    public ControladorNuevaSim(Modelo modelo, IVista vista) {
        super(modelo, vista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(IVista.INICIASIM))
        {
        	this.vista.dispose();
        }
    }

}