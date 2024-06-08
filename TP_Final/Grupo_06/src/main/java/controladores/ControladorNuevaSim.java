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
            this.vista.dispose();
        }
        else if (e.getActionCommand().equals(IVista.SIMALEAT))
        {
            this.modelo.setNuevaSim(false);
            this.vista.dispose();
        }
    }

}