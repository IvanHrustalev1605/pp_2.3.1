package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public void add(User user);
    public void deleteById(int id);
    public void update(int id);
    public <T>List<T> getAllUsers();
}