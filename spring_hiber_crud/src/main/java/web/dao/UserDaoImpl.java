package web.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Реализация интерфейса для доступа к данным пользователей
 * с использованием JPA и {@link EntityManager}.
 */
@Repository
@Slf4j
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Получить всех пользователей из базы данных.
     * @return список всех пользователей
     */
    @Override
    public List<User> getAll() {
        log.debug("Query all users from the Database");
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    /**
     * Сохранить нового пользователя в базу данных.
     * @param user пользователь для сохранения
     */
    @Override
    public void save(User user) {
        log.debug("Saving a new user: {}", user);
        entityManager.persist(user);
    }

    /**
     * Получить пользователя по его идентификатору.
     * @param id идентификатор пользователя
     * @return найденный пользователь или null, если не найден
     */
    @Override
    public User getById(Long id) {
        log.debug("Search user by id: {}", id);
        return entityManager.find(User.class, id);
    }

    /**
     * Обновить существующего пользователя.
     * @param user объект пользователя с обновлёнными данными
     */
    @Override
    public void update(User user) {
        log.debug("User update: {}", user);
        entityManager.merge(user);
    }

    /**
     * Удалить пользователя по его идентификатору.
     * @param id идентификатор пользователя
     */
    @Override
    public void delete(Long id) {
        log.debug("Attempt to delete user with id={}", id);
        User user = getById(id);
        if (user != null) {
            entityManager.remove(user);
            log.info("User with id={} deleted", id);
        } else {
            log.warn("Attempt to delete non-existent user with id={}", id);
        }
    }
}
