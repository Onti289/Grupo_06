package clases;

import java.time.LocalDateTime;
import java.util.LinkedList;

import excepciones.*;

/**
 * @author gc
 *	<br>
 *	Clase que representa al sistema en si mismo. Se le aplicó el parton Singleton para que solo pueda existir en tiempo de ejecucion una unica instancia de la misma.
 *	Tambien se aplica el patron FACADE, con el fin de poder proporcionar una interfaz unificada para un conjunto de interfaces en un subsistema. <br>
 *
 *
 */
public class Sistema {

	private static Sistema _instancia = null;
	private String nombre;
	private LinkedList<Viaje> listaViajes;

	/**
	 * Constructor privado sin oarametros que permite instanciar un Sistema. Es privado para poder aplicar el patron Singleton. <br>
	 *
	 *  <b>Pre: </b> No existre ningun objeto instanciado de tipo Sitema. <br>
	 *  <b>Post: </b> Se crea el Sistema. <br>
	 *
	 *  El parametro de tipo nombre contiene el nobre de la aplicacion ("Subi que te llevo"). <br>
	 *  Al crear el Sistema, se instancia la listaViajes, la cual contendra todos los viajes realizados a traves de la aplicacion. <br>
	 */
	private Sistema() {
		this.nombre = "Subi que te llevo";
		this.listaViajes = new LinkedList<Viaje>();
	}

	/**
	 * Metodo static de tipo Sistema que devuleve el parametro Sistema _instancia. En caso de que el parametro tenga como valor null, lo instancia con el constructor correspondiente. <br>
	 *
	 * @return _instancia: parametro static de tipo Sistema que contiene a la unica instancia de Sistema.
	 */
	public static Sistema _getInstancia() {
		if (_instancia == null)
			_instancia = new Sistema();
		return _instancia;
	}

	public String getNombre() {
		return this.nombre;
	}


	/**
	 * Metodo de tipo void que agrega un Chofer c a la colaChofer de un determinado Administrador a. <br>
	 *
	 * <b>Pre: </b>parametros Administrador a y Chofer c distinto de null. <br>
	 *
	 * @param a: parametro de tipo Administrador en el cual se insertará el Chofer c. <br>
	 * @param c parametro de tipo Chofer que será insertado en la lista correspondiente del Administrador a. <br>
	 */
	public void agregaChofer(Administrador a, Chofer c) {
		a.AgregarChofer(c);
	}

	/*
  public Chofer sacaChofer(Administrador a) throws NoHayChoferesDisponiblesException {
    return a.SacarChofer();
  }*/

	/**
	 * Metodo de tipo void que permite cambiar los datos personales de un Chofer c (dni y nombre) perteneciente a la lista de choferes de un Administrador a. <br>
	 *
	 * <b>Pre: </b>parametros Administrador a y Chofer c distinto de null, parametros de tipo String dni y nombre distintos de "" y de null <br>
	 *
	 * @param a: parametro de tipo Administrador el cual contiene al chofer sobre el cual se quieren realizar modificaciones. <br>
	 * @param c: parametro de tipo Chofer que contiene el chofer al cual se le aplicaran las modificaciones. <br>
	 * @param dni: parametro de tipo String que contiene el dni actualizado del Chofer c. <br>
	 * @param nombre: parametro de tipo String que contiene el nombre actualizado del Chofer c. <br>
	 * @throws ChoferNoEncontradoException
	 */
	public void modificaChofer(Administrador a, Chofer c) throws ChoferNoEncontradoException
	  {
	    a.ModificaChofer(c);
	  }
	/**
	 * Metodo de tipo void que permite agregar un Vehiculo v a una colaVheiculos de un determinado Administrador a. <br>
	 *
	 * <b>Pre: </b>parametros Administrador a y Chofer c distinto de null. <br>
	 *
	 * @param a: parametro de tipo Administrador en el cual se insertará el Vehiculo v en su correspondiente lista. <br>
	 * @param v: parametro de tipo Vehiculo que será insertado en la lista correspondiente del Administrador a. <br>
	 */
	public void agregaVehiculo(Administrador a, Vehiculo v) {
		a.agregaVehiculo(v);
	}

	/* public Vehiculo sacaVehiculo(Administrador a)
  {
    return a.sacarVehiculo();
  }*/

	/**
	 * Metodo de tipo void que permite modificar la patente de un Vheiculo v perteneciente e la lista de vehiculos del Administrador a. <br>
	 * @param a
	 * @param v
	 * @param patente
	 * @throws VehiculoNoEncontradoException
	 */
	public void modificaVehiculo(Administrador a, Vehiculo v) throws VehiculoNoEncontradoException {
		a.modificaVehiculo(v);
	}

	/**
	 * Metodo de tipo void que permite agregar un Cliente c a una listaCliente de un determinado Administrador a. <br>
	 *
	 * <b>Pre: </b>parametros Administrador a y Chofer c distinto de null. <br>
	 *
	 * @param a: parametro de tipo Administrador en el cual se insertará el Cliente c en su correspondiente lista. <br>
	 * @param c: parametro de tipo Cliente que será insertado en la lista correspondiente del Administrador a. <br>
	 */
	public void agregaCliente(Administrador a, Cliente c) {
		a.agregarCliente(c);
	}

	/**
	 * Metodo de tipo void que permite sacar un Cliente c de su correspondiente lista dentro de un Administrador a. <br>
	 *
	 * @param a: parametro de tipo Administrador del cual se sacará al Cliente c de su correspondiente lista. <br>
	 * @param c: parametro de tipo Cliente, el cual será removiod de su correspondiente lista dentro del Administrador a. <br>
	 * @throws NoHayClientesException: Excepcion lanzada por el metodo en caso de que la lista de clientes del Administrador a se encuentre vacia. <br>
	 * @throws ClienteNoExistenteException: Excepcion lanzada en caso de que el Cliente c no exista dentro de la lista de clientes del Administrador a. <br>
	 */
	public void sacaCliente(Administrador a, Cliente c) throws NoHayClientesException, ClienteNoExistenteException {
		a.sacaCliente(c);
	}


	/**
	 * Metodo de tipo void que permite modificar los datos de un Cliente c (nombre usuario, nombre real y contraseña), el caul pertenece a su correspondiente lista dentro del Administrador a. <br>
	 *
	 * <b>Pre: </b>El Cliente c debe existir dentro de la lista correspondiente en Administrador a. <br>
	 *
	 * @param a: parametro de tipo Administrador el cual contiene al Cliebnte c dentro de su correspondiente lista. <br>
	 * @param c: parametro de tipo Cliente el cual sera modificado. <br>
	 * @param nombre: parametro de tipo String que contiene el nombre de usuario actualizado del Cliente c. <br>
	 * @param contrasena: parametro de tipo String que contiene la contraseña actualizada del Cliente c. <br>
	 * @param nombreReal: parametro de tipo String que contiene el nombre real actualizado del Cliente c. <br>
	 * @throws ClienteNoEncontradoException
	 */

	public void modificaCliente(Administrador a, Cliente c) throws ClienteNoEncontradoException
	{
		a.ModificaCliente(c);
	}

	/**
	 * Metodo de tipo void que permite listar los vehiculos pertenecientes a la cola de vehiculos del Administrador a. <br>
	 *
	 * @param a: parametro de tipo Administrador que contiene la lista correspondiente a mostrar. <br>
	 */
	public void listaVehiculos(Administrador a) {
		a.listarVehiculos();
	}

	/**
	 * Metodo de tipo void que permite listar los vehiculos pertenecientes a la lista de clientes del Administrador a. <br>
	 *
	 * @param a: parametro de tipo Administrador que contiene la lista correspondiente a mostrar. <br>
	 */
	public void listaClientes(Administrador a) {
		a.listarCLientes();
	}


	/**
	 * Metodo de tipo void que permite listar los vehiculos pertenecientes a la cola de choferes del Administrador a. <br>
	 *
	 * @param a: parametro de tipo Administrador que contiene la lista correspondiente a mostrar. <br>
	 */
	public void listaChoferes(Administrador a) {
		a.listarChoferes();
	}

	/**
	 * Metodo de tipo void que calcula el salario del Chofer c contenido en la cola de choferes del Administrador a. <br>
	 *
	 * @param a: parametro de tipo Administrador que contiene al Chofer c en su correspondiente lista. <br>
	 * @param c: parametro de tipo Chofer que al cual se le calculará su sueldo. <br>
	 * @return a.calculoSalario(c): devuelve parametro de tipo double que representa el salario del Chofer c. <br>
	 * @throws ChoferNoExistenteException: Excepcion lanzada por el metodo en el caso de que elChofer c no pertenzca a la lista correspondiente dentro del Administrador a. <br>
	 */
	public double calculoSalario(Administrador a,Chofer c) throws ChoferNoExistenteException {
		return a.calculoSalario(c);
	}

	/**
	 * Metodo de tipo double que realiza la suma de los salarios de todos los choferes de la lista correspondiente del Administrador a. <br>
	 *
	 * @param a: parametro de tipo Administrador del cual se tomará la lista de choferes para el calculo total de sueldos. <br>
	 * @return a.calculoSalarioTotal(): devuelve parametro de tipo double que representa la suma de todos los salarios de los choferes de la lista correspondiente en el Administrador a. <br>
	 */
	public double calculoSalariosTotal(Administrador a) {
		return a.calculoSalarioTotal();
	}

	/**
	 * Metodo de tipo Pedido que se encarga de generar un nuevo pedido en base a distintas peticiones solicitadas por el cliente. <br>
	 *
	 * <b>Pre: </b> el parametro fecha contiene un valor de fecha valido.
	 * 				El parametro zona contiene un valor de zona valido en base a las zonas posibles.
	 * 				El parametro cantidadPasajeros contiene un valor valido (entre 1 y 8 inclusive). <br>
	 *
	 * @param a: parametro de tipo Administrador que se encarga de verificar si el cliente existe en la lista correspondiente. <br>
	 * @param c: parametro de tipo Cliente que se encarga de generar el pedido. <br>
	 * @param fecha: parametro de tipo LocalTimeDate que indica la fecha en la que se raliza el pedido. <br>
	 * @param zona: parametro de tipo String que indica el tipo de zona por donde se realizará el viaje (Estandar, Peligrosa, Sin asfaltar). <br>
	 * @param mascotas: parametro de tipo boolean que indica si el cliente viajará con una mascota (true) o sin (false). <br>
	 * @param equipaje: parametro de tipo boolean que indica si el cliente llevará equipaje manual (false) o en baúl (true). <br>
	 * @param cantidadPasajeros: parametro de tipo int que indica la cantidad de pasajeros que tendrá el viaje. Debe ser entre 1 y 8 pasajeros. <br>
	 * @param distancia: parametro de tipo int que indica la cantidad de kilometros que serán recorridos durante el viaje. <br>
	 * @return p: parametro de tipo Pedido que contiene toda la inforamcion sobre lo solicitado por el cliente para su viaje. <br>
	 * @throws ClienteNoExistenteException: Excepcion lanzada en caso de que el cliente no exista dentro de la lista correspondiente del Administrador a. <br>
	 * @throws DistanciaInvalidaException: Excepcion lanzada en caso de que la distancia a recorrer sea menor o igual a cero. <br>
	 */
	public Pedido generarPedido(Administrador a, Cliente c, LocalDateTime fecha, String zona, boolean mascotas, boolean equipaje, int cantidadPasajeros, int distancia) throws ClienteNoExistenteException,DistanciaInvalidaException {
		Pedido p = null;

		if(distancia <= 0) {
			throw new DistanciaInvalidaException("La distancia debe ser mayor a cero");
		}

		if(!a.existeCliente(c)) {
			throw new ClienteNoExistenteException("El cliente no existe");
		}

		p = c.generaPedido(fecha, zona, mascotas, equipaje, cantidadPasajeros, distancia);

		return p;

	}

	/**
	 * Metodo de tipo void que genera un viaje en base a un Pedido p y a los choferes y vehiculos disponibles y que cumplen las condicioens en Administrador a en su correspondiente lista. <br>
	 *
	 * <b>Pre: </b> Pedido p está validado y todos sus campos contienen valores validos. <br>
	 *
	 * @param a: parametro de tipo Administrador que contiene la lista de choferes y vehiculos disponibles para satisfacer el Pedido p. <br>
	 * @param p: parametro de tipo Pedido que contiene el pedido realizado por el cliente, el cual se encuentra dentro del mismo.
	 * @throws NoHayChoferesDisponiblesException: Excepcion lanzada en caso de que no se cuente con ningun chofer disponible al momento de iniciar el viaje. <br>
	 * @throws NoHayVehiculoException: Excepcion lanzada en caso de que ninguno de los vehiculos disponibles cumpla con lo solicitado en el pedido. <br>
	 */
	public void generaViaje(Administrador a, Pedido p) throws NoHayChoferesDisponiblesException,NoHayVehiculoException {
		Chofer c = null;
		Vehiculo v = null;
		Viaje viaje = null;

		if(!a.isChoferDisponible()) {
			throw new NoHayChoferesDisponiblesException("No hay choferes disonibles");
		}
		if(!a.vehiculoCumplePedido(p)) {
			throw new NoHayVehiculoException("No hay vehiculos que cumplan con el pedido");
		}

		c = a.SacarChofer();
		v = a.sacarVehiculo(p);

		viaje = new Viaje(p,c,v);

		this.listaViajes.add(viaje);

		iniciaViaje(viaje);
	}

	private void iniciaViaje(Viaje viaje) {
		// TODO Auto-generated method stub
	}

	/**
	 * Metodo de tipo void que calcula los puntos en el mes de los choferes pertenecientes a la lista correspondiente del Administrador a. <br>
	 *
	 * @param a: parametro de tipo Administrador, el cual contiene la lista de los choferes a los cuales se les calculará su puntaje mensual. <br>
	 */
	public void calculoPuntosMes(Administrador a) {
		a.calculoPuntosMes();
	}

	public String listarViajesChofer(Chofer chofer, LocalDateTime fechaMinima, LocalDateTime fechaMaxima, Administrador a)
	{
		return a.listarViajesChofer(chofer, fechaMinima, fechaMaxima);
	}
}
