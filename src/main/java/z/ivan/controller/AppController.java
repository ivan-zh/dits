package z.ivan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dao.RoleDao;
import z.ivan.dao.TestDao;
import z.ivan.dao.TopicDao;
import z.ivan.dao.UserDao;
import z.ivan.model.Role;
import z.ivan.model.Test;
import z.ivan.model.Topic;
import z.ivan.model.User;

import java.util.Arrays;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TopicDao topicDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private TestDao testDao;

    public AppController() {
    }

//    public AppController(UserDao userDao) {
//        this.userDao = userDao;
//    }

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
        } else {
            return "requests";
        }
    }

    @GetMapping(value = "/requests")
    public String readId() {
        return "requests";
    }

    @GetMapping(value = "/finduserbyid")
    public String findUserById(@RequestParam("id") Long id, ModelMap modelMap) {
        User user = userDao.getById(id);
        modelMap.addAttribute("users", Arrays.asList(user));
        return "allusers";
    }

    @GetMapping(value = "/allusers")
    public String allUsers(Model model) {
        List<User> users = userDao.getAll();
        model.addAttribute("users", users);
        return "allusers";
    }

    @GetMapping(value = "/findtopicbyid")
    public String findTopicById(@RequestParam("id") Long id, ModelMap modelMap) {
        Topic topic = topicDao.getById(id);
        modelMap.addAttribute("topics", Arrays.asList(topic));
        return "alltopics";
    }

    @GetMapping(value = "/alltopics")
    public String allTopics(Model model) {
        List<Topic> topics = topicDao.getAll();
        model.addAttribute("topics", topics);
        return "alltopics";
    }

    @GetMapping(value = "/findrolebyid")
    public String findRoleById(@RequestParam("id") Long id, ModelMap modelMap) {
        Role role = roleDao.getById(id);
        modelMap.addAttribute("roles", Arrays.asList(role));
        return "allroles";
    }

    @GetMapping(value = "/allroles")
    public String allRoles(Model model) {
        List<Role> roles = roleDao.getAll();
        model.addAttribute("roles", roles);
        return "allroles";
    }

    @GetMapping(value = "/findtestbyid")
    public String findTestById(@RequestParam("id") Long id, ModelMap modelMap) {
        Test test = testDao.getById(id);
        modelMap.addAttribute("tests", Arrays.asList(test));
        return "alltests";
    }

    @GetMapping(value = "/findtestbytopicname")
    public String findTestByTopicName(@RequestParam("topicname") String topicName, ModelMap modelMap) {
        List<Test> tests = testDao.getByTopicName(topicName);
        modelMap.addAttribute("tests", tests);
        return "alltests";
    }

    @GetMapping(value = "/alltests")
    public String allTests(Model model) {
        List<Test> tests = testDao.getAll();
        model.addAttribute("tests", tests);
        return "alltests";
    }
}
