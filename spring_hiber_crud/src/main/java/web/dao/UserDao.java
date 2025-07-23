package web.dao;

import web.model.User;
import java.util.List;

/**
 * DAO интерфейс для работы с пользователями в базе данных.
 */
public interface UserDao {
    List<User> getAll();
    void save(User user);
    User getById(Long id);
    void update(User user);
    void delete(Long id);
}
