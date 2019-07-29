package z.ivan.controller.admin;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dao.UserDao;
import z.ivan.model.Role;
import z.ivan.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminUserEditor {

    private UserDao userDao;

    private PasswordEncoder encoder;

    public AdminUserEditor(UserDao userDao, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.encoder = encoder;
    }

    @PostMapping("add_user_to_db")
    public String addUser(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam("roleName") String roleName
    ) {
        List<String> mapData = new ArrayList<>();

        mapData.add("");
        mapData.add(firstName);
        mapData.add(lastName);
        mapData.add(login);
        mapData.add(password);
        mapData.add(roleName);

        userDao.add(mapDataToUser(mapData));
        return "adminUI/admin_main";
    }

    @GetMapping("edit_user/{userId}")
    public String editPage(@PathVariable String userId, Model model) {
        User user = userDao.getById(Long.valueOf(userId));
        model.addAttribute("rolesNames", Role.getRolesNames());
        model.addAttribute("user", user);
        return "adminUI/edit_user";
    }

    @PostMapping("edit_user")
    public String editUser(
            @RequestParam("userId") String userId,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam("roleName") String roleName
    ) {
        List<String> mapData = new ArrayList<>();

        mapData.add(userId);
        mapData.add(firstName);
        mapData.add(lastName);
        mapData.add(login);
        mapData.add(password);
        mapData.add(roleName);
        userDao.update(mapDataToUser(mapData));
        return "adminUI/requests";
    }

    private User mapDataToUser(List<String> mapData) {
        User user = new User();

        if (!mapData.get(0).equals("")) {
            user.setUserId(Long.valueOf(mapData.get(0)));
        }

        user.setFirstName(mapData.get(1));
        user.setLastName(mapData.get(2));
        user.setLogin(mapData.get(3));

        int pwdHash = Integer.parseInt(encoder.encode(mapData.get(4)));
        user.setPassword(pwdHash);

        String roleName = mapData.get(5);
        int roleId;
        if ("Admin".equalsIgnoreCase(roleName)) {
            roleId = 1;
        } else if ("Tutor".equalsIgnoreCase(roleName)) {
            roleId = 2;
        } else {
            roleId = 3;
        }
        user.setRoleId(roleId);

        return user;
    }
}
