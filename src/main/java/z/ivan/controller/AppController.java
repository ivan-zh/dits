package z.ivan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping(value = "/")
    public String root(Model model) {
        model.addAttribute("login", "admin_R");
        return "main";
    }

}
