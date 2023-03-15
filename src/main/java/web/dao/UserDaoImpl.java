package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext()
    private EntityManager entityManager;
    @Override
    public void create(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Override
    public List<User> allUsers(User user) {
        List<User> userList = new ArrayList<>();
        String sql = "select user from User user";
        userList =entityManager.createQuery(sql).getResultList();
        return userList;
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user, Long id) {
        User userToUpdate = getUserById(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setAge(user.getAge());
        userToUpdate.setEmail(user.getEmail());
        entityManager.merge(userToUpdate);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
