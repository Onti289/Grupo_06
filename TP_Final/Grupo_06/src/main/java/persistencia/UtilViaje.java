package persistencia;

import modelo.IViaje;
import modelo.Vehiculo;
import modelo.Viaje;

public class UtilViaje {

	public static IViajeDTO viajeDTOfromViaje(IViaje iViaje) {
		IViajeDTO respuesta = new IViajeDTO();
		respuesta.setChofer(iViaje.getChofer());
		respuesta.setCliente(iViaje.getCliente());
		respuesta.setCosto(iViaje.getCosto());
		respuesta.setDistanciaRealRecorrida(iViaje.getKM());
		respuesta.setEstado(iViaje.getEstado());
		respuesta.setFecha(iViaje.getFecha());
		respuesta.setPasajeros(iViaje.getPax());
		respuesta.setVehiculo(iViaje.getVehiculo());
		respuesta.setValorBase(Viaje.getValorBase());
		
		return respuesta;
	}
	
	public static Viaje viajefromViajeDTO(IViajeDTO viajeDTO) {
		Viaje respuesta = null;
		//Como referenciar al tipo de viaje? (zona,mascota,baul)
		return respuesta;
	}

}
