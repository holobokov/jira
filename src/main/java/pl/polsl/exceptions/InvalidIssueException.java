package pl.polsl.exceptions;

public class InvalidIssueException extends RuntimeException {

    public InvalidIssueException(String message) {
        super(message);
    }
}
