package clases;

import java.util.Comparator;

/**
 * @author Grupo6
 * 
 * Clase que permite comparar los valores de costo de diferentes viajes para luego utilizar al momento de generar el listado de viajes ordenados por costo de mayor a menor. <br>
 *
 */
public class ComparadorPorCosto implements Comparator<IViaje> {

	@Override
	public int compare(IViaje v1, IViaje v2) {
		return Double.compare(v2.getCosto(), v1.getCosto()); // Ordenar de mayor a menor
	}
	

}
