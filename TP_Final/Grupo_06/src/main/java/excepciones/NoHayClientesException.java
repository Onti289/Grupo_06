package excepciones;

public class NoHayClientesException extends Exception{
	public NoHayClientesException(String mensaje) {
        super(mensaje);
    }
}
