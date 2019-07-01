package z.ivan.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import z.ivan.model.Role;


@Controller
public class AdminController {

    /*
        @GetMapping(value = "create_test")
        public String createTest(Model model) {
            return "tutorUI/create_test";
        }
    */

    @GetMapping(value = "create_topic")
    public String createTest(Model model) {
        return "adminUI/create_topic";
    }

    @GetMapping(value = "create_user")
    public String createUser(Model model) {
        model.addAttribute("rolesNames", Role.getRolesNames());
        return "adminUI/create_user";
    }

    @GetMapping(value = "statistics")
    public String statistics(Model model) {
        return "tutorUI/statistics";
    }

}
