package hiber.dao;

import hiber.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Реализация DAO для работы с User.
 * Управляет сессиями Hibernate вручную и обрабатывает транзакции.
 * Все операции логируются.
 */

@Slf4j
@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            log.info("User saved: {}", user);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Failed to save user: {}", user, e);
            throw new RuntimeException("Error saving user", e);
        }
    }

    @Override
    public Optional<User> getUser(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(User.class, id));
        } catch (Exception e) {
            log.error("Failed to get user by id: {}", id, e);
            throw new RuntimeException("Error retrieving user", e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from User", User.class).list();
        } catch (Exception e) {
            log.error("Failed to get all users", e);
            throw new RuntimeException("Error getting user list", e);
        }
    }

    @Override
    public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            log.info("User updated: {}", user);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Failed to update user: {}", user, e);
            throw new RuntimeException("User update error", e);
        }
    }

    @Override
    public void deleteUser(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
                log.info("User deleted: {}", user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Failed to delete user by id: {}", id, e);
            throw new RuntimeException("Error deleting user", e);
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            User user = session
                    .createQuery("from User where email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
            return Optional.ofNullable(user);
        } catch (Exception e) {
            log.error("Failed to find user by email: {}", email, e);
            throw new RuntimeException("Error searching user by email", e);
        }
    }
}
