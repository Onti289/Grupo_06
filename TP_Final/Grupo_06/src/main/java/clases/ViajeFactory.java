package clases;

/**
 * @author Grupo6
 * 
 * Clase que permite aplicar el patron Factory para delegar la instanciacion de los vehiculos. Tambien esta clase permite aplicar el patron Decorator para agregar funcionalidades de manera dinamica a los distintos tipos de viajes que puedan solicitarse. <br>
 *
 */
public class ViajeFactory {

	/**
	 * Metodo de tipo IViaje que se encarga de isntanciar los viajes del sistema dependiendo de lo indicado en el pedido. Trabaja con encapsulados para poder agregar funcionalidades de manera dinamica a medida que se evaluan las diferentes condiciones del pedido. <br>
	 * 
	 * @param pedido Parametro de tipo Pedido que contiene todas las indicaciones que fueron dadas por el cliente para el viaje a realizar. <br>
	 * @param chofer Parametro de tipo Chofer que contiene al chofer que realizara el viaje. <br>
	 * @param vehiculo Parametro de tipo Vehiculo que contiene al vehiculo en el cual se realizara el viaje. <br>
	 * @return parametro de tipo IViaje que devuelve una instancia de viaje con las caracteristicas correspondientes. <br>
	 */
	public IViaje getViaje(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		IViaje respuesta = null;
		IViaje encapsulado = null;
		IViaje encapsulado2 = null;
		
		if (pedido.getZona().equalsIgnoreCase("Zona Peligrosa"))
			encapsulado = new ZonaPeligrosa(pedido, chofer, vehiculo);
		else
		  if (pedido.getZona().equalsIgnoreCase("Estandar"))
			encapsulado = new Estandar(pedido, chofer, vehiculo);
		  else
			if (pedido.getZona().equalsIgnoreCase("Calle sin asfaltar"))
			  encapsulado = new CalleSinAsfaltar(pedido, chofer, vehiculo);
		if (encapsulado != null)
		{
			if (pedido.isMascotas())
				encapsulado2 = new DecoratorConMascota(encapsulado);
			else
				encapsulado2 = new DecoratorSinMascota(encapsulado);
			if (pedido.isEquipaje())
				respuesta = new DecoratorConBaul(encapsulado2);
			else
				respuesta = new DecoratorSinBaul(encapsulado2);
		}

		return respuesta;
	}

}
