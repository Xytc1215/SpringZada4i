package web.exception;

/**
 * Исключение при передаче некорректного параметра count.
 */

public class InvalidCarCountException extends RuntimeException {
    public InvalidCarCountException(String message) {
        super(message);
    }
}
