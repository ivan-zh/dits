package z.ivan.controller.displayTable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dao.TestDao;
import z.ivan.model.Test;

import java.util.Arrays;
import java.util.List;

@Controller
public class DisplayTest {

    private final TestDao testDao;

    public DisplayTest(TestDao testDao) {
        this.testDao = testDao;
    }

    @GetMapping(value = "/findtestbyid")
    public String findTestById(@RequestParam("id") Long id, ModelMap modelMap) {
        Test test = testDao.getById(id);
        modelMap.addAttribute("tests", Arrays.asList(test));
        return "display_table/alltests";
    }

    @GetMapping(value = "/findtestbytopicname")
    public String findTestByTopicName(@RequestParam("topicname") String topicName, ModelMap modelMap) {
        List<Test> tests = testDao.getByTopicName(topicName);
        modelMap.addAttribute("tests", tests);
        return "display_table/alltests";
    }

    @GetMapping(value = "/alltests")
    public String allTests(Model model) {
        List<Test> tests = testDao.getAll();
        model.addAttribute("tests", tests);
        return "display_table/alltests";
    }

}
