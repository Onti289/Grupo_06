package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.*;
import vista.*;

public abstract class Controlador  implements ActionListener//es un controlador generico
{
    protected IVista vista;
    protected Modelo modelo;

    public Controlador(Modelo modelo, IVista vista)
    {
        this.modelo = modelo;
        this.vista = vista;
    }

}