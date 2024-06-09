package clases;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author gc
 * <br>
 * Clase que extiende de Usuario que representa a un cliente de la plataforma dentro del sistema. Contiene nombre, nombreReal y contrase�a. Tiene la capacidad de generar Pedido
 */
public class Cliente extends Usuario {

    /**
     * Constructor con tres parametros para setear el nombre, nombreReal y contrase�a de un nuevo Cliente. <br>
     *
     *  <b>Pre: </b> Valores de los parametros String distintos de null, String nombre no se repite en ninguno de los usuarios ya existentes. <br>
     * 	<b>Post: </b> Se crea un nuevo Cliente en el sistema. <br>
     *
     * Llama a constructor super(nombre, contrasena, nombreReal) de Usuario. <br>
     */
    public Cliente(String nombre, String contrasena, String nombreReal) {
        super(nombre,contrasena,nombreReal);
        // TODO Auto-generated constructor stub
    }

    /**
     * Metodo que genera y devuelve un nuevo pedido en base a diferentes parametros que determinaran el tipo de vwhiculo y el precio final del Viaje a realizar. <br>
     *
     * <b>Pre: </b> parametro fecha con valor de fecha valida, parametro cantidadPasajeros con valor positivo y menor a 8, parametro distancia con valor positivo, parametro zona con valor valido de zona en base a tipos existentes. <br>
     * <b>Post: </b> devuelve un pedido validado para poder obtener un Chofer y Vehiculo acorde a lo solicitado. <br>
     *
     * @param fecha parametro de tipo LocalTimeDate que representa la fecha en la cual se realiz� el pedido. <br>
     * @param zona parametro de tipo String que representa la zona en la cual se realizar� el viaje. Existen tres tipos: Estandar, Calle sin asfaltar y Zona peligrosa. <br>
     * @param mascotas parametro de tipo boolean que representa si el cliente va a realizar un viaje junto con una mascota. <br>
     * @param equipaje parametro de tipo boolean que representa si el cliente va a realizar el viaje con equipaje en mano (False) o equipaje en baul (True). <br>
     * @param cantidadPasajeros parametro de tipo int que representa la cantidad de pasajeros que iran en el viaje.
     * @param distancia parametro de tipo int que representa la distancia en km. que tomar� realizar el viaje. <br>
     * @return El metodo devuelve un parametro de tipo Pedido con el nuevo pedido realizado por el cliente en base a lo completado en el formulario del viaje. <br>
     */

    public Pedido generaPedido(LocalDateTime fecha, String zona, boolean mascotas, boolean equipaje, int cantidadPasajeros, int distancia) {
    	Pedido p = new Pedido(fecha, zona, mascotas, equipaje, cantidadPasajeros, this, distancia);
    	return p;
    }

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
    public boolean equals(Object o) {
        if (this == o)
        	return true;
        if (o == null || getClass() != o.getClass())
        	return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

	/**
	 * el cliente paga el viaje
	 */
	public void pagaViaje(IViaje viaje) {
		  viaje.setEstado("Pagado");
		
	}
	
	
	public void modificacliente(String nombre,String contrasena) 
	{
		this.nombre = nombre;
		this.contrasena = contrasena;
	}

	public String listarHistoricoViajes(Administrador a) {
		return a.listarHistoricoViajesCliente(this);
		
	}
}
