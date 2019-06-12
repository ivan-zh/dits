package z.ivan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import z.ivan.dao.UserDao;
import z.ivan.model.User;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserDao userDao;

    public AppController() {
    }

    public AppController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/")
    public String root(Model model) {
        model.addAttribute("login", "admin_R");
        return "main";
    }

    @GetMapping(value = "/tables")
    public String drawTables(Model model) {
        List<User> users = userDao.getAll();
        model.addAttribute("users", users);
        return "tables";
    }


}
