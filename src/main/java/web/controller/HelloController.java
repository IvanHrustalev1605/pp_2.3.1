package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping(value = "/")
    public String testHello(ModelMap model) {
        String str = "Hello, it's my first CRUD app!";
        model.addAttribute("message", str);
        return "index";
    }
}
