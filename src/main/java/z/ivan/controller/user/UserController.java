package z.ivan.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user/user_main")
    public String user() {
        return "userUI/user_main";
    }

}
