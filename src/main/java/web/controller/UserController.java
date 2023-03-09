package web.controller;

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
//        userService.add(new User("Ivan1", "Ivanov", 52, "1@test.com"));
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
@PostMapping
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("age") Integer age,
                          @RequestParam("email") String email,
                          Model model) {

        UserService userService = new UserServiceImpl();
        userService.add(new User(name, lastName, age, email));
        return "users";

    }
}
