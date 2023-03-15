package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public void create(User user);
    public List<User> allUsers(User user);
    public User getUserById(Long id);
    public void update(User user, Long id);
    public void delete(Long id);
}
