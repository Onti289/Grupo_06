package persistencia;

import java.util.ArrayList;
import java.util.LinkedList;

import clases.Administrador;
import clases.Chofer;
import excepciones.NombreDeUsuarioYaExistenteException;

public class UtilAdministrador {
	public static AdministradorDTO administradorDTOfromAdministrador(Administrador admin) {
		AdministradorDTO respuesta = new AdministradorDTO();
		respuesta.setNombre(admin.getNombre());
		respuesta.setNombreReal(admin.getNombreReal());
		respuesta.setContrasena(admin.getContrasena());
		LinkedList<ChoferDTO> choferesDTO = new LinkedList<ChoferDTO>();
		for(int i = 0; i<admin.getColaChoferes().size(); i++) {
			choferesDTO.add(UtilChofer.choferDTOfromChofer(admin.getColaChoferes().get(i)));
		}
		LinkedList<VehiculoDTO> vehiculosDTO = new LinkedList<VehiculoDTO>();
		for(int i = 0; i<admin.getColaVehiculos().size(); i++) {
			vehiculosDTO.add(UtilVehiculo.vehiculoDTOfromVehiculo(admin.getColaVehiculos().get(i)));
		}
		LinkedList<ClienteDTO> clientesDTO = new LinkedList<ClienteDTO>();
		for(int i = 0; i<admin.getListaClientes().size(); i++) {
			clientesDTO.add(UtilCliente.clienteDTOfromCliente(admin.getListaClientes().get(i)));
		}
		LinkedList<IViajeDTO> viajesDTO = new LinkedList<IViajeDTO>();
		for(int i = 0; i<admin.getListaViajes().size(); i++) {
			viajesDTO.add(UtilViaje.viajeDTOfromViaje(admin.getListaViajes().get(i)));
		}
		respuesta.setColaChoferes(choferesDTO);
		respuesta.setColaVehiculos(vehiculosDTO);
		respuesta.setListaClientes(clientesDTO);
		respuesta.setListaViajes(viajesDTO);
		
		return respuesta;
	}
	
	public static Administrador administradorfromAdministradorDTO(AdministradorDTO adminDTO) throws NombreDeUsuarioYaExistenteException {
		Administrador respuesta = new Administrador(adminDTO.getNombre(),adminDTO.getContrasena(),adminDTO.getNombreReal());
		for(int i=0; i<adminDTO.getColaChoferes().size(); i++) {
			respuesta.AgregarChofer(UtilChofer.choferfromChoferDTO(adminDTO.getColaChoferes().get(i)));
		}
		for(int i=0; i<adminDTO.getColaVehiculos().size(); i++) {
			respuesta.agregaVehiculo(UtilVehiculo.vehiculofromVehiculoDTO(adminDTO.getColaVehiculos().get(i)));
		}
		for(int i=0; i<adminDTO.getListaClientes().size(); i++) {
			respuesta.agregarCliente(UtilCliente.clientefromClienteDTO(adminDTO.getListaClientes().get(i)));
		}
		for(int i=0; i<adminDTO.getListaViajes().size(); i++) {
			respuesta.agregarViaje(UtilViaje.viajefromViajeDTO(adminDTO.getListaViajes().get(i)));
		}
		return respuesta;
	}
	
}
