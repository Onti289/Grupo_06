package persistencia;

import java.time.LocalDateTime;

import modelo.CalleSinAsfaltar;
import modelo.Estandar;
import modelo.IViaje;
import modelo.Vehiculo;
import modelo.Viaje;
import modelo.ViajeFactory;
import modelo.ZonaPeligrosa;

public class UtilViaje {

	public static IViajeDTO viajeDTOfromViaje(IViaje iViaje) {
		
		IViajeDTO respuesta = new IViajeDTO();
		respuesta.setChofer(UtilChofer.choferDTOfromChofer(iViaje.getChofer()));
		respuesta.setCliente(UtilCliente.clienteDTOfromCliente(iViaje.getCliente()));
		respuesta.setCosto(iViaje.getCosto());
		respuesta.setDistanciaRealRecorrida(iViaje.getKM());
		respuesta.setEstado(iViaje.getEstado());
		respuesta.setFecha(LocalDateTime.now());
		respuesta.setPasajeros(iViaje.getPax());
		respuesta.setVehiculo(UtilVehiculo.vehiculoDTOfromVehiculo(iViaje.getVehiculo()));
		respuesta.setValorBase(Viaje.getValorBase());
		respuesta.setZona(iViaje.getPedido().getZona());
		respuesta.setPedido(UtilPedido.pedidoDTOfromPedido(iViaje.getPedido()));
		
		return respuesta;
	}
	
	public static IViaje viajefromViajeDTO(IViajeDTO viajeDTO) {
		IViaje respuesta = null;
		
		if(viajeDTO.getZona().equalsIgnoreCase("Zona Peligrosa")) {
			respuesta = new ZonaPeligrosa(UtilPedido.pedidofromPedidoDTO(viajeDTO.getPedido()), UtilChofer.choferfromChoferDTO(viajeDTO.getChofer()),UtilVehiculo.vehiculofromVehiculoDTO(viajeDTO.getVehiculo()));
		}
		else if(viajeDTO.getZona().equalsIgnoreCase("Estandar")) {
			respuesta = new Estandar(UtilPedido.pedidofromPedidoDTO(viajeDTO.getPedido()), UtilChofer.choferfromChoferDTO(viajeDTO.getChofer()),UtilVehiculo.vehiculofromVehiculoDTO(viajeDTO.getVehiculo()));
		}
		else if(viajeDTO.getZona().equalsIgnoreCase("Calle sin asfaltar")) {
			respuesta = new CalleSinAsfaltar(UtilPedido.pedidofromPedidoDTO(viajeDTO.getPedido()), UtilChofer.choferfromChoferDTO(viajeDTO.getChofer()),UtilVehiculo.vehiculofromVehiculoDTO(viajeDTO.getVehiculo()));
		}
		return respuesta;
	}

}
