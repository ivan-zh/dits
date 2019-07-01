package z.ivan.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dao.UserDao;

@Controller
public class AddUser {

    private UserDao userDao;

    public AddUser(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping(value = "add_user_to_db")
    public String addUser(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam("roleName") String roleName,
            ModelMap modelMap
    ) {
        userDao.add(firstName, lastName, login, password, roleName);
        return "adminUI/admin_main";
    }
}
