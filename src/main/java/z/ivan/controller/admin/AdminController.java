package z.ivan.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import z.ivan.model.Role;


@Controller
public class AdminController {

    @GetMapping("/admin/create_topic")
    public String createTopic(Model model) {
        return "admin/create_topic";
    }

    @GetMapping("/admin/create_user")
    public String createUser(Model model) {
        model.addAttribute("rolesNames", Role.getRolesNames());
        return "admin/create_user";
    }

    @GetMapping("/admin/admin_main")
    public String admin() {
        return "admin/admin_main";
    }

    @GetMapping("/admin/requests")
    public String requests() {
        return "admin/requests";
    }

}
