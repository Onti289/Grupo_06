package persistencia;

import java.io.IOException;

import excepciones.NombreDeUsuarioYaExistenteException;
import modelo.Administrador;

public class PruebaPersistenciaLectura {

	public static void main(String[] args) {

		IPersistencia persistencia = new PersistenciaXML();
		
		Administrador admin = null;
		
		  try
	        {
	            persistencia.abrirInput("Admins.xml");
	            System.out.println("Archivo abierto");
	            AdministradorDTO adto=(AdministradorDTO) persistencia.leer();
	            admin = UtilAdministrador.administradorfromAdministradorDTO(adto);
	 
	            System.out.println("Escuela recuperada");
	            persistencia.cerrarInput();
	            System.out.println("Archivo cerado");
	        } catch (IOException e)
	        {
	            // TODO Auto-generated catch block
	            System.out.println(e.getMessage());
	        } catch (ClassNotFoundException e)
	        {
	            // TODO Auto-generated catch block
	            System.out.println(e.getMessage());
	        } catch (NombreDeUsuarioYaExistenteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  System.out.println(admin.listarChoferes());
		  System.out.println(admin.listarCLientes());
		  System.out.println(admin.listarVehiculos());
		  System.out.println(admin.listarViajes());
	}

}
