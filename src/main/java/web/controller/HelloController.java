package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class HelloController {
    @GetMapping
    public String index(ModelMap model) {
        String str = "Hello, it's my first CRUD app!";
        model.addAttribute("message", str);
        return "views/index";
    }
}
