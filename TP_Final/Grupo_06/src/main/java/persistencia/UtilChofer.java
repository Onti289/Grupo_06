package persistencia;

import clases.Chofer;
import clases.ChoferContratado;
import clases.ChoferPermanente;
import clases.ChoferTemporario;

public class UtilChofer {
	public static ChoferDTO choferDTOfromChofer(Chofer chofer) {
		ChoferDTO respuesta = new ChoferDTO();
		respuesta.setNombre(chofer.getNombre());
		respuesta.setDNI(chofer.getDNI());
		respuesta.setKMrecorridosMes(chofer.getKMrecorridosMes());
		respuesta.setViajesMes(chofer.getViajesMes());
		respuesta.setPuntos(chofer.getPuntos());
		
		if(chofer.getTipo().equalsIgnoreCase("Contratado")) {
			ChoferContratado contratado = (ChoferContratado) chofer;
			respuesta.setGananciaViaje(contratado.getGananciaViaje());
		}
		else if(chofer.getTipo().equalsIgnoreCase("Temporario")) {
			ChoferTemporario temporario = (ChoferTemporario) chofer;
			respuesta.setSueldobasico(temporario.getSueldoBasico());
			respuesta.setAportes(temporario.getAportes());
			respuesta.setCantViajes(temporario.getCantViajes());
		}
		else if(chofer.getTipo().equalsIgnoreCase("Permanente")) {
			ChoferPermanente permanente = (ChoferPermanente) chofer;
			respuesta.setAnioIngreso(permanente.getAnioIngreso());
			respuesta.setAntiguedad(permanente.getAntiguedad());
			respuesta.setSueldobasico(permanente.getSueldobasico());
			respuesta.setCantHijos(permanente.getCantHijos());
			respuesta.setAportes(permanente.getAportes());
		}
		return respuesta;
	}
}
