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
		String fecha = iViaje.getFecha().toString();
		
		IViajeDTO respuesta = new IViajeDTO();
		respuesta.setChofer(iViaje.getChofer());
		respuesta.setCliente(iViaje.getCliente());
		respuesta.setCosto(iViaje.getCosto());
		respuesta.setDistanciaRealRecorrida(iViaje.getKM());
		respuesta.setEstado(iViaje.getEstado());
		respuesta.setFecha(fecha);
		respuesta.setPasajeros(iViaje.getPax());
		respuesta.setVehiculo(iViaje.getVehiculo());
		respuesta.setValorBase(Viaje.getValorBase());
		respuesta.setPedido(iViaje.getPedido());
		return respuesta;
	}
	
	public static IViaje viajefromViajeDTO(IViajeDTO viajeDTO) {
		IViaje respuesta = null;
		if(viajeDTO.getPedido().getZona().equalsIgnoreCase("Zona Peligrosa")) {
			respuesta = new ZonaPeligrosa(viajeDTO.getPedido(), viajeDTO.getChofer(),viajeDTO.getVehiculo());
		}
		else if(viajeDTO.getPedido().getZona().equalsIgnoreCase("Estandar")) {
			respuesta = new Estandar(viajeDTO.getPedido(), viajeDTO.getChofer(),viajeDTO.getVehiculo());
		}
		else if(viajeDTO.getPedido().getZona().equalsIgnoreCase("Calle sin asfaltar")) {
			respuesta = new CalleSinAsfaltar(viajeDTO.getPedido(), viajeDTO.getChofer(),viajeDTO.getVehiculo());
		}
		return respuesta;
	}

}
