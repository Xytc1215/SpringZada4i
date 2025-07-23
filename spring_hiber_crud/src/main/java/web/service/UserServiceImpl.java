package web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.exception.UserNotFoundException;
import web.model.User;

import java.util.List;

/**
 * Реализация бизнес-логики управления пользователями.
 * Обрабатывает операции чтения, создания, обновления и удаления пользователей,
 * оборачивая их в транзакции и добавляя контроль ошибок.
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    /**
     * DAO-слой для доступа к данным пользователей через JPA.
     * Внедряется через конструктор благодаря Lombok (@RequiredArgsConstructor).
     */
    private final UserDao userDao;

    /**
     * Получает список всех пользователей из базы данных.
     * Используется для отображения в таблице на UI.
     */
    @Override
    public List<User> getAllUsers() {
        log.debug("Query all users");
        return userDao.getAll();
    }

    /**
     * Сохраняет нового пользователя в базе данных.
     * Валидация выполняется до вызова этого метода (в контроллере).
     */
    @Override
    public void saveUser(User user) {
        log.debug("Saving a user: {}", user);
        userDao.save(user);
    }

    /**
     * Получает пользователя по ID. Если пользователь не найден — выбрасывается исключение.
     * Это позволяет централизованно обрабатывать ошибку (например, через @ControllerAdvice).
     */
    @Override
    public User getUserById(Long id) {
        log.debug("Getting user by id: {}", id);
        User user = userDao.getById(id);
        if (user == null) {
            log.warn("User with id={} не найден", id);
            throw new UserNotFoundException(id);
        }
        return user;
    }

    /**
     * Обновляет существующего пользователя.
     * Проверяет наличие пользователя перед обновлением, чтобы избежать ошибок JPA.
     */
    @Override
    public void updateUser(User user) {
        log.debug("User update: {}", user);
        Long id = user.getId();
        if (id == null || userDao.getById(id) == null) {
            log.warn("Attempt to update non-existent user with id={}", id);
            throw new UserNotFoundException(id);
        }
        userDao.update(user);
    }

    /**
     * Удаляет пользователя по ID.
     * Предварительно проверяет существование пользователя, чтобы избежать ошибок при удалении.
     */
    @Override
    public void deleteUser(Long id) {
        log.debug("Deleting user with id: {}", id);
        User user = userDao.getById(id);
        if (user == null) {
            log.warn("Attempt to delete non-existent user with id={}", id);
            throw new UserNotFoundException(id);
        }
        userDao.delete(id);
    }
}
