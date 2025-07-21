package hiber.service;

import hiber.model.User;
import java.util.List;
import java.util.Optional;

/**
 * Сервисный интерфейс для User.
 * Определяет бизнес-операции, абстрагируя контроллеры от DAO.
 */

public interface UserService {
    void addUser(User user);
    Optional<User> getUser(Long id);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(Long id);
}
