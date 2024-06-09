package modelo;

/**
 * @author Grupo6
 * 
 * Clase que permite aplicar el patron Factory para delegar la instanciacion de los vehiculos.
 *
 */
public class VehiculoFactory {

    /**
     * Metodo de tipo Vehiculo que se encarga de instanciar los diferentes tipos de vehiculos en el sistema, cada uno con sus correspondientes caracteristicas en cuanto a cantidad maxima de pasajeros, baul y pet friendly. <br>
     * 
     * 
     * @param tipo Parametro de tipo String que contiene el tipo de vehiculo que quiere instanciarse. <br>
     * @param patente Parametro de tipo String que contiene la patente del vehiculo a instanciar. <br>
     * @return respuesta: Parametro de tipo Vehiculo que devuelve una instancia de este tipo en caso de que el parametro tipo contenga un tipo valido de vehiculo. Cso contrario, retorna null. <br>
     */
    public Vehiculo crear(String tipo, String patente) {
    	Vehiculo respuesta = null;

    	if(tipo.equalsIgnoreCase("Moto")) {
    		respuesta = new Moto(patente,false,false,1);
    	}
    	else if(tipo.equalsIgnoreCase("Automovil")) {
    		respuesta = new Automovil(patente,true,true,4);
    	}
    	else if(tipo.equalsIgnoreCase("Combi")) {
    		respuesta = new Combi(patente,true,false,10);
    	}
    	return respuesta;
    }
}
