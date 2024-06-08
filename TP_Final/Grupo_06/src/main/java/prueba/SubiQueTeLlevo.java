package prueba;

import modelo.*;
import controladores.*;
import vista.*;
import clases.*;
import excepciones.*;

public class SubiQueTeLlevo {

	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		IVista vistaInicial = new Ventana_Inicial();
		Controlador control = new ControladorInicial(modelo, vistaInicial);

		vistaInicial.setControlador(control);
		vistaInicial.arranca();

	}

}
