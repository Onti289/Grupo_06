package modelo;

import java.time.LocalDateTime;
import java.util.Objects;

import util.Util;
import vista.IVista;

/**
 * @author gc
 * <br>
 * Clase que extiende de Usuario que representa a un cliente de la plataforma dentro del sistema. Contiene nombre, nombreReal y contrase�a. Tiene la capacidad de generar Pedido
 */
public class Cliente extends ClienteAbstracto implements Runnable{

	private static int cantMaxViajes;
	private Sistema sistema;
	private IViaje viaje;
	private boolean pedidoValido;

	
	/**
     * Constructor con tres parametros para setear el nombre, nombreReal y contrase�a de un nuevo Cliente. <br>
     *
     *  <b>Pre: </b> Valores de los parametros String distintos de null, String nombre no se repite en ninguno de los usuarios ya existentes. <br>
     * 	<b>Post: </b> Se crea un nuevo Cliente en el sistema. <br>
     *
     * Llama a constructor super(nombre, contrasena, nombreReal) de Usuario. <br>
     */
    public Cliente(String nombre, String contrasena, String nombreReal, Sistema sistema) {
        super(nombre,contrasena,nombreReal);
        this.sistema = sistema;
    }

    public static void setCantMaxViajesCliente(int num)
    {
    	cantMaxViajes = num;
    }
    
public void setPedidoValido(boolean resp)
{
	this.pedidoValido = resp;
}


	public Sistema getSistema() {
		return sistema;
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

	
	
	
	public void modificacliente(String nombre,String contrasena) 
	{
		this.nombre = nombre;
		this.contrasena = contrasena;
	}

	public String listarHistoricoViajes(Administrador a) {
		return a.listarHistoricoViajesCliente(this);
		
	}



	@Override
	public void run(){
		int viajesRealizados = 0;
		System.out.println(this.nombre + "Entra run");
		while (viajesRealizados < cantMaxViajes && Chofer.CANTCHOFERESDISPONIBLES > 0)
		{
			System.out.println(this.nombre + "Entra while del run");
			int zonaAux =(int) (Math.random()*3 + 1);
			String zona;
			if (zonaAux == 1)
				zona = IVista.PELIGROSA;
			else
				if (zonaAux == 2)
				  zona = IVista.ESTANDAR;
				else
				  zona = IVista.SINASFALTAR;
			
			int baulAux = (int) (Math.random());
			boolean baul;
			if(baulAux==0)
			     baul = false;
			else
			     baul = true;
			
			int mascotaAux = (int) (Math.random());
			boolean mascota;
			if(mascotaAux==0)
			     mascota = false;
			else
			     mascota = true;
			int cantPax = (int) (Math.random()*8 +1);
			int cantKm = (int) (Math.random()*20 + 1);

			this.sistema.generaPedido(LocalDateTime.now(), zona, mascota, baul, cantPax, cantKm, this);
            Util.espera();
            System.out.println(this.nombre + "Pasa 1ra espera en while del run");
            if (this.pedidoValido)
            	this.sistema.pagaViaje(this);
			viajesRealizados++; //el cliente pierde un viaje si el pedido es rechazado por falta de vehiculos que lo cumplan
		}
		Cliente.CANTCLIENTESDISPONIBLES--;
		if (Cliente.CANTCLIENTESDISPONIBLES == 0)
		  notifyAll();
	}

	public void setViaje(IViaje viaje) {
		this.viaje = viaje;
		
	}

	public IViaje getViaje() {
		return this.viaje;
	}
}
