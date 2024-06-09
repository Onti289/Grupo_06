package persistencia;

import clases.Automovil;
import clases.Combi;
import clases.Moto;
import clases.Vehiculo;

public class UtilVehiculo {

	public static VehiculoDTO vehiculoDTOfromVehiculo(Vehiculo vehiculo) {
		VehiculoDTO respuesta = new VehiculoDTO();
		respuesta.setBaul(vehiculo.isBaul());
		respuesta.setMaxPasajeros(vehiculo.getMaxPasajeros());
		respuesta.setPatente(vehiculo.getPatente());
		respuesta.setPetFriendly(vehiculo.isPetFriendly());
		respuesta.setTipo(vehiculo.getTipo());
		return respuesta;
	}
	
	public static Vehiculo vehiculofromVehiculoDTO(VehiculoDTO vhDTO) {
		Vehiculo respuesta = null;
		if(vhDTO.getTipo().equalsIgnoreCase("Moto")) {
			respuesta = new Moto(vhDTO.getPatente(),vhDTO.isBaul(),vhDTO.isPetFriendly(),vhDTO.getMaxPasajeros());
		}
		else if(vhDTO.getTipo().equalsIgnoreCase("Automovil")) {
			respuesta = new Automovil(vhDTO.getPatente(),vhDTO.isBaul(),vhDTO.isPetFriendly(),vhDTO.getMaxPasajeros());
		}
		if(vhDTO.getTipo().equalsIgnoreCase("Combi")) {
			respuesta = new Combi(vhDTO.getPatente(),vhDTO.isBaul(),vhDTO.isPetFriendly(),vhDTO.getMaxPasajeros());
		}
		return respuesta;
	}

	

}
