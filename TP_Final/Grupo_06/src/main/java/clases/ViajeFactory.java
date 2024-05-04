package clases;

public class ViajeFactory {

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
