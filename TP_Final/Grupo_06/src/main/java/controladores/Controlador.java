package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.NombreDeUsuarioYaExistenteException;
import modelo.*;
import vista.*;

public abstract class Controlador  implements ActionListener//es un controlador generico
{
    protected IVista vista;
    protected Sistema modelo;

    public Controlador(Sistema modelo, IVista vista)
    {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void creaInstancias()
    {
    	int i;
    	int j;
    	for (i = 1; i <= Cliente.CANTCLIENTESDISPONIBLES; i++)
    	{
    	  try {
			modelo.agregaCliente(modelo.getAdmin(), new Cliente("Cliente"+i, "111","Cliente", modelo));
		  } catch (NombreDeUsuarioYaExistenteException e) {
		  //no entra nunca
		  }
    	}
    	for (i = 1; i <= Chofer.CANTCONTRATADOS; i++)
    	  modelo.agregaChofer(modelo.getAdmin(), new ChoferContratado(""+i*1000, "Chofer"+i, i*500));
    	for (j = i+1; j <= Chofer.CANTPERMANENTES + i; j++)
    	  modelo.agregaChofer(modelo.getAdmin(), new ChoferPermanente(""+j*1000, "Chofer"+j, 5000, 1, 1, 1));
    	for (i = j+1; i <= Chofer.CANTTEMPORARIOS + j; i++)
    	  modelo.agregaChofer(modelo.getAdmin(), new ChoferTemporario(""+i*1000, "Chofer"+i, 5000, 1));
    	
    	VehiculoFactory vehiculoFactory = new VehiculoFactory();
    	
    	for (i = 1; i <= this.vista.getVar_CantAutos(); i++)
    		modelo.agregaVehiculo(modelo.getAdmin(), vehiculoFactory.crear("Automovil", "ABC"+i*100));
    	for (i = 1; i <= this.vista.getVar_CantMotos(); i++)
    		modelo.agregaVehiculo(modelo.getAdmin(), vehiculoFactory.crear("Moto", "DEF"+i*100));
    	for (i = 1; i <= this.vista.getVar_CantCombis(); i++)
    		modelo.agregaVehiculo(modelo.getAdmin(), vehiculoFactory.crear("Combi", "GHI"+i*100));

    	modelo.persistir();
    }
    
}