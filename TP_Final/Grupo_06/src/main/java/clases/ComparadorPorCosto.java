package clases;

import java.util.Comparator;

public class ComparadorPorCosto implements Comparator<IViaje> {

	@Override
	public int compare(IViaje v1, IViaje v2) {
		return Double.compare(v2.getCosto(), v1.getCosto()); // Ordenar de mayor a menor
	}
	

}
