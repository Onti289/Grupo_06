package clases;

import excepciones.*;

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
    private LinkedList<Chofer> colaChoferes;
    private LinkedList<Vehiculo> colaVehiculos;
    private LinkedList<Cliente> listaClientes;
    private LinkedList<IViaje> listaViajes;

    /**
     * Constructor con tres parametros para setear el nombre, nombreReal y contrase�a de un nuevo Administrador. <br>
     *
     *  <b>Pre: </b> Valores de los parametros String distintos de null, String nombre no se repite en ninguno de los usuarios ya existentes. <br>
     *  <b>Post: </b> Se crea un nuevo Administrador en el sistema. <br>
     *
     * Llama a constructor super(nombre, contrasena, nombreReal) de Usuario. <br>
     * Se instancian los parametros colaChoferes, colaVehiculos, listaClientes y listaViajes. <br>
     *
     */
    public Administrador(String nombre, String contrasena, String nombreReal) {
            super(nombre,contrasena,nombreReal);
            this.colaChoferes = new LinkedList<Chofer>();
            this.colaVehiculos = new LinkedList<Vehiculo>();
            this.listaClientes = new LinkedList<Cliente>();
            this.listaViajes = new LinkedList<IViaje>();
    }

    /**
     * Metodo de tipo void que agrega un chofer a la colaChofer. El chofer es agregado al final de la cola. <br>
     *
     * <b>Pre: </b>parametro Chofer chofer distinto de null. <br>
     *
     * @param chofer parametro de tipo Chofer que sera agregado al final de la cola correspondiente. <br>
     */
    public void AgregarChofer(Chofer chofer){
        this.colaChoferes.add(chofer);
    }

    /**
     * Metodo de tipo Chofer que saca de colaChofer al primer chofer de la misma. <br>
     *
     * @return Devuelve primer chofer de la cola correspondiente. <br>
     */
    public Chofer SacarChofer() {
    	return this.colaChoferes.poll();
    }

    /**
     * Metodo de tipo void que permite modificar los datos personales (DNI y nombre) de un determinado Chofer chofer. <br>
     *
     * <b>Pre: </b>parametro Chofer chofer distinto de null, parametros de tipo String dni y nombre distintos de "" y de null <br>
     *
     * @param chofer parametro de tipo Chofer que recibe el chofer el cual se le aplicar�n las modificaciones <br>
     * @param dni parametro de tipo String que contiene el DNI actualizado del chofer. <br>
     * @param nombre parametro de tipo String que contiene el nombre actualizado del chofer. <br>
     */
    public void ModificaChofer(Chofer c) throws ChoferNoEncontradoException {
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
            throw new ChoferNoEncontradoException("El Chofer no fue encontrado en la cola.");
        }
    }


    /**
     * Metodo de tipo void que agrega un nuevo vehiculo a colaVehiculos. El vehiculo es agregado al final de la cola. <br>
     *
     * <b>Pre: </b>parametro Vehiculo vehiculo distinto de null. <br>
     *
     * @param vehiculo parametro de tipo Vehiculo que sera agregado al final de la cola correspondiente. <br>
     */
    public void agregaVehiculo(Vehiculo vehiculo)
    {
        this.colaVehiculos.add(vehiculo);
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
    public Vehiculo sacarVehiculo(Pedido p){
    	Vehiculo v = null;
    	Vehiculo aux;

    	for(int i = 0; i<this.colaVehiculos.size(); i++) {
    		aux = this.colaVehiculos.get(i);
    		if(aux.cumpleCondicion(p)) {
    			if(v == null || aux.beats(v))
    				v = aux;
    		}
    	}

	    this.colaVehiculos.remove(this.colaVehiculos.indexOf(v));
	    return v;
    }


	/**
	 * Metodo de tipo void que permite modificar los datos (patente) de un determinado Vehiculo v.
	 *
	 * @param v parametro de tipo Vehiculo que recibe el vehiculo al cual se le aplicar� la modificacion. <br>
	 * @param patente parametro de tipo String que recibe la patente actualizada del vehiculo. <br>
	 */
    public void modificaVehiculo(Vehiculo v) throws VehiculoNoEncontradoException {
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < colaVehiculos.size()) {
            Vehiculo aux = colaVehiculos.get(i);
            if (aux.equals(v)) {
                colaVehiculos.set(i, v);
                encontrado = true;
            }
            i++;
        }
        if (!encontrado) {
            throw new VehiculoNoEncontradoException("El Vehiculo no fue encontrado en la cola.");
        }
    }


	/**
	 * Metodo de tipo void que agrega un nuevo cliente a listaCliente. <br>
	 *  <b>Pre: </b>Cliente c distinto de null. <br>
	 *
	 * @param c parametro de tipo Cliente que contiene al nuevo cliente e agregar a la lista cosrrespondiente. <br>
	 */
	public void agregarCliente(Cliente c) {
		this.listaClientes.add(c);

	}

	/**
	 * Metodo de tipo void que elimina un cliente de la listaCliente en caso de darse de baja del sistema. <br>
	 *
	 * @return this.listaCliente.poll()
	 * @throws NoHayClientesException
	 */
	//Modificar para sacar un Cliente c de la lista
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
	 * Metodo de tipo void que permite modificar los datos personales (nombre, contrasena y nombreReal) de un determinado Cliente cliente. <br>
     *
     * <b>Pre: </b>parametro Cliente cliente distinto de null, parametros de tipo String nombre, contrasena y nombreReal distintos de "" y de null <br>
     *
	 * @param cliente parametro de tipo Cliente que contiene el cliente al cual se le aplicar�n las modificaciones. <br>
	 * @param nombre parametro de tipo String que contiene el nombre de usuario actualizado del cliente. <br>
	 * @param contrasena parametro de tipo String que contiene la contrase�a actualizada del cliente. <br>
	 * @param nombreReal parametro de tipo String que contiene el nombre real actualizado del cliente. <br>
	 */
	public void ModificaCliente(Cliente c) throws ClienteNoEncontradoException {
	    int i = 0;
	    boolean encontrado = false;
	    while (!encontrado && i < listaClientes.size()) {
	        Cliente aux = listaClientes.get(i);
	        if (aux.equals(c)) {
	            listaClientes.set(i, c);
	            encontrado = true;
	        }
	        i++;
	    }
	    if (!encontrado) {
	        throw new ClienteNoEncontradoException("El Cliente no fue encontrado en la lista.");
	    }
	}


	/**
	 * Metodo de tipo String que genera el listado de los diferentes choferes. Permite mostrar nombre, categoria a la que pertenece y su salario neto en fotmato de tabla por consola.
	 *
	 * @return salida: parametro de tipo String que devuleve cadena formateada lista para ser mostrada por consola con los datos mencionados anteriormente de los choferes.
	 */
	public String listarChoferes() {
		String salida = "Listado de choferes y salarios: \n";
		salida += "Nombre \t Tipo \t Salario neto/Ganancia viaje \n";
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
		for (Cliente cliente : listaClientes) {
            salida += cliente.toString();
        }
		return salida;
	}

	//Falta listado de viajes chofer y viajes clientes, deberian tener ellos guardado un historico de sus propios viajes?

	/**
	 * Metodo de tipo String que genera el listado de los diferentes vehiculos del Sistema. Permite mostrar patente y tipo de vehiculo de cada uno en formato de tabla por consola. <br>
	 *
	 * @return salida parametro de tipo String que devuelve cadena formateada lista para ser mostradad por consola con los datos mencionados anteriormente de los vheiculos. <br>
	 */
	public String listarVehiculos() {
		String salida = "Listado de vehiculos: \n";
		salida += "Patente \t Tipo vehiculo \n";
		for (Vehiculo vehiculo : colaVehiculos) {
            salida = vehiculo.toString();
        }
		return salida;
	}

	/**
	 * Metodo de tipo double que permite calcular el salario de un Chofer c perteneciente al sistema. <br>
	 *
	 * @param c parametro de tipo Chofer que contiene al chofer al cual se desea conocer el salario. <br>
	 * @return c.calculaSueldo(): Metodo de tipo double que devuelve el valor del salario del Chofer c, dependiendo del tipo del mismo.
	 * @throws NoHayChoferesDisponiblesException Excepcion lanzada por el metodo en caso de que la lista de choferes se encuentre vacia
	 */
	public double calculoSalario(Chofer c) throws ChoferNoExistenteException{
		if(!colaChoferes.contains(c)) {
			throw new ChoferNoExistenteException("El chofer buscado no existe"); //Creo que siempre va a existir el chofer en este caso, no se me ocurre en que situacion podria no existir
		}
		else {
			return c.calculaSueldo();
		}
	}

	/**
	 * Metodo de tipo double que calcula el total de los salarios de los choferes pertenecientes al sistema. <br>
	 *
	 * @return total: parametro de tipo double que acumula los salarios de los choferes. <br>
	 */
	public double calculoSalarioTotal() {
		double total = 0.0;
		for (Chofer chofer : colaChoferes) {
			total += chofer.calculaSueldo();
        }
		return total;
	}

	/**
	 * Metodo de tipo boolean que verifica que un determinado cliente pertenezca a la listaCliente. <br>
	 *
	 * @param c parametro de tipo Cliente que contiene al cliente el cual quiere determinarse si se encuentra dentro de la lista correspondiente. <br>
	 * @return this.listaCliente.contains(c): devuelve true en caso de que el Cliente c pertenezca a la listaCliente, false en caso contrario. <br>
	 */
	public boolean existeCliente(Cliente c) {
		return this.listaClientes.contains(c);
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
	 * @param p parametro de tipo Pedido que contiene la informacion necesaria para saber si alguno de los vehiculos de la cola comple con lo solicitado. <br>
	 * @return cond: parametro de tipo boolean que devuelve true en caso de que exista por lo menos un vehiculo que cumple con las condiciones del pedido, false en caso contrario. <br>
	 * Tener en cuenta que el metodo solo verifica si algun vehiculo cumple con las condiciones, eso no significa que el primer vehiculo encontrado que cumpla sea el que mejor cumple las condiciones. <br>
	 */
	public boolean vehiculoCumplePedido(Pedido p) {
		boolean cond = false;
		int i = 0;

		if(this.isVehiculoDisponible()) {
			while(!cond && i<this.colaVehiculos.size()) {
				if(this.colaVehiculos.get(i).cumpleCondicion(p))
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
		return !this.colaVehiculos.isEmpty();
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

		  for (int i=0; i < this.colaChoferes.size() ; i++)
		  {
			  c = this.colaChoferes.get(i);
			  c.setPuntos(c.getViajesMes()*5);
			  c.setViajesMes();
			  if (max < c.getKMrecorridosMes()) {
				  j = i;
				  max = c.getKMrecorridosMes();
			  }
			  c.setKMrecorridosMes();
		  }
		  if (j != -1)
			  this.colaChoferes.get(j).setPuntos(15);
	}
	
	public void agregarViaje(IViaje viaje) {
		this.listaViajes.add(viaje);
	}

	public String listarViajes() {
		IViaje viaje = null;
		String salida = "Listado de viajes ordenados por costo de viaje";
		salida += "Cliente" + 
				"\t Chofer" +  
				"\t Vehiculo" +  
				"\t Costo" +  
				"\t Distancia Real Recorrida" +  
				"\t Pasajeros" + 
				"\t Fecha\n";
		LinkedList<IViaje> listaViajesClon = (LinkedList<IViaje>) this.listaViajes.clone();
		Collections.sort(listaViajesClon, new ComparadorPorCosto());
		
		for(int i = 0; i<listaViajesClon.size(); i++) {
			viaje = listaViajesClon.get(i);
			salida += viaje.toString();
		}
		
		return salida;
	}
	
	public String listarViajesChofer(Chofer chofer, LocalDateTime fechaMinima, LocalDateTime fechaMaxima)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fechaMinimaTexto = fechaMinima.format(formatter);
		String fechaMaximaTexto = fechaMaxima.format(formatter);
		IViaje viaje = null;
		String salida = "Listado de viajes chofer: " + chofer.getNombre() + " en el periodo " + fechaMinimaTexto + "/" + fechaMaximaTexto + "\n";
		salida += "Cliente" + 
				"\t Chofer" +  
				"\t Vehiculo" +  
				"\t Costo" +  
				"\t Distancia Real Recorrida" +  
				"\t Pasajeros" + 
				"\t Fecha\n";
		
		for(int i = 0; i<this.listaViajes.size(); i++) {
			viaje = this.listaViajes.get(i);
			if(viaje.getChofer().equals(chofer) && 
				viaje.getFecha().isAfter(fechaMinima) &&
				viaje.getFecha().isBefore(fechaMaxima)) {
				salida += viaje.toString();
			}
		}
		return salida;
	}

	public String listarViajesCliente(Cliente cliente, LocalDateTime fechaMinima, LocalDateTime fechaMaxima) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fechaMinimaTexto = fechaMinima.format(formatter);
		String fechaMaximaTexto = fechaMaxima.format(formatter);
		IViaje viaje = null;
		String salida = "Listado de viajes cliente: " + cliente.getNombre() + " en el periodo " + fechaMinimaTexto + "/" + fechaMaximaTexto + "\n";
		salida += "Cliente" + 
				"\t Chofer" +  
				"\t Vehiculo" +  
				"\t Costo" +  
				"\t Distancia Real Recorrida" +  
				"\t Pasajeros" + 
				"\t Fecha\n";
		
		for(int i = 0; i<this.listaViajes.size(); i++) {
			viaje = this.listaViajes.get(i);
			if(viaje.getCliente().equals(cliente) && 
				viaje.getFecha().isAfter(fechaMinima) &&
				viaje.getFecha().isBefore(fechaMaxima)) {
				salida += viaje.toString();
			}
		}
		return salida;
	}
	
}
