package hiber.dao;

import hiber.model.User;
import java.util.List;
import java.util.Optional;

/**
 * DAO-интерфейс для работы с сущностью User.
 * Определяет абстракции для CRUD-операций.
 */

public interface UserDao {
   void addUser(User user);
   Optional<User> getUser(Long id);
   List<User> getAllUsers();
   void updateUser(User user);
   void deleteUser(Long id);
   Optional<User> findByEmail(String email);


}
