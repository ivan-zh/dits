package z.ivan.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    public AdminController() {}

    @GetMapping(value = "create_test")
    public String createTest(Model model) {
        return "adminUI/create_test";
    }

    @GetMapping(value = "create_user")
    public String createUser(Model model) {
        return "adminUI/create_user";
    }

    @GetMapping(value = "statistics")
    public String statistics(Model model) {
        return "adminUI/statistics";
    }

}
