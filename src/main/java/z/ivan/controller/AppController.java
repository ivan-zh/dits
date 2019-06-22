package z.ivan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import z.ivan.dao.UserDao;
import z.ivan.model.User;

import java.util.Arrays;
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
        model.addAttribute("loginname", "admin");
        return "main";
    }

    @PostMapping(value = "/login")
    public String loginController
            (
                    @RequestParam("loginname") String loginName,
                    @RequestParam("password") String password,
                    ModelMap modelMap
            ) {
        User user = userDao.getByLogin(loginName);
        String greetName = user.getFirstName().concat(" ").concat(user.getLastName());
        modelMap.addAttribute("greetname", greetName);
        return "requests";
    }

    @GetMapping(value = "/requests")
    public String readId() {
        return "requests";
    }

    @GetMapping(value = "/findbyid")
    public String findById(@RequestParam("id") Long id, ModelMap modelMap) {
        User user = userDao.getById(id);
        System.out.println(user);
        modelMap.addAttribute("users", Arrays.asList(user));
        return "allusers";
    }

    @GetMapping(value = "/allusers")
    public String allUsers(Model model) {
        List<User> users = userDao.getAll();
        model.addAttribute("users", users);
        return "allusers";
    }


}
