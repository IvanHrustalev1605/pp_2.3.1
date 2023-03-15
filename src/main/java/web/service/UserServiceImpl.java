package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoImpl userDaoImpl;

    @Override
    public void create(User user) {
        userDaoImpl.create(user);
    }

    @Override
    public List<User> allUsers(User user) {
        return userDaoImpl.allUsers(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDaoImpl.getUserById(id);
    }

    @Override
    public void update(User user, Long id) {
        userDaoImpl.update(user, id);
    }

    @Override
    public void delete(Long id) {
        userDaoImpl.delete(id);
    }
}
