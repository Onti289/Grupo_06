package persistencia;

import modelo.Cliente;

public class UtilCliente {

	public static ClienteDTO clienteDTOfromCliente(Cliente cliente) {
		ClienteDTO respuesta = new ClienteDTO();
		respuesta.setContrasena(cliente.getContrasena());
		respuesta.setNombre(cliente.getNombre());
		respuesta.setNombreReal(cliente.getNombreReal());
		respuesta.setSistema(cliente.getSistema());
		return respuesta;
	}
	
	public static Cliente clientefromClienteDTO(ClienteDTO clDTO) {
		Cliente respuesta = new Cliente(clDTO.getNombre(), clDTO.getContrasena(), clDTO.getNombreReal(), clDTO.getSistema());
		return respuesta;
	}
}
