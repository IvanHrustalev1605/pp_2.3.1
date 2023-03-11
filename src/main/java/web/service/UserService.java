package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public void add(User user);
    public void deleteById(Long id);
    public <T> T getUserById(Long id);
    public <T> List<T> getAllUsers();
}
