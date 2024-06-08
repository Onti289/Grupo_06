package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.*;
import vista.*;

public class ControladorInicial extends Controlador{

	private IVista vista;
	private Modelo modelo;
	
	public ControladorInicial(Modelo modelo, IVista vista)
	{
		super();
		this.modelo = modelo;
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
