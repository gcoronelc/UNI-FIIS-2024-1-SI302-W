package pe.edu.uni.pedidoapp.exception;

public class ImporteException extends RuntimeException {

    public ImporteException() {
        super("Importe incorrecto.");
    }

    public ImporteException(String message) {
        super(message);
    }

}
