package web.controller;

import net.bytebuddy.matcher.StringMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import service.UserServiceImpl;
import web.model.User;

@Controller
public class UserController {
    @GetMapping(value = "/users")
    public String printUser(ModelMap model) {
        UserService userService = new UserServiceImpl();
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @GetMapping(value = "/user/{id}")
    public String getOneUser(@PathVariable(value = "id") Long id,
                             Model model) {
        UserService userService = new UserServiceImpl();
        model.addAttribute("userById",userService.getUserById(id));
        return "oneUser";
    }
    @GetMapping("/users/addForm")
    public String show(Model model) {
        model.addAttribute("user", new User());
        return "userAddForm";
    }
    @PostMapping("/users/add")
    public String addUser(@ModelAttribute ("user") User user) {
        UserService userService = new UserServiceImpl();
        userService.add(user);
        return "redirect:/users";
    }
    @DeleteMapping(value = "/users/remove/{id}")
    public String deleteUser(
                             @PathVariable (value = "id") Long id) {
        UserService userService = new UserServiceImpl();
        userService.deleteById(id);
        return "redirect:/users";
    }
}
