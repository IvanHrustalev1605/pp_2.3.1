package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(ModelMap modelMap, User user) {
        modelMap.addAttribute("users", userService.allUsers(user));
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
    @PostMapping("/")
    public String addUser(@ModelAttribute ("user") User user) {
        userService.create(user);
        return "redirect:/";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable ("id") Long id) {
        userService.delete(id);
        return "redirect:/";
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
        return "redirect:/";
    }
}
