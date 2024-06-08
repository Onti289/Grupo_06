package persistencia;

import java.util.ArrayList;

import clases.Administrador;

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
	
}
