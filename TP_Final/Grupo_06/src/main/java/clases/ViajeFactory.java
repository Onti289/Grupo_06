package clases;

public class ViajeFactory {

	public IViaje getViaje(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		IViaje respuesta = null;
		IViaje encapsulado = null;
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
				respuesta = new DecoratorConMascota(encapsulado);
		}

		return respuesta;
	}

}
