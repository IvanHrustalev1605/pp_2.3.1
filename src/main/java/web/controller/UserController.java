package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;
import service.UserServiceImpl;
import web.model.User;

@Controller
public class UserController {
    @GetMapping(value = "/users")
    public String printUser(ModelMap model) {
        UserService userService = new UserServiceImpl();
//        userService.add(new User("Ivan1", "Ivanov", 52, "1@test.com"));
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @RequestMapping(value="/users/delete/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id) {
        UserService userService = new UserServiceImpl();
        userService.deleteById(id);
        return "users";
    }
}
