package hiber.config;

/**
 * Кастомное исключение.
 * Используется, чтобы явно указать ситуацию, когда пользователь с таким email уже существует.
 */

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
