package z.ivan.controller.displayTable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dao.UserDao;
import z.ivan.model.User;

import java.util.Arrays;
import java.util.List;

@Controller
public class DisplayUser {

    private final UserDao userDao;

    public DisplayUser(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/finduserbyid")
    public String findUserById(@RequestParam("id") Long id, ModelMap modelMap) {
        User user = userDao.getById(id);
        modelMap.addAttribute("users", Arrays.asList(user));
        return "display_table/allusers";
    }

    @GetMapping(value = "/allusers")
    public String allUsers(Model model) {
        List<User> users = userDao.getAll();
        model.addAttribute("users", users);
        return "display_table/allusers";
    }
}
