package prueba;
import java.time.LocalDateTime;

import clases.*;
import excepciones.*;

public class Prueba {

	public static void main(String[] args) {
		Sistema sistema = Sistema._getInstancia();
		
		VehiculoFactory vehiculoFactory = new VehiculoFactory();
		
		Administrador admin = new Administrador("Admin", "Admin123", "Elad Ministrador");

		
		Cliente cliente1 = new Cliente("user1","abc123","Carlos");
		Cliente cliente2 = new Cliente("user2","41561","Juana");
		Cliente cliente3 = new Cliente("user3","abssda","Javier");
		
		Chofer chofer1 = new ChoferContratado("40569874", "Juancito", 30);
		Chofer chofer2 = new ChoferPermanente("23666987", "Juan Carlos", 80000, 10, 2, 1998);
		Chofer chofer3 = new ChoferTemporario("36998741", "Juan Cruz", 50000, 10);
		
		Vehiculo v1 = vehiculoFactory.crear("Automovil", "AD-123-CD");
		Vehiculo v2 = vehiculoFactory.crear("Automovil", "BC-122-AA");
		Vehiculo v3 = vehiculoFactory.crear("Combi", "OP-123-AD");
		Vehiculo v4 = vehiculoFactory.crear("Moto", "AA-111-BA");
		try
		{
		sistema.agregaCliente(admin,cliente1);
		sistema.agregaCliente(admin,cliente2);
		sistema.agregaCliente(admin,cliente3);
		}
		catch(NombreDeUsuarioYaExistenteException e)
		{
			System.out.println(e);
		}
		
		sistema.agregaVehiculo(admin,v1);
		sistema.agregaVehiculo(admin,v2);
		sistema.agregaVehiculo(admin,v3);
		sistema.agregaVehiculo(admin,v4);
		
		sistema.agregaChofer(admin,chofer1);
		sistema.agregaChofer(admin,chofer2);
		sistema.agregaChofer(admin,chofer3);

		
		try
		{
		    sistema.generaViaje(admin, new Pedido(LocalDateTime.now(), "Zona Peligrosa", false, true, 2, cliente1, 50));
		    System.out.println("Viaje realizado con exito");
		    sistema.generaViaje(admin, new Pedido(LocalDateTime.now(), "Estandar", false, true, 2, cliente1, 20));
		    System.out.println("Viaje realizado con exito");
		    
		    sistema.generaViaje(admin, new Pedido(LocalDateTime.now(), "Calle sin asfaltar", false, true, 8, cliente2, 10));
		    System.out.println("Viaje realizado con exito");
		    sistema.generaViaje(admin, new Pedido(LocalDateTime.now(), "Zona Peligrosa", true, true, 4, cliente3, 50));
		    System.out.println("Viaje realizado con exito");
		    System.out.println(sistema.listaVehiculos(admin));
		    System.out.println(sistema.listaChoferes(admin));
		    System.out.println(sistema.listarViajes(admin));
		    System.out.println(sistema.listaClientes(admin));
		    
		    System.out.println(sistema.listarViajesChofer(admin, chofer1, LocalDateTime.now(), LocalDateTime.now()));
		    System.out.println(sistema.listarViajesCliente(admin, cliente1, LocalDateTime.now(), LocalDateTime.now()));
		   
		    
		}
		catch(NoHayChoferesDisponiblesException e) {
			System.out.println(e);
		}
		catch(NoHayVehiculoException e) {
			System.out.println(e);
		}
		
		System.out.println(sistema.listarHistoricoViajesCliente(admin, cliente1));
		System.out.println(sistema.listarHistoricoViajesCliente(admin, cliente3));
	}
   
}
