package domain.core.exception;

public class DomainException extends Exception {
    public DomainException(String s) {
        super(s);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
