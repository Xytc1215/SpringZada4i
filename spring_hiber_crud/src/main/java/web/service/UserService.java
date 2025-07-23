package web.service;

import web.model.User;
import java.util.List;

/**
 * Сервисный интерфейс для управления пользователями.
 */
public interface UserService {

    /**
     * Получить список всех пользователей.
     */
    List<User> getAllUsers();

    /**
     * Сохранить нового пользователя.
     * @param user пользователь для сохранения
     */
    void saveUser(User user);

    /**
     * Получить пользователя по id.
     * @param id идентификатор пользователя
     * @return найденный пользователь
     * @throws web.exception.UserNotFoundException если пользователь не найден
     */
    User getUserById(Long id);

    /**
     * Обновить данные пользователя.
     * @param user пользователь с обновленными данными
     * @throws web.exception.UserNotFoundException если пользователь не найден
     */
    void updateUser(User user);

    /**
     * Удалить пользователя по id.
     * @param id идентификатор пользователя
     * @throws web.exception.UserNotFoundException если пользователь не найден
     */
    void deleteUser(Long id);
}
