package clases;

/**
 * @author Ezequiel
 * <br>
 * Clase Abstracta que representa los usuarios pertenecientes al sistema desarrollado. Existen dos tipos de usuarios: Administrador y Cliente. <br>
 *
 */

public abstract class Usuario {

    protected String nombre;  // no se puede repetir un nombre de usuario
    protected String contrasena;
    protected String nombreReal;


    /**
     * Constructor con tres parametros para setear el nombre, nombreReal y contrase�a de un nuevo usuario. <br>
     *
     * <b>Pre: </b> Valores de los parametros String distintos de null, String nombre no se repite en ninguno de los usuarios ya existentes. <br>
     * <b>Post: </b> Se crea un nuevo Usuario en el sistema. <br>
     *
     * @param nombre: parametro de tipo String que representa nombre de usuario del Usuario dentro del sistema, debe ser unico para cada usuario. <br>
     * @param contrasena: parametro de tipo String que representa la contrase�a del Usuario dentro del sistema. Se utilizar� en la segunda parte para Login. <br>
     * @param nombreReal: parametro de tipo String que representa el nombre y apellio del Usuario. <br>
     *
     *
     */
    public Usuario(String nombre, String contrasena, String nombreReal) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.nombreReal= nombreReal;
    }

    public String getNombre() {
        return this.nombre;
    }
    public String getNombreReal() {
        return this.nombreReal;
    }


	/**
	 * Metodo que devuelve String con nombre de usuario y nombre real para poder listar los diferentes usuarios del sistema (Administradores o Clientes)
	 */
	@Override
	public String toString() {
		return  nombre + " \t \t " + nombreReal + "\n";
	}


}
