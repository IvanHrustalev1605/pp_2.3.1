package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String index(ModelMap model) {
        String str = "Hello, it's my first CRUD app!";
        model.addAttribute("message", str);
        return "views/index";
    }
    @GetMapping("/users")
    public String index(ModelMap modelMap, User user) {
        List<User> userList = userService.allUsers(user);
        modelMap.addAttribute("users", userList);
        return "views/users";
    }
    @GetMapping(value = "/user/{id}")
    public String getOneUser(@PathVariable(value = "id") Long id,
                             Model model) {
        model.addAttribute("userById", userService.getUserById(id));
        return "views/oneUser";
    }

    @GetMapping("/users/addForm")
    public String show(Model model) {
        model.addAttribute("user", new User());
        return "views/userAddForm";
    }
    @PostMapping("/users/add")
    public String addUser(@ModelAttribute ("user") User user) {
        userService.create(user);
        return "redirect:/users";
    }
    //не пойму как исправить при DeleteMapping ошибка Request method 'GET' not supported
    @RequestMapping(value = "/users/remove/{id}", method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteUser(@PathVariable ("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
    @GetMapping(value = "user/edit/{id}")
    public String edit(ModelMap model, @ModelAttribute(value = "id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "views/userUpdateForm";
    }
    @PatchMapping(value = "user/{id}")
    public String updateUser(@ModelAttribute(value = "user") User user,
                             @PathVariable("id") Long id) {
        userService.update(user, id);
        return "redirect:/users";
    }
}
