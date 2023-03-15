package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
//не могу понять почему update не обновляет а вставляет нового пользователя
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String index(ModelMap modelMap, User user) {
        List<User> userList = userServiceImpl.allUsers(user);
        modelMap.addAttribute("users", userList);
        return "views/users";
    }
    @Transactional
    @GetMapping(value = "/user/{id}")
    public String getOneUser(@PathVariable(value = "id") Long id,
                             Model model) {
        model.addAttribute("userById",userServiceImpl.getUserById(id));
        return "views/oneUser";
    }
    @Transactional
    @GetMapping("/users/addForm")
    public String show(Model model) {
        model.addAttribute("user", new User());
        return "views/userAddForm";
    }
    @Transactional
    @PostMapping("/users/add")
    public String addUser(@ModelAttribute ("user") User user) {
        userServiceImpl.create(user);
        return "redirect:/users";
    }
    @Transactional
    @RequestMapping(value = "/users/remove/{id}",  method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteUser(
            @PathVariable (value = "id") Long id) {
        userServiceImpl.delete(id);
        return "redirect:/users";
    }
    @RequestMapping(value = "user/edit/{id}", method = RequestMethod.GET)
    public String edit(ModelMap model, @ModelAttribute(value = "id") Long id) {
        model.addAttribute("user", userServiceImpl.getUserById(id));
        return "views/userUpdateForm";
    }
    @Transactional
    @PatchMapping(value = "user/{id}")
    public String updateUser(@ModelAttribute(value = "user") User user,
                             @PathVariable("id") Long id) {
        userServiceImpl.update(user, id);
        return "redirect:/users";
    }
}
