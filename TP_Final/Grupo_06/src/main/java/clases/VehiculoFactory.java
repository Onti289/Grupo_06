package clases;

public class VehiculoFactory {

    public Vehiculo crear(String tipo, String patente) {
    	Vehiculo respuesta = null;

    	if(tipo.equalsIgnoreCase("Moto")) {
    		respuesta = new Moto(patente,false,false,1);
    	}
    	else if(tipo.equalsIgnoreCase("Automovil")) {
    		respuesta = new Automovil(patente,true,true,4);
    	}
    	else if(tipo.equalsIgnoreCase("Combi")) {
    		respuesta = new Combi(patente,false,false,10);
    	}
    	return respuesta;
    }
}
