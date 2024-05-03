package excepciones;

public class NoHayChoferesDisponiblesException extends Exception {
    public NoHayChoferesDisponiblesException(String string, Throwable throwable, boolean b, boolean b1) {
        super(string, throwable, b, b1);
    }

    public NoHayChoferesDisponiblesException(Throwable throwable) {
        super(throwable);
    }

    public NoHayChoferesDisponiblesException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public NoHayChoferesDisponiblesException(String string) {
        super(string);
    }

    public NoHayChoferesDisponiblesException() {
        super();
    }
}
