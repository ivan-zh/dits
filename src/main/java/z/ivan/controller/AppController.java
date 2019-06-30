package z.ivan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dao.UserDao;
import z.ivan.model.User;

@Controller
public class AppController {

    private final UserDao userDao;

    public AppController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/")
    public String root(Model model) {
        model.addAttribute("loginname", "admin");
        return "loginpage";
    }

    @PostMapping(value = "/login")
    public String loginController
            (
                    @RequestParam("loginname") String loginName,
                    @RequestParam("password") String password,
                    ModelMap modelMap
            ) {
        User user = userDao.getByLogin(loginName);

        if (user.getRoleId() == 1) {
            String greetName = user.getFirstName().concat(" ").concat(user.getLastName());
            modelMap.addAttribute("greetname", greetName);
            return "adminUI/admin_main";
        } else if (user.getRoleId() == 2) {
            return "tutorUI/tutor_main";
        } else {
            return "requests";
        }
    }

    @GetMapping(value = "/requests")
    public String readId() {
        return "requests";
    }


}
