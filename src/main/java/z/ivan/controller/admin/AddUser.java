package z.ivan.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dao.UserDao;

import java.util.Objects;

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
            @RequestParam("roleName") String roleName
    ) {
        int pwdHash = Objects.hashCode(password);
        password = new String();

        userDao.add(firstName, lastName, login, pwdHash, roleName);
        return "adminUI/admin_main";
    }

}
