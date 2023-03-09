package service;

import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    UserDao userDao = new UserDaoImpl();
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void update(int id) {

    }

    @Override
    public <T> List<T> getAllUsers() {
      return  userDao.getAllUsers();
    }
}
