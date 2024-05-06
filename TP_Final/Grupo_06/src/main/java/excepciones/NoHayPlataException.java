package excepciones;

public class NoHayPlataException extends Exception {

	public NoHayPlataException() {
	}

	public NoHayPlataException(String message) {
		super(message);
	}

	public NoHayPlataException(Throwable cause) {
		super(cause);
	}

	public NoHayPlataException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoHayPlataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
