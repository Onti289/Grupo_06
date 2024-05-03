package clases;


/**
 * @author gc
 *
 * Clase que implementa la interfaz IViaje que representa los viajes generados en el sistema por los clientes. Contiene
 * un estado (Solicitado, Iniciazo, Finalizado, Pagado), una referencia al pedido hehco por el cliente, una referencia al chofer que llevará a cabo el viaje, el costo del mismo
 * y la distancia real recorrida. <br>
 *
 */
public abstract class Viaje implements IViaje {

		private String estado;
		private Cliente cliente;
		private Chofer chofer;
		private Vehiculo vehiculo;
		private double costo;
		private static double valorBase = 1000.0;
		private double distanciaRealRecorrida;
		private int pasajeros;

		/**
		 * Constructor con tres parametros para setear el Pedido realizado por el cliente el Chofer que llevará a cabo el viaje y el Vehiculo en el que se realizará el viaje. <br>
		 *
		 * @param pedido: parametro de tipo Pedido que contiene toda la informacion otorgada por el cliente (Cliente, zona, mascota, equipaje, cantidad de pasajeros, distancia recorrida, costo). <br>
		 * @param chofer: parametro de tipo Chofer que contiene la informacion del chofer (Temporario, Contratado, Permanente) que llevara a cabo el viaje. <br>
		 * @param vehiculo: parametro de tipo Vehiculo que contiene la informacion del vehiculo (Automovil, Moto, Combi) en el cual se realizará el viaje. <br>
		 *
		 * El costo se obtiene del Pedido, como asi tambien la distancia recorrida. <br>
		 * Al crearse el viaje, el estado se setea en situacion de "Solicitado"
		 */
		public Viaje(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
			this.chofer = chofer;
			this.vehiculo = vehiculo;
			this.estado = "Solicitado";
			this.pasajeros = pedido.getCantidadPasajeros();
			this.cliente = pedido.getCliente();
			this.distanciaRealRecorrida = pedido.getDistancia();
		}

		public Chofer getChofer() {
			return chofer;
		}

		public abstract double getCosto();

		public double getDistanciaRealRecorrida() {
			return distanciaRealRecorrida;
		}

		public static double getValorBase() {
			return valorBase;
		}

		public static void setValorBase(double valorBase) {
			Viaje.valorBase = valorBase;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstadoIniciado() {
			this.estado = "Iniciado";
		}

		public void setEstadoPagado() {
			this.estado = "Pagado";
		}

		public void setEstadoFinalizado() {
			this.estado = "Finalizado";
		}




}
