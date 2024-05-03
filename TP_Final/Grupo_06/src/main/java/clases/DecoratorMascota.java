package clases;

public abstract class DecoratorMascota implements IViaje{
  protected IViaje encapsulado;

	public DecoratorMascota(IViaje encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}

}
