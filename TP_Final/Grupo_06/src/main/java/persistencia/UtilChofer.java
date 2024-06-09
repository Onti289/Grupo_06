package persistencia;

import modelo.Chofer;
import modelo.ChoferContratado;
import modelo.ChoferPermanente;
import modelo.ChoferTemporario;

public class UtilChofer {
	public static ChoferDTO choferDTOfromChofer(Chofer chofer) {
		ChoferDTO respuesta = new ChoferDTO();
		respuesta.setNombre(chofer.getNombre());
		respuesta.setDNI(chofer.getDNI());
		respuesta.setKMrecorridosMes(chofer.getKMrecorridosMes());
		respuesta.setViajesMes(chofer.getViajesMes());
		respuesta.setPuntos(chofer.getPuntos());
		respuesta.setTipo(chofer.getTipo());
		
		if(respuesta.getTipo().equalsIgnoreCase("Contratado")) {
			ChoferContratado contratado = (ChoferContratado) chofer;
			respuesta.setGananciaViaje(contratado.getGananciaViaje());
		}
		else if(respuesta.getTipo().equalsIgnoreCase("Temporario")) {
			ChoferTemporario temporario = (ChoferTemporario) chofer;
			respuesta.setSueldoBasico(temporario.getSueldoBasico());
			respuesta.setAportes(temporario.getAportes());
			respuesta.setCantViajes(temporario.getCantViajes());
		}
		else if(respuesta.getTipo().equalsIgnoreCase("Permanente")) {
			ChoferPermanente permanente = (ChoferPermanente) chofer;
			respuesta.setAnioIngreso(permanente.getAnioIngreso());
			respuesta.setAntiguedad(permanente.getAntiguedad());
			respuesta.setSueldoBasico(permanente.getSueldobasico());
			respuesta.setCantHijos(permanente.getCantHijos());
			respuesta.setAportes(permanente.getAportes());
		}
		return respuesta;
	}
	
	public static Chofer choferfromChoferDTO(ChoferDTO chDTO) {
		Chofer respuesta = null;
		if(chDTO.getTipo().equalsIgnoreCase("Contratado")) {
			respuesta = new ChoferContratado(chDTO.getDNI(), chDTO.getNombre(),chDTO.getGananciaViaje());
			respuesta.setKMrecorridosMes(chDTO.getKMrecorridosMes());
			respuesta.setPuntos(chDTO.getPuntos());
			respuesta.setViajesMes(chDTO.getViajesMes());
		}
		else if(chDTO.getTipo().equalsIgnoreCase("Temporario")){
			respuesta = new ChoferTemporario(chDTO.getDNI(), chDTO.getNombre(), chDTO.getSueldoBasico(), chDTO.getAportes());
			respuesta.setViajesMes(chDTO.getViajesMes());
		}
		else if(chDTO.getTipo().equalsIgnoreCase("Permanente")) {
			respuesta = new ChoferPermanente(chDTO.getDNI(), chDTO.getNombre(), chDTO.getSueldoBasico(), chDTO.getCantHijos(), chDTO.getAportes(), chDTO.getAnioIngreso());
		}
		return respuesta;
	}
}
