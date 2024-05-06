package excepciones;

public class NombreDeUsuarioYaExistenteException extends Exception {

	public NombreDeUsuarioYaExistenteException() {
	}

	public NombreDeUsuarioYaExistenteException(String message) {
		super(message);
	}

	public NombreDeUsuarioYaExistenteException(Throwable cause) {
		super(cause);
	}

	public NombreDeUsuarioYaExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public NombreDeUsuarioYaExistenteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
