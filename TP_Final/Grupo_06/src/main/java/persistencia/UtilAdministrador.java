package persistencia;

import java.util.ArrayList;

import clases.Administrador;
import clases.Chofer;
import excepciones.NombreDeUsuarioYaExistenteException;

public class UtilAdministrador {
	public static AdministradorDTO administradorDTOfromAdministrador(Administrador admin) {
		AdministradorDTO respuesta = new AdministradorDTO();
		respuesta.setNombre(admin.getNombre());
		respuesta.setNombreReal(admin.getNombreReal());
		respuesta.setContrasena(admin.getContrasena());
		ArrayList<ChoferDTO> choferesDTO = new ArrayList<ChoferDTO>();
		for(int i = 0; i<admin.getColaChoferes().size(); i++) {
			choferesDTO.add(UtilChofer.choferDTOfromChofer(admin.getColaChoferes().get(i)));
		}
		ArrayList<VehiculoDTO> vehiculosDTO = new ArrayList<VehiculoDTO>();
		for(int i = 0; i<admin.getColaVehiculos().size(); i++) {
			vehiculosDTO.add(UtilVehiculo.vehiculoDTOfromVehiculo(admin.getColaVehiculos().get(i)));
		}
		ArrayList<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		for(int i = 0; i<admin.getListaClientes().size(); i++) {
			clientesDTO.add(UtilCliente.clienteDTOfromCliente(admin.getListaClientes().get(i)));
		}
		ArrayList<ViajeDTO> viajesDTO = new ArrayList<ViajeDTO>();
		for(int i = 0; i<admin.getColaVehiculos().size(); i++) {
			viajesDTO.add(UtilViaje.viajeDTOfromViaje(admin.getColaVehiculos().get(i)));
		}
		return respuesta;
	}
	
	public static Administrador administradorfromAdministradorDTO(AdministradorDTO adminDTO) throws NombreDeUsuarioYaExistenteException {
		Administrador respuesta = new Administrador(adminDTO.getNombre(),adminDTO.getContrasena(),adminDTO.getNombreReal());
		for(int i=0; i<adminDTO.getColaChoferes().size(); i++) {
			respuesta.AgregarChofer(adminDTO.getColaChoferes().get(i));
		}
		for(int i=0; i<adminDTO.getColaVehiculos().size(); i++) {
			respuesta.agregaVehiculo(adminDTO.getColaVehiculos().get(i));
		}
		for(int i=0; i<adminDTO.getListaClientes().size(); i++) {
			respuesta.agregarCliente(adminDTO.getListaClientes().get(i));
		}
		for(int i=0; i<adminDTO.getListaViajes().size(); i++) {
			respuesta.agregarViaje(adminDTO.getListaViajes().get(i));
		}
		return respuesta;
	}
	
}
