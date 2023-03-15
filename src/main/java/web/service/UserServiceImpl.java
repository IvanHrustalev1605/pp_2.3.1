package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public List<User> allUsers(User user) {
        return userDao.allUsers(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void update(User user, Long id) {
        userDao.update(user, id);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}
