package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public void create(User user);
    public List<User> allUsers(User user);
    public User getUserById(Long id);
    public void update(User user);
    public void delete(Long id);
}
