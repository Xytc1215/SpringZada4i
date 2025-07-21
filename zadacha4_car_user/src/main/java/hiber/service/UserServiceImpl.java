package hiber.service;

import hiber.config.UserAlreadyExistsException;
import hiber.dao.UserDao;
import hiber.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Реализация сервисного слоя.
 * Делегирует работу DAO, управляет транзакциями и логирует операции.
 * Используется аннотация @Transactional.
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.findByEmail(user.getEmail()).ifPresent(existing -> {
            throw new UserAlreadyExistsException("User with email" + user.getEmail() + " already exists.");
        });

        userDao.addUser(user);
        log.info("Added user via service: {}", user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
        log.info("Updated user via service: {}", user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
        log.info("Deleted user via service, id: {}", id);
    }
}
