package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> allUsers(User user) {
        return entityManager.createQuery("select user from User user").getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void update(User user, Long id) {
        User userToUpdate = getUserById(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setAge(user.getAge());
        userToUpdate.setEmail(user.getEmail());
//        если оставить только merge не обновляет значение
        entityManager.merge(userToUpdate);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
