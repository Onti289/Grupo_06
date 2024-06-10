package persistencia;

import modelo.Cliente;
import modelo.ClienteAbstracto;

public class UtilCliente {

	public static ClienteDTO clienteDTOfromCliente(ClienteAbstracto clienteAbstracto) {
		ClienteDTO respuesta = new ClienteDTO();
		respuesta.setContrasena(clienteAbstracto.getContrasena());
		respuesta.setNombre(clienteAbstracto.getNombre());
		respuesta.setNombreReal(clienteAbstracto.getNombreReal());
		respuesta.setSistema(clienteAbstracto.getSistema());
		return respuesta;
	}
	
	public static Cliente clientefromClienteDTO(ClienteDTO clDTO) {
		Cliente respuesta = new Cliente(clDTO.getNombre(), clDTO.getContrasena(), clDTO.getNombreReal(), clDTO.getSistema());
		return respuesta;
	}
}
