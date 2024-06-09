package persistencia;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import modelo.IViaje;
import modelo.Pedido;

public class UtilPedido {
	public static PedidoDTO pedidoDTOfromPedido(Pedido pedido) {
		PedidoDTO respuesta = new PedidoDTO();
		respuesta.setCantidadPasajeros(pedido.getCantidadPasajeros());
		respuesta.setCliente(pedido.getCliente());
		respuesta.setDistancia(pedido.getDistancia());
		respuesta.setEquipaje(pedido.isEquipaje());
		respuesta.setFecha(LocalDateTime.now());
		respuesta.setMascotas(pedido.isMascotas());
		respuesta.setZona(pedido.getZona());
		return respuesta;
	}
	
	public static Pedido pedidofromPedidoDTO(PedidoDTO pDTO) {
		Pedido respuesta = new Pedido(LocalDateTime.now(),pDTO.getZona(),pDTO.isMascotas(),pDTO.isEquipaje(),pDTO.getCantidadPasajeros(),pDTO.getCliente(),pDTO.getDistancia());
		return respuesta;
	}
}
