package z.ivan.controller.displayTable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dao.LiteratureDao;
import z.ivan.model.Literature;
import z.ivan.model.Question;

import java.util.Arrays;
import java.util.List;

@Controller
public class DisplayLiterature {

    private final LiteratureDao literatureDao;

    public DisplayLiterature(LiteratureDao literatureDao) {
        this.literatureDao = literatureDao;
    }

    @GetMapping("/display_table/findliteraturebyid")
    public String findLiteratureById(@RequestParam("id") Long id, ModelMap modelMap) {
        Literature literature = literatureDao.getById(id);
        modelMap.addAttribute("literature", Arrays.asList(literature));
        return "display_table/allliteratures";
    }

    @GetMapping("/display_table/allliteratures")
    public String allLiteratures(Model model) {
        List<Literature> literature = literatureDao.getAll();
        model.addAttribute("literature", literature);
        return "display_table/allliteratures";
    }

}
