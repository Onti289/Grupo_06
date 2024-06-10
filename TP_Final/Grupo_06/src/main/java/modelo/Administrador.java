package modelo;

import excepciones.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author gc
 * <br>
 * Clase que extiende de Usuario que representa a los administradores dentro del sistema. Contiene nombre, nombreReal, contrase�a, colaChofer, colaVehiculos y listaCliente. <br>
 * <b>colaChofer: </b> parametro de tipo LinkedList que representa la cola de los choferes disponibles para realizar viajes. Los choferes pueden conducior cualquier tipo de vehiculo
 * (Moto, Automovil y Combi) y se van asignado a los distintos viajes en base a su posicion en la cola. <br>
 * <b>colaVehiculos: </b> parametro de tipo LinkedList que representa la cola de los vehiculos disponibles para realizar viajes. Los distintos tipos de vehiculos cuentan con diferentes caracteristicas
 * en cuanto a cantidad de pasajeros, pet friendly y carga de equipaje en baul. Tambien cuentan con un orden de prioridad para realizar viajes que cumplen con criterios para mas de un tipo de vehiculo:
 * las motos siempre estan primeras en orden de prioridad, seguidas por los automoviles y por ultimo las combis <br>
 * <b>listaCliente: </b> parametro de tipo LinkedList que representa la lista de clientes existentes dentro del sistema. <br>
 * <b>listaViajes: </b> parametro de tipo LinkedList que se encarga de almacenar el historico de todos los viajes realizados en el sistema. <br> 
 */
public class Administrador extends Usuario{
    private static LinkedList<Chofer> colaChoferes = new LinkedList<Chofer>();
    private static LinkedList<Vehiculo> colaVehiculosDisponibles = new LinkedList<Vehiculo>();
    private static LinkedList<Vehiculo> colaTotalVehiculos = new LinkedList<Vehiculo>();
    private static LinkedList<ClienteAbstracto> listaClientes = new LinkedList<ClienteAbstracto>();
    private static LinkedList<IViaje> listaViajes = new LinkedList<IViaje>();
    private static LinkedList<Pedido> listaPedidos = new LinkedList<Pedido>();
	private ClienteHumano clienteHumano;

    /**
     * Constructor con tres parametros para setear el nombre, nombreReal y contrase�a de un nuevo Administrador. <br>
     *
     *  <b>Pre: </b> Valores de los parametros String distintos de null, String nombre no se repite en ninguno de los usuarios ya existentes. <br>
     *  <b>Post: </b> Se crea un nuevo Administrador en el sistema. <br>
     *
     * Llama a constructor super(nombre, contrasena, nombreReal) de Usuario. <br>
     *
     */
    public Administrador(String nombre, String contrasena, String nombreReal) {
            super(nombre,contrasena,nombreReal);

    }

    public void agregaVehiculoATotal(Vehiculo v)
    {
      colaTotalVehiculos.add(v);
    }
    
    public void agregaPedido(Pedido p)
    {
      listaPedidos.add(p);
    }
    
    public Pedido sacaPedido()
    {
    	return listaPedidos.poll();
    }

    
    public LinkedList<Chofer> getColaChoferes() {
		return colaChoferes;
	}



	public LinkedList<Vehiculo> getColaVehiculosDisponibles() {
		return colaVehiculosDisponibles;
	}



	public LinkedList<ClienteAbstracto> getListaClientes() {
		return listaClientes;
	}



	public LinkedList<IViaje> getListaViajes() {
		return listaViajes;
	}

	
	/**
     * Metodo de tipo void que agrega un chofer a la colaChofer. El chofer es agregado al final de la cola. <br>
     *
     * <b>Pre: </b>parametro Chofer chofer distinto de null. El chofer a agregar no se encuentra en la lista. <br>
     * <b>Post: </b>Chofer nuevo agregado a su correspondiente cola en la ultima posicion. <br>
     *
     * @param chofer parametro de tipo Chofer que sera agregado al final de la cola correspondiente. <br>
     */
    public void AgregarChofer(Chofer chofer){
        colaChoferes.add(chofer);
    }

    
    
    /**
     * Metodo de tipo Chofer que saca de colaChofer al primer chofer de la misma. <br>
     * 
     * <b>Pre: </b>Existe por lo menos un chofer en la cola correspondiente. <br>
     *
     * @return Devuelve primer chofer de la cola correspondiente. <br>
     */
    public Chofer SacarChofer() {
    	return colaChoferes.poll();
    }

    /**
     * Metodo de tipo void que permite modificar los datos personales (DNI y nombre) de un determinado Chofer chofer. <br>
     *
     * <b>Pre: </b>parametro Chofer chofer distinto de null, parametros de tipo String dni y nombre distintos de "" y de null <br>
     *
     * @param chofer parametro de tipo Chofer que recibe el chofer el cual se le aplicar�n las modificaciones <br>
     * @param dni parametro de tipo String que contiene el DNI actualizado del chofer. <br>
     * @param nombre parametro de tipo String que contiene el nombre actualizado del chofer. <br>
     * 
     * @exception ChoferNoEncontradoException Excepcion lanzada cunado el Chofer c pasado por parametro no se encuentra dentro de la cola correspondiente. <br>
     */
    public void ModificaChofer(Chofer c,String nombre) throws ChoferNoExistenteException {
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < colaChoferes.size()) {
            Chofer aux = colaChoferes.get(i);
            if (aux.equals(c)) {
                colaChoferes.set(i, c);
                encontrado = true;
            }
            i++;
        }
        if (!encontrado) {
            throw new ChoferNoExistenteException("El Chofer no fue encontrado en la cola.");
        }
        colaChoferes.get(i).modificaChofer(nombre);
    }


    /**
     * Metodo de tipo void que agrega un nuevo vehiculo a colaVehiculos. El vehiculo es agregado al final de la cola. <br>
     *
     * <b>Pre: </b>parametro Vehiculo vehiculo distinto de null. Vehiculo a agregar no se encuentra previamente en la cola correspondiente. <br>
     * <b>Post: </b>Vehiculo nuevo agregado a su correspondiente cola en la ultima posicion. <br>	
     *
     * @param vehiculo parametro de tipo Vehiculo que sera agregado al final de la cola correspondiente. <br>
     */
    public void agregaVehiculoADisponibles(Vehiculo vehiculo)
    {
        colaVehiculosDisponibles.add(vehiculo);
    }

    /**
     * Metodo de tipo Vehiculo que saca de la colaVehiculos el primer vehiculo que mejor cumpla con las condiciones del Pedido p. <br>
     *
     * <b>Pre: </b>El Pedido p es distinto de null y existe al menos un vehiculo dentro de colaVehiculos que cumpla con las condiciones del pedido. <br>
     * <b>Post: </b>El vehiculo que mejor cumple con las condiciones del Pedido p se quita de la colaVehiculos y se devuelve como salida para ser asignado al viaje correspondiente. <br>
     *
     * @param p parametro de tipo Pedido que contiene las caracteristicas del pedido realizado por el cliente. <br>
     * @return v parametro de tipo Vehiculo que contiene el vehiculo que mejor cumple con las condiciones del pedido. <br>
     */
    public Vehiculo sacarVehiculoDeDisponibles(Pedido p){
    	Vehiculo v = null;
    	Vehiculo aux;

    	for(int i = 0; i<colaVehiculosDisponibles.size(); i++) {
    		aux = colaVehiculosDisponibles.get(i);
    		if(aux.cumpleCondicion(p)) {
    			if(v == null || !aux.beats(v))
    				v = aux;
    		}
    	}

	    colaVehiculosDisponibles.remove(colaVehiculosDisponibles.indexOf(v));
	    return v;
    }


	/**
	 * Metodo de tipo void que permite modificar los datos (patente) de un determinado Vehiculo v.
	 *
	 * @param v parametro de tipo Vehiculo que recibe el vehiculo al cual se le aplicar� la modificacion. <br>
	 * @param patente parametro de tipo String que recibe la patente actualizada del vehiculo. <br>
	 * 
	 * @exception VehiculoNoEncontradoException Excepcion lanzada cuando el Vehiculo v a modificar no se encuentra en la cola correspondiente. <br>
	 */
  
    public void modificaVehiculo(Vehiculo v, String patente) throws VehiculoNoEncontradoException {
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < colaVehiculosDisponibles.size()) {
            Vehiculo aux = colaVehiculosDisponibles.get(i);
            if (aux.equals(v)) {
                colaVehiculosDisponibles.set(i, v);
                encontrado = true;
            }
            i++;
        }
        if (!encontrado) {
            throw new VehiculoNoEncontradoException("El Vehiculo no fue encontrado en la cola.");
        }
        colaVehiculosDisponibles.get(i).setPatente(patente);
    }


	/**
	 * Metodo de tipo void que agrega un nuevo cliente a listaCliente. <br>
	 * <b>Pre: </b>Cliente c distinto de null. Cliente a agregar no se encuentra previamente en la lista correspondiente. <br>
	 * <b>Post: </b>Cliente nuevo agregado a su correspondiente lista. <br>
	 * 
	 * @param c parametro de tipo Cliente que contiene al nuevo cliente e agregar a la lista cosrrespondiente. <br>
	 */
	public void agregarCliente(ClienteAbstracto c) throws NombreDeUsuarioYaExistenteException{
		int i = 0;
		boolean resp = false;
		while (i < listaClientes.size() && !resp)
		  resp = listaClientes.get(i++).getNombre().equalsIgnoreCase(c.getNombre());
		if (!resp)
		  listaClientes.add(c);
		else
          throw new NombreDeUsuarioYaExistenteException("El nombre de usuario elegido ya existe");
	}

	/**
	 * Metodo de tipo void que elimina un cliente de la listaCliente en caso de darse de baja del sistema. <br>
	 * 
	 * <b>Pre: </b>Parametro de tipo Cliente c distinto de null. <br>
	 *
	 * 
	 * @throws NoHayClientesException Excepcion lanzada cuando no hay ningun cliente en la lista correspondiente. <br>
	 * @throws ClienteNoExistenteException Excepcion lanzada cuando el Cliente c pasado por parametro no existe en la lista correspondiente. <br> 
	 */

	public void sacaCliente(Cliente c) throws NoHayClientesException, ClienteNoExistenteException {
		if(listaClientes == null)
			throw new NoHayClientesException("No hay clientes en la lista");
		else {
			if(!this.existeCliente(c))
				throw new ClienteNoExistenteException("El cliente no existe en el listado");
			else
				listaClientes.remove(c);
		}
	}

	/**
	 * Metodo de tipo void que permite modificar los datos personales (nombre y contrasena) de un determinado Cliente cliente. <br>
     *
     * <b>Pre: </b>parametro Cliente cliente distinto de null, parametros de tipo String nombre, contrasena y nombreReal distintos de "" y de null <br>
     *
	 * @param cliente parametro de tipo Cliente que contiene el cliente al cual se le aplicar�n las modificaciones. <br>
	 * @param nombre parametro de tipo String que contiene el nombre de usuario actualizado del cliente. <br>
	 * @param contrasena parametro de tipo String que contiene la contrase�a actualizada del cliente. <br>
	 * @param nombreReal parametro de tipo String que contiene el nombre real actualizado del cliente. <br>
	 */
	
	/*public void ModificaCliente(Cliente c, String nombre, String contrasena) throws ClienteNoExistenteException {
	    int i = 0;
	    boolean encontrado = false;
	    while (!encontrado && i < listaClientes.size()) {
	        ClienteAbstracto aux = listaClientes.get(i);
	        if (aux.equals(c)) {
	            listaClientes.set(i, c);
	            encontrado = true;
	        }
	        i++;
	    }
	    if (!encontrado) {
	        throw new ClienteNoExistenteException("El Cliente no fue encontrado en la lista.");
	    }
	    listaClientes.get(i).modificaCliente(nombre,contrasena);
	}*/

    public ClienteAbstracto getCliente(String nombreUsuario)
    {
      ClienteAbstracto c = null;
      int i = 0, tope = Administrador.listaClientes.size();
	  while (i < tope && !Administrador.listaClientes.get(i).nombre.equals(nombreUsuario))
			i++;
	  c = Administrador.listaClientes.get(i);
      return c;
    }
	
	/**
	 * Metodo de tipo String que genera el listado de los diferentes choferes. Permite mostrar nombre, categoria a la que pertenece y su salario neto en fotmato de tabla por consola.
	 *
	 * @return salida: parametro de tipo String que devuleve cadena formateada lista para ser mostrada por consola con los datos mencionados anteriormente de los choferes.
	 */
	public String listarChoferes() {
		String salida = "Listado de choferes y salarios: \n";
		salida += "Nombre \t\t Tipo \t\tSalario neto/Ganancia viaje \n";
		for (Chofer chofer : colaChoferes) {
            salida += chofer.toString() + " \n";
        }
		return salida;
	}

	/**
	 * Metodo de tipo String que genera el listado de los diferentes clientes del sistema. Permite mostrar usuario y nombre real de cada uno en formato de tabla por consola. <br>
	 *
	 * @return salida: parametro de tipo String que devuelve cadena formateada lista para ser mostrada por consola con los datos mencionados anteriormente de los clientes. <br>
	 */
	public String listarCLientes() {
		String salida = "Listado de clientes: \n";
		salida += "Nombre usuario \t Nombre Real \n";
		for (ClienteAbstracto cliente : listaClientes) {
            salida += cliente.toString();
        }
		return salida;
	}

	

	/**
	 * Metodo de tipo String que genera el listado de los diferentes vehiculos del Sistema. Permite mostrar patente y tipo de vehiculo de cada uno en formato de tabla por consola. <br>
	 *
	 * @return salida parametro de tipo String que devuelve cadena formateada lista para ser mostradad por consola con los datos mencionados anteriormente de los vheiculos. <br>
	 */
	public String listarVehiculos() {
		String salida = "Listado de vehiculos: \n";
		salida += "Patente \t Tipo vehiculo \n";
		for (Vehiculo vehiculo : colaVehiculosDisponibles) {
            salida += vehiculo.toString() + "\n";
        }
		return salida;
	}

	/**
	 * Metodo de tipo double que permite calcular el salario de un Chofer c perteneciente al sistema. <br>
	 *
	 * <b>Pre: </b>Parametro de tipo Chofer c distinto de null y contenido en la lista correspondiente <br>
	 * 
	 * En caso de que el cliente sea Contratado, se debe recorrer la lista de viajes para conocer los montos de los valores de los mismos, sumarlos y asi aplicarle a dicha suma el porcentaje que le corresponde cobrar al chofer. <br>
	 *
	 * @param c parametro de tipo Chofer que contiene al chofer al cual se desea conocer el salario. <br>
	 * @return c.calculaSueldo(): Metodo de tipo double que devuelve el valor del salario del Chofer c, dependiendo del tipo del mismo. <br>
	 */
	public double calculoSalario(Chofer c) {
		if(c.getTipo().equalsIgnoreCase("Contratado")){
			double ganancia = 0;
			for(int i=0; i<listaViajes.size(); i++) {
				if(listaViajes.get(i).getChofer().equals(c)) {
					ganancia += listaViajes.get(i).getCosto();
				}
			}
			return c.calculaSueldo()*ganancia/100;
		}
		else {
			return c.calculaSueldo();
		}
	}

	/**
	 * Metodo de tipo double que calcula el total de los salarios de los choferes pertenecientes al sistema. <br>
	 *
	 * @return total: parametro de tipo double que acumula los salarios de los choferes. <br>
	 * 
	 */
	public double calculoSalarioTotal(){
		double total = 0.0;
		for (Chofer chofer : colaChoferes) {
			total += this.calculoSalario(chofer);
        }
		return total;
	}

	/**
	 * Metodo de tipo boolean que verifica que un determinado cliente pertenezca a la listaCliente. <br>
	 *
	 * <b>Pre: </b>Parametro de tipo Cliente c distinto de null. <br>
	 *
	 * @param c parametro de tipo Cliente que contiene al cliente el cual quiere determinarse si se encuentra dentro de la lista correspondiente. <br>
	 * @return this.listaCliente.contains(c): devuelve true en caso de que el Cliente c pertenezca a la listaCliente, false en caso contrario. <br>
	 */
	public boolean existeCliente(Cliente c) {
		return listaClientes.contains(c);
	}

	/**
	 * Metodo de tipo boolean que permite verificar que exista algun chofer disponible en la cola correspondiente. <br>
	 *
	 * @return !this.colaChofer.isEmpty(): en caso de que la cola este vacia, el metodo devolvera false, true en caso contrario. <br>
	 */
	public boolean isChoferDisponible() {
		return !this.colaChoferes.isEmpty();
	}

	/**
	 * Metodo de tipo boolean que evalua si los vehiculos disponibles en el sistema cumplen con undeterminado Pedido p. <br>
	 *
	 * <b>Pre: </b>Parametro de tipo Pedido p distinto de null. <br>
	 *
	 * @param p parametro de tipo Pedido que contiene la informacion necesaria para saber si alguno de los vehiculos de la cola comple con lo solicitado. <br>
	 * @return cond: parametro de tipo boolean que devuelve true en caso de que exista por lo menos un vehiculo que cumple con las condiciones del pedido, false en caso contrario. <br>
	 * Tener en cuenta que el metodo solo verifica si algun vehiculo cumple con las condiciones, eso no significa que el primer vehiculo encontrado que cumpla sea el que mejor cumple las condiciones. <br>
	 */
	public boolean vehiculoCumplePedido(Pedido p) {
		boolean cond = false;
		int i = 0;

		if(this.isVehiculoDisponible()) {
			while(!cond && i<colaTotalVehiculos.size()) {
				if(colaTotalVehiculos.get(i).cumpleCondicion(p))
					cond = true;
				i ++;
			}
		}
		return cond;
	}

	/**
	 * Metodo de tipo boolean que verifica si la colaVehiculos se encuentra vacia o existe algun vehiculo en la misma. <br>
	 *
	 * @return !this.colaVehiculos.isEmpty(): en caso de que la cola este vacia, el metodo devolvera false, true en caso contrario. <br>
	 */
	public boolean isVehiculoDisponible() {
		return !colaVehiculosDisponibles.isEmpty();
	}

	/**
	 * Metodo de tipo void que permite caluclar los puntos mensuales de cada uno de los choferes pertenecientes al sistema. <br>
	 *
	 * <b> Calculo de puntos:</b> se entregan 5 puntos por cada viaje realizado y se le otorgan 15 puntos extra al chofer con mas kilometros recorridos.
	 */
	public void calculoPuntosMes()
	{
		Chofer c = null;
		double max=-1;
		int j=-1;

		  for (int i=0; i < colaChoferes.size() ; i++)
		  {
			  c = colaChoferes.get(i);
			  c.setPuntos(c.getViajesMes()*5);
			  c.setViajesMes();
			  if (max < c.getKMrecorridosMes()) {
				  j = i;
				  max = c.getKMrecorridosMes();
			  }
			  c.setKMrecorridosMes();
		  }
		  if (j != -1)
			  colaChoferes.get(j).setPuntos(15);
	}
	
	/**
	 * Metodo de tipo void que permite agregar n nuevo Viaje a su lista correspondiente. <br>
	 * 
	 * <b>Pre: </b>Parametro de tipo IViaje viaje distinto de null. <br>
	 * <b>Post: </b>Viaje nuevo agregado a su correspondiente lista. <br>
	 * 
	 * @param viaje Parametro de tipo IViaje que sera agregado a la lista de los viajes realizados a traves del sistema. <br>
	 */
	public void agregarViaje(IViaje viaje) {
		listaViajes.add(viaje);
	}
	
	public IViaje sacarViaje() {
		return listaViajes.get(0);
	}

	/**
	 * Metodo de tipo String que devuleve una cadena tabulada para mostrar por consola el listado de todos los viajes realizados en el sistema en orden de meayor a menor costo. <br>
	 * El metodo utiliza un clon de la listaViajes para poder ordenar la misma sin modificar la original. Una vez generado el clon, se utiliza un ComparadorPorCosto que permite ordenar la lista clonada de viajes segun su costo de mayor a menor. <br>
	 * 
	 * @return salida Parametro de tipo String que contiene titulo, subtitulo y listado de viajes ordenados por costo de mayo a menor tabulados para ser mostrados en formato de lista por consola. <br>
	 */
	public String listarViajes() {
		IViaje viaje = null;
		String salida = "Listado de viajes ordenados por costo de viaje \n";
		salida += "Cliente" + 
				"\tChofer" +  
				"\t\tVehiculo" +  
				"\t\tCosto" +  
				"\t\tDistancia Real Recorrida" +  
				"\tPasajeros" + 
				"\tFecha\n";
		LinkedList<IViaje> listaViajesClon = (LinkedList<IViaje>) listaViajes.clone();
		Collections.sort(listaViajesClon, new ComparadorPorCosto());
		
		for(int i = 0; i<listaViajesClon.size(); i++) {
			viaje = listaViajesClon.get(i);
			salida += viaje.toString();
		}
		
		return salida;
	}
	
	/**
	 * Metodo de tipo String que devuleve una cadena tabulada para mostrar por consola el listado de todos los viajes realizados en el sistema por un determinado chofer en un determinado periodo de tiempo. <br>
	 * El metodo utuliza un DateTimeFormatter para poder transformar a cadena las fechas entre las cuales se va a solicitar el listado. <br>
	 * 
	 * <b>Pre: </b>parametro Chofer chofer distinto de null. Parametro fechaMinima contiene una fecha anterior a fechaMaxima, y ambas son fechas validas. <br>
	 * 
	 * @param chofer Parametro de tipo Chofer que contiene los datos del chofer del cual se quieren conocer sus viajes en el periodo fechaMinima/fechaMaxima. <br>
	 * @param fechaMinima Parametro de tipo LocalTimeDate que contiene la fecha inicial desde donde se generara el listado. <br>
	 * @param fechaMaxima Parametro de tipo LocalTimeDate que contiene la fecha final hasta la cual se generara el listado. <br>
	 * 
	 * @return salida: Parametro de tipo String que contiene titulo, subtitulo y listado de viajes realizados por el chofer en el periodo de tiempo indicado por las fechas ingreasadas por parametro. <br>
	 */
	public String listarViajesChofer(Chofer chofer, LocalDateTime fechaMinima, LocalDateTime fechaMaxima)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaMinimaLocalDate = fechaMinima.toLocalDate();
	    LocalDate fechaMaximaLocalDate = fechaMaxima.toLocalDate();
		String fechaMinimaTexto = fechaMinima.format(formatter);
		String fechaMaximaTexto = fechaMaxima.format(formatter);
		IViaje viaje = null;
		String salida = "Listado de viajes chofer: " + chofer.getNombre() + " en el periodo " + fechaMinimaTexto + "/" + fechaMaximaTexto + "\n";
		salida += "Cliente" + 
				"\tChofer" +  
				"\t\tVehiculo" +  
				"\t\tCosto" +  
				"\t\tDistancia Real Recorrida" +  
				"\tPasajeros" + 
				"\tFecha\n";
		
		for(int i = 0; i<listaViajes.size(); i++) {
			viaje = listaViajes.get(i);
			LocalDate fechaViaje = viaje.getFecha().toLocalDate();
			if (viaje.getChofer().equals(chofer) &&
		            ((viaje.getFecha().isAfter(fechaMinima) &&
		                    viaje.getFecha().isBefore(fechaMaxima)) ||
		            		fechaViaje.isEqual(fechaMinimaLocalDate) ||
		            		fechaViaje.isEqual(fechaMaximaLocalDate))) {
		        salida += viaje.toString();
		    }
		}
		return salida;
	}

	/**
	 * Metodo de tipo String que devuleve una cadena tabulada para mostrar por consola el listado de todos los viajes realizados en el sistema por un determinado cliente en un determinado periodo de tiempo. <br>
	 * El metodo utuliza un DateTimeFormatter para poder transformar a cadena las fechas entre las cuales se va a solicitar el listado. <br>
	 * 
	 * <b>Pre: </b>parametro Cliente cliente distinto de null. Parametro fechaMinima contiene una fecha anterior a fechaMaxima, y ambas son fechas validas. <br>
	 * 
	 * @param cliente Parametro de tipo Cliente que contiene los datos del cliente del cual se quieren conocer sus viajes en el periodo fechaMinima/fechaMaxima. <br>
	 * @param fechaMinima Parametro de tipo LocalTimeDate que contiene la fecha inicial desde donde se generara el listado. <br>
	 * @param fechaMaxima Parametro de tipo LocalTimeDate que contiene la fecha final hasta la cual se generara el listado. <br>
	 * 
	 * @return salida: Parametro de tipo String que contiene titulo, subtitulo y listado de viajes realizados por el cliente en el periodo de tiempo indicado por las fechas ingreasadas por parametro. <br>

	 */
	public String listarViajesCliente(Cliente cliente, LocalDateTime fechaMinima, LocalDateTime fechaMaxima) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaMinimaLocalDate = fechaMinima.toLocalDate();
	    LocalDate fechaMaximaLocalDate = fechaMaxima.toLocalDate();
		String fechaMinimaTexto = fechaMinima.format(formatter);
		String fechaMaximaTexto = fechaMaxima.format(formatter);
		IViaje viaje = null;
		String salida = "Listado de viajes cliente: " + cliente.getNombre() + " en el periodo " + fechaMinimaTexto + "/" + fechaMaximaTexto + "\n";
		salida += "Cliente" + 
				"\tChofer" +  
				"\t\tVehiculo" +  
				"\t\tCosto" +  
				"\t\tDistancia Real Recorrida" +  
				"\tPasajeros" + 
				"\tFecha\n";
		for(int i = 0; i<listaViajes.size(); i++) {
			viaje = listaViajes.get(i);
			LocalDate fechaViaje = viaje.getFecha().toLocalDate();
			if (viaje.getCliente().equals(cliente) &&
		            ((viaje.getFecha().isAfter(fechaMinima) &&
		                    viaje.getFecha().isBefore(fechaMaxima)) ||
		            		fechaViaje.isEqual(fechaMinimaLocalDate) ||
		            		fechaViaje.isEqual(fechaMaximaLocalDate))){
		        salida += viaje.toString();
		    }
		}
		return salida;
	}
	
	public String listarHistoricoViajesCliente(Cliente cliente) {
		
		IViaje viaje = null;
		String salida = "Listado de viajes cliente: " + cliente.getNombre() + "\n";
		salida += "Cliente" + 
				"\tChofer" +  
				"\t\tVehiculo" +  
				"\t\tCosto" +  
				"\t\tDistancia Real Recorrida" +  
				"\tPasajeros" + 
				"\tFecha\n";
		for(int i = 0; i<listaViajes.size(); i++) {
			viaje = listaViajes.get(i);
			if (viaje.getCliente().equals(cliente))
		    {
		        salida += viaje.toString();
		    }
		}
		return salida;
	}
	
	public boolean existeNombreUsuario(String nombre)
	{
		int i = 0, tope = Administrador.listaClientes.size();
		while (i < tope && !Administrador.listaClientes.get(i).nombre.equals(nombre))
			i++;
		return i < tope;
	}
	
	public boolean contraseniaCorrecta(String nombre, String contrasenia)
	{
		int i = 0, tope = Administrador.listaClientes.size();
		while (i < tope && !Administrador.listaClientes.get(i).nombre.equals(nombre))
			i++;
		return Administrador.listaClientes.get(i).contrasena.equals(contrasenia);
	}



	public void setClienteHumano(ClienteAbstracto cliente) {
		this.clienteHumano = (ClienteHumano)cliente;
		
	}



	public ClienteHumano getClienteHumano() {
		return this.clienteHumano;
	}
}
