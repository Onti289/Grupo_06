package prueba;
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
		
		Chofer chofer1 = new ChoferContratado("40569874", "Juancito", 1000);
		Chofer chofer2 = new ChoferPermanente("23666987", "Juan Carlos", 80000, 10, 2, 15, "1998-02-02");
		Chofer chofer3 = new ChoferTemporario("36998741", "Juan Cruz", 50000, 10);
		
		Vehiculo v1 = vehiculoFactory.crear("Automovil", "AD-123-CD");
		Vehiculo v2 = vehiculoFactory.crear("Automovil", "BC-122-AA");
		Vehiculo v3 = vehiculoFactory.crear("Combi", "OPP-123");
		Vehiculo v4 = vehiculoFactory.crear("Moto", "AA-111-BA");
		
		sistema.agregaCliente(admin,cliente1);
		sistema.agregaCliente(admin,cliente2);
		sistema.agregaCliente(admin,cliente3);
		
		sistema.agregaVehiculo(admin,v1);
		sistema.agregaVehiculo(admin,v2);
		sistema.agregaVehiculo(admin,v3);
		sistema.agregaVehiculo(admin,v4);
		
		sistema.agregaChofer(admin,chofer1);
		sistema.agregaChofer(admin,chofer2);
		sistema.agregaChofer(admin,chofer3);
		
		System.out.println(sistema.listaClientes(admin));
		
		try
		{
		    sistema.generaViaje(admin, null);
		}
		catch(NoHayPlataException e) {
			System.out.println(e);
		}
		catch(NoHayChoferesDisponiblesException e) {
			System.out.println(e);
		}
		catch(NoHayVehiculoException e) {
			System.out.println(e);
		}
	}

}
