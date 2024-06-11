package persistencia;

import modelo.Cliente;
import modelo.ClienteAbstracto;
import modelo.ClienteHumano;

public class UtilClienteHumano {

	public static ClienteHumanoDTO clienteHumanoDTOfromClienteHumano(ClienteAbstracto clienteAbstracto) {
		ClienteHumanoDTO respuesta = new ClienteHumanoDTO();
		respuesta.setContrasena(clienteAbstracto.getContrasena());
		respuesta.setNombre(clienteAbstracto.getNombre());
		respuesta.setNombreReal(clienteAbstracto.getNombreReal());
		return respuesta;
	}
	
	public static ClienteHumano clienteHumanofromClienteHumanoDTO(ClienteHumanoDTO clDTO) {
		ClienteHumano respuesta = new ClienteHumano(clDTO.getNombre(), clDTO.getContrasena(), clDTO.getNombreReal());
		return respuesta;
	}
}
