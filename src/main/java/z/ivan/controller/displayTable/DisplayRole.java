package z.ivan.controller.displayTable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dao.RoleDao;
import z.ivan.model.Role;

import java.util.Arrays;
import java.util.List;

@Controller
public class DisplayRole {

    private final RoleDao roleDao;

    public DisplayRole(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @GetMapping(value = "/findrolebyid")
    public String findRoleById(@RequestParam("id") Long id, ModelMap modelMap) {
        Role role = roleDao.getById(id);
        modelMap.addAttribute("roles", Arrays.asList(role));
        return "display_table/allroles";
    }

    @GetMapping(value = "/allroles")
    public String allRoles(Model model) {
        List<Role> roles = roleDao.getAll();
        model.addAttribute("roles", roles);
        return "display_table/allroles";
    }
}
