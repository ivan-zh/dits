package z.ivan.controller.displayTable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dao.LinkDao;
import z.ivan.model.Link;

import java.util.Arrays;
import java.util.List;

@Controller
public class DisplayLink {

    private final LinkDao linkDao;

    public DisplayLink(LinkDao linkDao) {
        this.linkDao = linkDao;
    }

    @GetMapping(value = "/findlinkbyid")
    public String findLinkById(@RequestParam("id") Long id, ModelMap modelMap) {
        Link links = linkDao.getById(id);
        modelMap.addAttribute("links", Arrays.asList(links));
        return "display_table/alllinks";
    }

    @GetMapping(value = "/alllinks")
    public String allLiteratures(Model model) {
        List<Link> links = linkDao.getAll();
        model.addAttribute("links", links);
        return "display_table/alllinks";
    }
}
