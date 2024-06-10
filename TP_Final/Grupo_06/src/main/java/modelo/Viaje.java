package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import excepciones.ChoferNoExistenteException;

/**
 * @author gc
 *
 * Clase que implementa la interfaz IViaje que representa los viajes generados en el sistema por los clientes. Contiene
 * un estado (Solicitado, Iniciazo, Finalizado, Pagado), una referencia al pedido hehco por el cliente, una referencia al chofer que llevar� a cabo el viaje, el costo del mismo
 * y la distancia real recorrida. <br>
 *
 */
public abstract class Viaje implements IViaje {

		private String estado;
		private ClienteAbstracto cliente;
		private Chofer chofer;
		private Vehiculo vehiculo;
		private static double valorBase = 1000.0;
		private int distanciaRealRecorrida;
		private int pasajeros;
		private LocalDateTime fecha;
		private Pedido pedido;

		/**
		 * Constructor con tres parametros para setear el Pedido realizado por el cliente el Chofer que llevar� a cabo el viaje y el Vehiculo en el que se realizar� el viaje. <br>
		 *
		 * @param pedido parametro de tipo Pedido que contiene toda la informacion otorgada por el cliente (Cliente, zona, mascota, equipaje, cantidad de pasajeros, distancia recorrida, costo). <br>
		 * @param chofer parametro de tipo Chofer que contiene la informacion del chofer (Temporario, Contratado, Permanente) que llevara a cabo el viaje. <br>
		 * @param vehiculo parametro de tipo Vehiculo que contiene la informacion del vehiculo (Automovil, Moto, Combi) en el cual se realizar� el viaje. <br>
		 *
		 * El costo se obtiene del Pedido, como asi tambien la distancia recorrida. <br>
		 * Al crearse el viaje, el estado se setea en situacion de "Solicitado". <br>
		 */
		public Viaje(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
			this.chofer = chofer;
			this.vehiculo = vehiculo;
			this.estado = "Solicitado";
			this.pasajeros = pedido.getCantidadPasajeros();
			this.cliente = pedido.getCliente();
			this.distanciaRealRecorrida = pedido.getDistancia();
			this.fecha = pedido.getFecha();
			this.pedido = pedido;
		}
		
		public Pedido getPedido() {
			return pedido;
		}

		public Chofer getChofer() {
			return chofer;
		}
		
		public ClienteAbstracto getCliente() {
			return cliente;
		}

		public int getPax() {
			return this.pasajeros;
		}
		
		public int getKM() {
			return this.distanciaRealRecorrida;
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
			
		public LocalDateTime getFecha() {
			return fecha;
		}
		
		public Vehiculo getVehiculo() {
			return vehiculo;
		}

		public int getPasajeros() {
			return pasajeros;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public void setChofer(Chofer chofer) {
			this.chofer = chofer;
		}

		public void setVehiculo(Vehiculo vehiculo) {
			this.vehiculo = vehiculo;
		}

		public void setCosto(double costo) {
			this.costo = costo;
		}

		public void setDistanciaRealRecorrida(int distanciaRealRecorrida) {
			this.distanciaRealRecorrida = distanciaRealRecorrida;
		}

		public void setPasajeros(int pasajeros) {
			this.pasajeros = pasajeros;
		}

		public void setFecha(LocalDateTime fecha) {
			this.fecha = fecha;
		}

		/**
		 * Metodo de tipo void que permite modificar el estado de un viaje. <br>
		 */
		public void setEstado(String e) {
			if(e.equalsIgnoreCase("Iniciado")){
				this.estado = "Iniciado";
			}
			else if(e.equalsIgnoreCase("Pagado")){
				this.estado = "Pagado";
			}
			else if(e.equalsIgnoreCase("Finalizado")){
				this.estado = "Finalizado";
			}
		}

		/**
		 * Devuelve un String con los datos del viaje: <br>
		 * Nombre del cliente <br>
		 * Nombre del chofer <br>
		 * Patente y tipo del vehiculo <br>
		 * Costo del viaje <br>
		 * Distancia recorrida <br>
		 * Cantidad de pasajeros <br>
		 * Fecha del viaje <br>
		 */
		@Override
		public String toString() {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String fecha = this.fecha.format(formatter);
			return  this.cliente.getNombre() +
					"\t" + this.chofer.getNombre() + 
					"\t" + vehiculo.getPatente() + 
					"\t\t$" + String.format("%.2f", this.getCosto()) + 
					"\t\t" + String.valueOf(this.distanciaRealRecorrida) + 
					"\t\t\t" + String.valueOf(this.pasajeros) + 
					"\t\t" + fecha + "\n";
		}
		
		public synchronized void iniciaViaje()
	    {
	      this.chofer.setViaje(Sistema.sacarViaje(Sistema.getAdmin()));
	      try {
			Thread.sleep((long)(Math.random()*3000));
		  } catch (InterruptedException e) {
			
			e.printStackTrace();
		  }
	      this.viaje.getCliente().setViaje(this.viaje);
	      this.viaje.setEstado("Iniciado");
	      setChanged();
	      notifyObservers(this.viaje);
	      
	    }
		
		/**
		 * el cliente paga el viaje
		 */
		public synchronized void pagaViaje()
		{
			try {
				Thread.sleep((long)(Math.random()*3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			this.viaje.setEstado("Pagado");
			setChanged();
			notifyObservers(this.viaje);
			
		}
		/**
		 * Metodo de tipo void que permite setear el estado del viaje en "Finalizado", ademas de sumar los kilometros recorridos y suma un viaje al chofer que lo realizo. <br>
		 * 
		 * <b>Pre: </b> parametro viaje distinto de null. <br>
		 * 
		 * @param viaje Parametro de tipo IViaje al cual se le modificara su estado a "Finalizado". <br>
		 */
		public synchronized void finalizaViaje(){
			
			try {
				Thread.sleep((long)(Math.random()*3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.viaje.setEstado("Finalizado");
			  this.sumaKMrecorridosMes(viaje.getKM());
			  this.sumaViajesMes();
			  setChanged();
			  notifyObservers(this.viaje);
			
		}
}
