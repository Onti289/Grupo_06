package modelo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Observable;

import excepciones.*;
import controladores.*;
import persistencia.*;

/**
 * @author gc
 *	<br>
 *	Clase que representa al sistema en si mismo. Se le aplic� el parton Singleton para que solo pueda existir en tiempo de ejecucion una unica instancia de la misma.
 *	Tambien se aplica el patron FACADE, con el fin de poder proporcionar una interfaz unificada para un conjunto de interfaces en un subsistema. <br>
 *
 *
 */
/**
 * 
 */
public class Sistema extends Observable{

	private static Sistema _instancia = null;
	private String nombre;
	private static Administrador admin = new Administrador("ElAdmin", "123", "Leonel");
	

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
	}
    
	public Sistema(String nombre)
	{
		_getInstancia();
	}
	
    public void agregaVehiculoATotal(Administrador a, Vehiculo v)
    {
    	a.agregaVehiculoATotal(v);
    }
	
    public void agregaViaje(IViaje viaje)
    {
    	admin.agregarViaje(viaje);
    }
    
    public IViaje sacaViaje()
    {
    	
    	while (ClienteAbstracto.CANTCLIENTESDISPONIBLES > 0 && (admin.getListaViajes().isEmpty() || !hayConVehiculo()))
			try {
				System.out.println("saca viaje en sistema wait");
				wait();
				System.out.println("saca viaje en sistema sale del wait");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	if (ClienteAbstracto.CANTCLIENTESDISPONIBLES > 0)
    	{
    		System.out.println("Entra if del sacaviaje en sistema");
    		int i = 0;
    		while (i < admin.getListaViajes().size() && admin.getListaViajes().get(i).getEstado().equalsIgnoreCase("solicitado"))
    			i++;
    		
    		IViaje viaje = admin.sacarViaje(i);
    		notifyAll();
    		System.out.println(""+i + viaje);
    	   return viaje;
    	}
    	else
    	{
    	  
    		return null;
    	 
    	 
    	  }
    }
    
    public boolean hayVehiculoCumple(Administrador a, Pedido p) {
       return a.vehiculoCumplePedido(p);
    }
    
    
    public boolean hayConVehiculo()
    {
    	int i = 0;
		while (i < admin.getListaViajes().size() && !admin.getListaViajes().get(i).getEstado().equalsIgnoreCase("con Vehiculo"))
			i++;
		return i < admin.getListaViajes().size();
    }
    
    public synchronized void generaPedido(LocalDateTime fecha, String zona, boolean mascotas, boolean equipaje, int cantidadPasajeros, int distancia, Cliente cliente) {
    	if (Chofer.CANTCHOFERESDISPONIBLES > 0)
    	{
    	  Pedido p = new Pedido(fecha, zona, mascotas, equipaje, cantidadPasajeros, cliente, distancia);
    	
    	  boolean aux = hayVehiculoCumple(admin, p);
    	
    	  cliente.setPedidoValido(aux);
    	  if (aux)
    	  {
    	    ViajeFactory viajeFactory = new ViajeFactory();
    	    IViaje viaje = viajeFactory.getViaje(p, null, null);
    	    //System.out.println(viaje);
    	    cliente.setViaje(viaje);
    	    viaje.setEstado("solicitado");
    	    this.agregaViaje(viaje);
    	    System.out.println(Sistema.getAdmin().listarViajes()+"\n---------------------------");
    	    System.out.println(cliente.getNombre()+" genero el viaje "+cliente.getViaje());
    	    System.out.println("entra genera pedido en cliente");
    	    setChanged();
    	    notifyObservers(viaje);
    	    notifyAll();
    	  }
    	  else
    	  {
    		System.out.println("El pedido generado por "+cliente.getNombre()+" fue rechazado");
    	  }
    	}
    	
    }
    
    public synchronized void iniciaViaje(Chofer chofer)
    {
    	System.out.println(chofer.getNombre()+" va a iniciar el viaje "+chofer.getViaje());
    	while (ClienteAbstracto.CANTCLIENTESDISPONIBLES > 0 && (admin.getListaViajes().isEmpty() || !hayConVehiculo()))
			try {
				System.out.println(chofer.getNombre()+ "en wait de inicia viaje");
				wait();
				System.out.println("saca viaje en sistema sale del wait");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	if (ClienteAbstracto.CANTCLIENTESDISPONIBLES > 0)
    	{
    		IViaje viaje = sacaViaje();
    		
    	System.out.println(viaje);
    		chofer.setViaje(viaje);
      chofer.getViaje().setChofer(chofer);
      chofer.getViaje().setEstado("Iniciado");
      System.out.println(chofer.getNombre()+" inicio el viaje "+chofer.getViaje());
      
      setChanged();
      notifyObservers(chofer.getViaje());
      notifyAll();
      }
      
    }
	
	/**
	 * el cliente paga el viaje
	 */
	public synchronized void pagaViaje(Cliente cliente)
	{
		System.out.println(cliente.getNombre()+" va a pagar el viaje "+cliente.getViaje());
		while (Chofer.CANTCHOFERESDISPONIBLES > 0 && !cliente.getViaje().getEstado().equalsIgnoreCase("iniciado"))
			try {
				System.out.println(cliente.getNombre()+" en wait de paga viaje");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (Chofer.CANTCHOFERESDISPONIBLES > 0)
		{
		  System.out.println(cliente.getNombre()+" pago el viaje "+cliente.getViaje());
		  cliente.getViaje().setEstado("Pagado");
		  setChanged();
		  notifyObservers(cliente.getViaje());
		  notifyAll();
		}
		
	}
	/**
	 * Metodo de tipo void que permite setear el estado del viaje en "Finalizado", ademas de sumar los kilometros recorridos y suma un viaje al chofer que lo realizo. <br>
	 * 
	 * <b>Pre: </b> parametro viaje distinto de null. <br>
	 * 
	 * @param viaje Parametro de tipo IViaje al cual se le modificara su estado a "Finalizado". <br>
	 */
	public synchronized void finalizaViaje(Chofer chofer){
		
   System.out.println(chofer.getNombre()+" va a finalizar el viaje "+chofer.getViaje());
		while (ClienteAbstracto.CANTCLIENTESDISPONIBLES > 0 && !chofer.getViaje().getEstado().equalsIgnoreCase("pagado"))
			try {
				System.out.println(chofer.getNombre()+" en wait de finaliza viaje");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (ClienteAbstracto.CANTCLIENTESDISPONIBLES > 0)
		{
			System.out.println(chofer.getNombre()+" finalizo viaje "+chofer.getViaje());
		    chofer.getViaje().setEstado("Finalizado");
		    chofer.sumaKMrecorridosMes(chofer.getViaje().getKM());
		    chofer.sumaViajesMes();
		    this.agregaVehiculoADisponibles(Sistema.admin, chofer.getViaje().getVehiculo());
		    setChanged();
		    notifyObservers(chofer.getViaje());
		    notifyAll();
		}
		
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
	 * <b>Post: </b>Chofer c agregado a la lista correspondiente en Administrador a. <br>
	 *
	 * @param a parametro de tipo Administrador en el cual se insertar� el Chofer c. <br>
	 * @param c parametro de tipo Chofer que ser� insertado en la lista correspondiente del Administrador a. <br>
	 */
	public void agregaChofer(Administrador a, Chofer c) {
		a.AgregarChofer(c);
		persistir();
	}


	/**
	 * Metodo de tipo Chofer que saca de la cola correspondiente en Administrador a al primer chofer disponible. <br>
	 * 
	 * <b>Pre: </b>parametro Administrador a distinto de null. <br>
	 * 
	 * @param a Parametro de tipo Administrador que contiene la cola de choferes a utilizar. <br>
	 * @return a.SacarChofer(): devuelve al primer chofer de la cola correspondiente. <br>
	 * @throws NoHayChoferesDisponiblesException Excepcion lanzada en caso de que la cola de choferes de Administrador a este vacia. <br>
	 */
	public Chofer sacaChofer(Administrador a) throws NoHayChoferesDisponiblesException {
		return a.SacarChofer();
	}

	/**
	 * Metodo de tipo void que permite cambiar los datos personales de un Chofer c (dni y nombre) perteneciente a la lista de choferes de un Administrador a. <br>
	 *
	 * <b>Pre: </b>parametros Administrador a y Chofer c distinto de null, parametros de tipo String dni y nombre distintos de "" y de null <br>
	 *
	 * @param a parametro de tipo Administrador el cual contiene al chofer sobre el cual se quieren realizar modificaciones. <br>
	 * @param c parametro de tipo Chofer que contiene el chofer al cual se le aplicaran las modificaciones. <br>
	 * @param dni parametro de tipo String que contiene el dni actualizado del Chofer c. <br>
	 * @param nombre parametro de tipo String que contiene el nombre actualizado del Chofer c. <br>
	 * @throws ChoferNoEncontradoException
	 */
	public void modificaChofer(Administrador a, Chofer c, String nombre) throws ChoferNoExistenteException
	  {
	    a.ModificaChofer(c,nombre);
	  }
	/**
	 * Metodo de tipo void que permite agregar un Vehiculo v a una colaVheiculos de un determinado Administrador a. <br>
	 *
	 * <b>Pre: </b>parametros Administrador a y Chofer c distinto de null. <br>
	 *
	 * @param a parametro de tipo Administrador en el cual se insertar� el Vehiculo v en su correspondiente lista. <br>
	 * @param v parametro de tipo Vehiculo que ser� insertado en la lista correspondiente del Administrador a. <br>
	 */
	public void agregaVehiculoADisponibles(Administrador a, Vehiculo v) {
		a.agregaVehiculoADisponibles(v);
	}


	/**
	 * Metodo de tipo void que permite modificar la patente de un Vheiculo v perteneciente e la lista de vehiculos del Administrador a. <br>
	 * 
	 * <b>Pre: </b>Parametros Administrador a y Vehiculo v distintos de null. <br>
	 * 
	 * 
	 * @param a
	 * @param v
	 * @param patente
	 * @throws VehiculoNoEncontradoException
	 */
	public void modificaVehiculo(Administrador a, Vehiculo v, String patente) throws VehiculoNoEncontradoException {
		a.modificaVehiculo(v,patente);
	}
	

	/**
	 * Metodo de tipo void que permite agregar un Cliente c a una listaCliente de un determinado Administrador a. <br>
	 *
	 * <b>Pre: </b>parametros Administrador a y Chofer c distinto de null. <br>
	 *
	 * @param a parametro de tipo Administrador en el cual se insertar� el Cliente c en su correspondiente lista. <br>
	 * @param c parametro de tipo Cliente que ser� insertado en la lista correspondiente del Administrador a. <br>
	 * @throws NombreDeUsuarioYaExistenteException 
	 */
	public void agregaCliente(Administrador a, Cliente c) throws NombreDeUsuarioYaExistenteException {
		a.agregarCliente(c);
	}
public void agregaClienteHumano(Administrador a, ClienteHumano c)
{
	a.agregarClienteHumano(c);
}
	
	/**
	 * Metodo de tipo void que permite sacar un Cliente c de su correspondiente lista dentro de un Administrador a. <br>
	 *
	 * @param a parametro de tipo Administrador del cual se sacar� al Cliente c de su correspondiente lista. <br>
	 * @param c parametro de tipo Cliente, el cual ser� removiod de su correspondiente lista dentro del Administrador a. <br>
	 * @throws NoHayClientesException Excepcion lanzada por el metodo en caso de que la lista de clientes del Administrador a se encuentre vacia. <br>
	 * @throws ClienteNoExistenteException Excepcion lanzada en caso de que el Cliente c no exista dentro de la lista de clientes del Administrador a. <br>
	 */
	public void sacaCliente(Administrador a, Cliente c) throws NoHayClientesException, ClienteNoExistenteException {
		a.sacaCliente(c);
	}


	/**
	 * Metodo de tipo void que permite modificar los datos de un Cliente c (nombre usuario y contrase�a), el caul pertenece a su correspondiente lista dentro del Administrador a. <br>
	 *
	 * <b>Pre: </b>Parametros Administrador a y Cliente c distinto de null.<br>
	 *
	 * @param a parametro de tipo Administrador el cual contiene al Cliebnte c dentro de su correspondiente lista. <br>
	 * @param c parametro de tipo Cliente el cual sera modificado. <br>
	 * @param nombre parametro de tipo String que contiene el nombre de usuario actualizado del Cliente c. <br>
	 * @param contrasena parametro de tipo String que contiene la contrase�a actualizada del Cliente c. <br>
	 * @param nombreReal parametro de tipo String que contiene el nombre real actualizado del Cliente c. <br>
	 * @throws ClienteNoEncontradoException Excepcion lanzada en caso de que el Cliente c no exista en la lista correspondiente dentro de Administrador a. <br>
	 */

	/*public void modificaCliente(Administrador a, Cliente c, String nombre, String contrasena) throws ClienteNoExistenteException
	{
		a.ModificaCliente(c,nombre,contrasena);
	}*/

	/**
	 * Metodo de tipo void que permite listar los vehiculos pertenecientes a la cola de vehiculos del Administrador a. <br>
	 *
	 * <b>Pre: </b>Parametro Administrador a distinto de null. <br>
	 *
	 * @param a parametro de tipo Administrador que contiene la lista correspondiente a mostrar. <br>
	 */
	public String listaVehiculos(Administrador a) {
		return a.listarVehiculos();
	}

	/**
	 * Metodo de tipo void que permite listar los vehiculos pertenecientes a la lista de clientes del Administrador a. <br>
	 *
	 * <b>Pre: </b>Parametro Administrador a distinto de null. <br>
	 *
	 * @param a parametro de tipo Administrador que contiene la lista correspondiente a mostrar. <br>
	 */
	public String listaClientes(Administrador a) {
		return a.listarCLientes();
	}


	/**
	 * Metodo de tipo void que permite listar los vehiculos pertenecientes a la cola de choferes del Administrador a. <br>
	 *
	 * <b>Pre: </b>Parametro Administrador a distinto de null. <br>
	 *
	 * @param a parametro de tipo Administrador que contiene la lista correspondiente a mostrar. <br>
	 */
	public String listaChoferes(Administrador a) {
		return a.listarChoferes();
	}

	/**
	 * Metodo de tipo void que calcula el salario del Chofer c contenido en la cola de choferes del Administrador a. <br>
	 *
	 * <b>Pre: </b>Parametro Administrador a distinto de null. <br>
	 *
	 * @param a parametro de tipo Administrador que contiene al Chofer c en su correspondiente lista. <br>
	 * @param c parametro de tipo Chofer que al cual se le calcular� su sueldo. <br>
	 * @return a.calculoSalario(c): devuelve parametro de tipo double que representa el salario del Chofer c. <br>
	 * @throws ChoferNoExistenteException: Excepcion lanzada por el metodo en el caso de que elChofer c no pertenzca a la lista correspondiente dentro del Administrador a. <br>
	 */
	public double calculoSalario(Administrador a,Chofer c) throws ChoferNoExistenteException {
		return a.calculoSalario(c);
	}

	/**
	 * Metodo de tipo double que realiza la suma de los salarios de todos los choferes de la lista correspondiente del Administrador a. <br>
	 *
	 * <b>Pre: </b>Parametro Administrador a distinto de null. <br>
	 *
	 * @param a parametro de tipo Administrador del cual se tomar� la lista de choferes para el calculo total de sueldos. <br>
	 * @return a.calculoSalarioTotal(): devuelve parametro de tipo double que representa la suma de todos los salarios de los choferes de la lista correspondiente en el Administrador a. <br>
	 */
	public double calculoSalariosTotal(Administrador a) {
		return a.calculoSalarioTotal();
	}

	public void agregarPedido(Administrador a, Pedido pedido){
        a.agregaPedido(pedido);
    }

	public Pedido sacarPedido(Administrador a) {
    	return a.sacaPedido();
    }
	
	
	/**
	 * Metodo de tipo void que genera un viaje en base a un Pedido p y a los choferes y vehiculos disponibles y que cumplen las condicioens en Administrador a en su correspondiente lista. <br>
	 *
	 * <b>Pre: </b>Parametros Administrador a y Pedido p distintos de null. Pedido p esta validado y todos sus campos contienen valores validos. <br>
	 *
	 * @param a parametro de tipo Administrador que contiene la lista de choferes y vehiculos disponibles para satisfacer el Pedido p. <br>
	 * @param p parametro de tipo Pedido que contiene el pedido realizado por el cliente, el cual se encuentra dentro del mismo.
	 * @throws NoHayChoferesDisponiblesException Excepcion lanzada en caso de que no se cuente con ningun chofer disponible al momento de iniciar el viaje. <br>
	 * @throws NoHayVehiculoException Excepcion lanzada en caso de que ninguno de los vehiculos disponibles cumpla con lo solicitado en el pedido. <br>
	 */
	/*public void generaViaje(Administrador a, Pedido p) throws NoHayChoferesDisponiblesException,NoHayVehiculoException {
		Chofer chofer = null;
		Vehiculo vehiculo = null;
		IViaje viaje = null;
		

		if (a.vehiculoCumplePedido(p))
		{	
		  
        persistir();
        
		
        
        
        
		iniciaViaje(viaje);
		
		p.getCliente().pagaViaje(viaje);
		
		chofer.finalizaViaje(viaje);
		
		
		
		a.AgregarChofer(chofer);
		
		a.agregaVehiculoADisponibles(vehiculo);
		}
	}
*/
	
	
	public static IViaje sacarViaje(Administrador a)
	{
	  return a.sacarViaje(0);
	}
	

	/**
	 * Metodo de tipo void que calcula los puntos en el mes de los choferes pertenecientes a la lista correspondiente del Administrador a. <br>
	 *
	 * <b>Pre: </b>Parametro Administrador a distinto de null. <br>
	 *
	 * @param a parametro de tipo Administrador, el cual contiene la lista de los choferes a los cuales se les calcular� su puntaje mensual. <br>
	 */
	public void calculoPuntosMes(Administrador a) {
		a.calculoPuntosMes();
	}

	/**
	 * Metodo de tipo String que permite mostrar el listado de viajes realizados por un determinado chofer en un determinado periodo de tiempo. <br>
	 * 
	 * <b>Pre: </b>parametros Administrador a y Chofer chofer distinto de null. Parametro fechaMinima contiene una fecha anterior a fechaMaxima, y ambas son fechas validas. <br>
	 * 
	 * @param a Parametro de tipo Administrador que contiene la lista de viajes realizados. <br>
	 * @param chofer Parametro de tipo Chofer que contiene los datos del chofer del cual se quieren conocer sus viajes en el periodo fechaMinima/fechaMaxima. <br>
	 * @param fechaMinima Parametro de tipo LocalTimeDate que contiene la fecha inicial desde donde se generara el listado. <br>
	 * @param fechaMaxima Parametro de tipo LocalTimeDate que contiene la fecha final hasta la cual se generara el listado. <br>
	 * 
	 * @return a.listarViajesChofer(chofer, fechaMinima, fechaMaxima): Parametro de tipo String que contiene titulo, subtitulo y listado de viajes realizados por el chofer en el periodo de tiempo indicado por las fechas ingreasadas por parametro. <br>

	 */
	public String listarViajesChofer(Administrador a, Chofer chofer, LocalDateTime fechaMinima, LocalDateTime fechaMaxima)
	{
		return a.listarViajesChofer(chofer, fechaMinima, fechaMaxima);
	}
	
	/**
	 * Metodo de tipo String que permite mostrar el listado de viajes realizados por un determinado cliente en un determinado periodo de tiempo. <br>
	 * 
	 * <b>Pre: </b>parametros Administrador a y Cliente cliente distinto de null. Parametro fechaMinima contiene una fecha anterior a fechaMaxima, y ambas son fechas validas. <br>
	 * 
	 * @param a Parametro de tipo Administrador que contiene la lista de viajes realizados. <br>
	 * @param cliente Parametro de tipo Cliente que contiene los datos del cliente del cual se quieren conocer sus viajes en el periodo fechaMinima/fechaMaxima. <br>
	 * @param fechaMinima Parametro de tipo LocalTimeDate que contiene la fecha inicial desde donde se generara el listado. <br>
	 * @param fechaMaxima Parametro de tipo LocalTimeDate que contiene la fecha final hasta la cual se generara el listado. <br>
	 * 
	 * @return a.listarViajesCliente(c, fechaMinima, fechaMaxima): Parametro de tipo String que contiene titulo, subtitulo y listado de viajes realizados por el cliente en el periodo de tiempo indicado por las fechas ingreasadas por parametro. <br>

	 */
	public String listarViajesCliente(Administrador a, Cliente c, LocalDateTime fechaMinima, LocalDateTime fechaMaxima) {
		return a.listarViajesCliente(c, fechaMinima, fechaMaxima);
	}
	
	/**
	 * Metodo de tipo String que devuleve una cadena tabulada para mostrar por consola el listado de todos los viajes realizados en el sistema en orden de meayor a menor costo. <br>	 * 
	 * 
	 * <b>Pre: </b>Parametro Administrador a distinto de null. <br>
	 * 
	 * @param a Parametro de tipo Administrador que contiene el listado de todos los viajes realizados en el sistema.<br>
	 * 
	 * @return a.listarViajes() Parametro de tipo String que contiene titulo, subtitulo y listado de viajes ordenados por costo de mayo a menor tabulados para ser mostrados en formato de lista por consola. <br>
	 */
	public String listarViajes(Administrador a) {
		return a.listarViajes();
	}
	
	/**
	 * Devuelve el historico de viajes de un cliente pasado por parametro
	 */
	public String listarHistoricoViajesCliente(Administrador a, Cliente cliente)
	{
		return cliente.listarHistoricoViajes(a);
	}

	

    private static boolean hayHumano = false;
    private static boolean nuevaSim = false;


    public boolean isHayHumano() {
        return hayHumano;
    }

    public void setHayHumano(boolean hayHumano) {
        this.hayHumano = hayHumano;
    }

    public boolean isNuevaSim() {
        return nuevaSim;
    }

    public void setNuevaSim(boolean nuevaSim) {
        this.nuevaSim = nuevaSim;
    }

    
    public static Administrador getAdmin()
    {
    	return admin;
    }
    
    public boolean existeNombreUsuario(Administrador a, String nombre)
	{
		return a.existeNombreUsuario(nombre);
	}
	
	public boolean contraseniaCorrecta(Administrador a, String nombre, String contrasenia)
	{
		return a.contraseniaCorrecta(nombre, contrasenia);
	}
	
	public ClienteAbstracto getCliente(Administrador a, String nombreUsuario)
    {
      return a.getCliente(nombreUsuario);
    }
	public static ClienteAbstracto getCliente1(Administrador a)
	{
		return a.getCliente1();
	}
	
	public static Chofer getChofer1(Administrador a)
	{
		return a.getChofer1();
	}
	
	public void setClienteHumano(Administrador a, ClienteAbstracto cliente) {
		a.setClienteHumano(cliente);
	}
	
	public void persistir() {
		IPersistencia persistencia = new PersistenciaXML();
		try
		{
		     persistencia.abrirOutput("Admins.xml");
		     
		     AdministradorDTO adto=UtilAdministrador.administradorDTOfromAdministrador(admin);
		     persistencia.escribir(adto);

		     
		     persistencia.cerrarOutput();
		     
		     } catch (IOException e)
		     {
		        System.out.println(e.getLocalizedMessage());
		     }
	}
	public void despersistir()
	{
       IPersistencia persistencia = new PersistenciaXML();
		
		  try
	        {
	            persistencia.abrirInput("Admins.xml");
	            
	            AdministradorDTO adto=(AdministradorDTO) persistencia.leer();
	            admin = UtilAdministrador.administradorfromAdministradorDTO(adto);
	 
	            
	            persistencia.cerrarInput();
	            
	        } catch (IOException e)
	        {
	            
	            System.out.println(e.getMessage());
	        } catch (ClassNotFoundException e)
	        {
	            
	            System.out.println(e.getMessage());
	        } catch (NombreDeUsuarioYaExistenteException e) {
				
				e.printStackTrace();
			}
	}
	public void setAdmin(Administrador a)
	{
	  this.admin = a;
	}

	public ClienteHumano getClienteHumano() {
		// TODO Auto-generated method stub
		return admin.getClienteHumano();
	}

	public Vehiculo sacarVehiculoDeDisponibles(IViaje v) {
		int i = 0;
		System.out.println("El sistema esta buscando vehiculos");
		Pedido p = v.getPedido();
		while(i < admin.getColaVehiculosDisponibles().size() && !admin.getColaVehiculosDisponibles().get(i).cumpleCondicion(p))
			i++;
		
		if (i < admin.getColaVehiculosDisponibles().size())
		{
			System.out.println("El sistema encontro vehiculos");
			return admin.getColaVehiculosDisponibles().remove(i);
		}
		else
		{
			System.out.println("El sistema no encontro vehiculo");
		  return null;
		  }
	}

	public boolean revisaSolicitados() {
		int i = 0;
		System.out.println("El sistema esta buscando solicitados");
		while (i < getAdmin().getListaViajes().size() && !admin.getListaViajes().get(i).getEstado().equalsIgnoreCase("solicitado"))
			i++;
		if (i < getAdmin().getListaViajes().size())
		{
			System.out.println("El sistema encontro solicitados");
			return true;
		}		
		else
		{
			System.out.println("El sistema no encontro solicitados");
			return false;
		}	
	}

	public synchronized void asignaVehiculo(SistemaThread sistemaThread) {
		System.out.println("El sistema va a buscar solicitados");
		while (!revisaSolicitados())
			try {
				System.out.println("El sistema va a esperar solicitados");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int i = 0;
		
		while (i < getAdmin().getListaViajes().size() && !admin.getListaViajes().get(i).getEstado().equalsIgnoreCase("solicitado"))
			i++;
		IViaje viaje = admin.getListaViajes().get(i);
		System.out.println("El sistema tiene el viaje "+viaje);
		
		System.out.println("El sistema va a buscar vehiculos");
		Vehiculo vehi = sacarVehiculoDeDisponibles(viaje);
		while (vehi == null)
			try {
				System.out.println("El sistema va a esperar vehiculos");
				wait();
				vehi = sacarVehiculoDeDisponibles(viaje);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		viaje.setVehiculo(vehi);
		viaje.setEstado("con Vehiculo");
		System.out.println("El sistema asigno un vehiculos al viaje "+viaje);
		setChanged();
		notifyObservers(viaje);
		notifyAll();
		
		
	}

	public boolean existeNombreUsuarioHumano(Administrador a, String nombreUsuario)
	{
		return a.existeNombreUsuarioHumano(nombreUsuario);
	}
	
	public void terminoSimulacion()
	{
		notifyAll();
		
	}

	public boolean contraseniaCorrectaHumano(Administrador admin2, String nomUsua, String contr)
	{
		return admin2.contraseniaCorrectaHumano(nomUsua, contr);
	}
}
