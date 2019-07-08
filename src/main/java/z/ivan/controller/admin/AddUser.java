package z.ivan.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import z.ivan.dao.UserDao;
import z.ivan.model.User;

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
            @RequestParam("roleName") String roleName,
            ModelMap modelMap
    ) {
        int pwdHash = Objects.hashCode(password);
        password = new String();

        userDao.add(firstName, lastName, login, pwdHash, roleName);
        return "adminUI/admin_main";
    }

    @GetMapping(value = "edit_user/{userId}")
    public String editPage(@PathVariable String userId, ModelMap modelMap) {
        User user = userDao.getById(Long.valueOf(userId));
        modelMap.addAttribute("user", user);
        return "adminUI/edit_user";
    }

    @PostMapping(value = "/edit_user")
    public String editUser(@ModelAttribute("user") User user) {
        userDao.edit(user);
        return "requests";
    }
}
