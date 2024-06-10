/*package persistencia;

import java.io.IOException;
import java.time.LocalDateTime;

import excepciones.NoHayChoferesDisponiblesException;
import excepciones.NoHayVehiculoException;
import excepciones.NombreDeUsuarioYaExistenteException;
import modelo.Administrador;
import modelo.Chofer;
import modelo.ChoferContratado;
import modelo.ChoferPermanente;
import modelo.ChoferTemporario;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Sistema;
import modelo.Vehiculo;
import modelo.VehiculoFactory;

public class PruebaPersistenciaEscritura {

	public static void main(String[] args) {
		Sistema sistema = Sistema._getInstancia();
		IPersistencia persistencia = new PersistenciaXML();
		
		VehiculoFactory vehiculoFactory = new VehiculoFactory();
		
		Administrador admin = new Administrador("Admin", "Admin123", "Elad Ministrador");

		
		Cliente cliente1 = new Cliente("user1","abc123","Carlos", sistema);
		Cliente cliente2 = new Cliente("user2","41561","Juana", sistema);
		Cliente cliente3 = new Cliente("user3","abssda","Javier", sistema);
		
	//	Chofer chofer1 = new ChoferContratado("40569874", "Juancito", 30);
	//	Chofer chofer2 = new ChoferPermanente("23666987", "Juan Carlos", 80000, 10, 2, 1998);
	//	Chofer chofer3 = new ChoferTemporario("36998741", "Juan Cruz", 50000, 10);
		
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
		
		sistema.agregaVehiculoADisponibles(admin,v1);
		sistema.agregaVehiculoADisponibles(admin,v2);
		sistema.agregaVehiculoADisponibles(admin,v3);
		sistema.agregaVehiculoADisponibles(admin,v4);
		
		sistema.agregaChofer(admin,chofer1);
		sistema.agregaChofer(admin,chofer2);
		sistema.agregaChofer(admin,chofer3);
		
		try {
			sistema.generaViaje(admin, new Pedido(LocalDateTime.now(), "Zona Peligrosa", false, true, 2, cliente1, 50));
			sistema.generaViaje(admin, new Pedido(LocalDateTime.now(), "Estandar", false, true, 2, cliente1, 20));
		} catch (NoHayChoferesDisponiblesException | NoHayVehiculoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
		
		 try
	        {
	            persistencia.abrirOutput("Admins.xml");
	            System.out.println("Crea archivo escritura");
	            AdministradorDTO adto=UtilAdministrador.administradorDTOfromAdministrador(admin);
	            persistencia.escribir(adto);

	            
	            System.out.println("Admins grabadados exitosamente");
	            persistencia.cerrarOutput();
	            System.out.println("Archivo cerrado");
	        } catch (IOException e)
	        {
	            // TODO Auto-generated catch block
	            System.out.println(e.getLocalizedMessage());
	        }
		
	}

}
*/