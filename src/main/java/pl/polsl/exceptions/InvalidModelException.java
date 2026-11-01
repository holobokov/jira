package pl.polsl.exceptions;

/**
 * Indicates invalid data supplied to a domain model builder.
 *
 * @author Oleksandr Holobokov
 * @version 1.1
 */
public class InvalidModelException extends RuntimeException {

    /**
     * Creates an exception with a validation message.
     *
     * @param message validation error message
     */
    public InvalidModelException(String message) {
        super(message);
    }
}
