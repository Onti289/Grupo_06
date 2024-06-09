package modelo;
import java.time.LocalDateTime;
import excepciones.*;

/**
 * @author Grupo6
 * Clase que permite representar a los pedidos solicitados por los clientes que utilizan el sistema. Esta clase contiene tanto las solicitudes del cliente en cuando a
 * distancia a recorrer, cantidad de pasajeros, con o sin baul, con o sin mascota, fecha y la zona donde se realizara el viaje, como asi tambien una referencia al cliente 
 * que realiza el mismo. <br>
 *
 */
public class Pedido {
    private LocalDateTime fecha;
    private String zona;
    private boolean mascotas;
    private boolean equipaje;
    private int cantidadPasajeros;
    private Cliente cliente;
    private int distancia;

    /**
     * Constructor que permite generar un nuevo pedido. Dentro de los parametros solicitados se encuentra todo lo necesario para evaluar si el sistema cuenta con un vehiculo 
     * acorde para poder satisfacer las necesidades del cliente. <br>
     * 
     * <b>Pre: </b> Valores de los parametros String distintos de null, zona debe contener un valor valido ("Zona Peligrosa", "Estandar", "Calle sin asfaltar") cantidadPasajeros entre 0 y 8, Cliente distinto de null, distancia debe ser mayor a cero, fecha debe ser valida (fecha no puede ser posterior a fecha de hoy). <br>
     * <b>Post: </b> Se crea un nuevo Pedido en el sistema. <br>
     *
     * 
     * @param fecha Parametro de tipo LocalDateTime que contiene la fecha en la que se realiza el pedido. <br>
     * @param zona Parametro de tipo String que contiene el tipo de zona en la cual se realizara el viaje pedido. <br>
     * @param mascotas Parametro de tipo boolean que indica si el pedido es con mascotas (true) o sin (false). <br>
     * @param equipaje Parametro de tipo boolean que indica si el pedido es con baul (true) o sin baul (false). <br>
     * @param cantidadPasajeros Parametro de tipo int que contiene la cantiad de pasajeros que iran en el viaje. <br>
     * @param cliente Parametro de tipo Cliente que contiene al cliente que realiza el pedido. <br>
     * @param distancia Parametro de tipo int que contiene la distancia en kilometros a recorrer. <br>
     */
    public Pedido(LocalDateTime fecha, String zona, boolean mascotas, boolean equipaje, int cantidadPasajeros, Cliente cliente, int distancia) {
        assert zona != null;
        assert cantidadPasajeros > 0;
        assert distancia > 0;
    	
    	this.fecha = fecha;
        this.zona = zona;
        this.mascotas = mascotas;
        this.equipaje = equipaje;
        this.cantidadPasajeros = cantidadPasajeros;
        this.cliente = cliente;
        this.distancia = distancia;
    }

    public String getZona() {
        return this.zona;
    }

    public boolean isMascotas() {
        return this.mascotas;
    }

    public boolean isEquipaje() {
        return this.equipaje;
    }

    public int getDistancia() {
		return distancia;
	}

	public int getCantidadPasajeros() {
        return this.cantidadPasajeros;
    }

    public Cliente getCliente() {
		return cliente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

}
