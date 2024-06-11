package controladores;

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
    	int tope;
    	
    	new SistemaThread(modelo).start();
    	
    	for (i = 1; i <= Chofer.CANTCONTRATADOS; i++)
      	  modelo.agregaChofer(Sistema.getAdmin(), new ChoferContratado(""+i*1000, "Chofer"+i, i*500, modelo));
    	i = Chofer.CANTCONTRATADOS + 1;
    	if (Chofer.CANTCONTRATADOS == 0)
    	  tope = Chofer.CANTPERMANENTES;
    	else
    		tope = i + Chofer.CANTPERMANENTES - 1;
      	for (; i <= tope; i++)
      	  modelo.agregaChofer(Sistema.getAdmin(), new ChoferPermanente(""+i*1000, "Chofer"+i, 5000, 1, 1, 1, modelo));
      	if (Chofer.CANTCONTRATADOS == 0)
      	{
      		i = Chofer.CANTPERMANENTES + 1;
      		if(Chofer.CANTPERMANENTES == 0)
    	      tope = Chofer.CANTTEMPORARIOS;
      		else
      		  tope = i + Chofer.CANTTEMPORARIOS - 1;
    	}
    	else
    	{
      		i = tope + 1;
      		tope = i + Chofer.CANTTEMPORARIOS - 1;
    	}
      	for (; i <= tope; i++)
      	  modelo.agregaChofer(Sistema.getAdmin(), new ChoferTemporario(""+i*1000, "Chofer"+i, 5000, 1, modelo));
    	
    	
    	for (i = 1; i <= Cliente.CANTCLIENTESDISPONIBLES; i++)
    	{
    	  try {
			modelo.agregaCliente(Sistema.getAdmin(), new Cliente("Cliente"+i, "111","Cliente", modelo));
		  } catch (NombreDeUsuarioYaExistenteException e) {
		  //no entra nunca
		  }
    	}
    	
    	
    	VehiculoFactory vehiculoFactory = new VehiculoFactory();
    	
    	for (i = 1; i <= this.vista.getVar_CantAutos(); i++)
    	{
    		Vehiculo vehiculo = vehiculoFactory.crear("Automovil", "ABC"+i*100);
    		modelo.agregaVehiculoADisponibles(Sistema.getAdmin(), vehiculo);
    		modelo.agregaVehiculoATotal(Sistema.getAdmin(), vehiculo);
    	}
    	for (i = 1; i <= this.vista.getVar_CantMotos(); i++)
    	{
    		Vehiculo vehiculo = vehiculoFactory.crear("Moto", "DEF"+i*100);
    		modelo.agregaVehiculoADisponibles(Sistema.getAdmin(), vehiculo);
    		modelo.agregaVehiculoATotal(Sistema.getAdmin(), vehiculo);
    	}
    	for (i = 1; i <= this.vista.getVar_CantCombis(); i++)
    	{
    		Vehiculo vehiculo = vehiculoFactory.crear("Combi", "GHI"+i*100);
    		modelo.agregaVehiculoADisponibles(Sistema.getAdmin(), vehiculo);
    		modelo.agregaVehiculoATotal(Sistema.getAdmin(), vehiculo);
    	}

    	modelo.persistir();
    	
    	for (i = 0; i < Sistema.getAdmin().getColaChoferes().size(); i++)
    	{
    		System.out.println("\n\n"+Sistema.getAdmin().getColaChoferes().get(i).getNombre()+Sistema.getAdmin().getColaChoferes().get(i).getTipo()+"\n\n");
    		new Thread((Runnable) Sistema.getAdmin().getColaChoferes().get(i)).start();
    		}
    	for (i = 0; i < Sistema.getAdmin().getListaClientesRobot().size(); i++)
    	{
    		new Thread((Runnable) Sistema.getAdmin().getListaClientesRobot().get(i)).start();
    	}
    	
    }
    
}