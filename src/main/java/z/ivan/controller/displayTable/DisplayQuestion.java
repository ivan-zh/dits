package z.ivan.controller.displayTable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dao.QuestionDao;
import z.ivan.model.Question;

import java.util.Arrays;
import java.util.List;

@Controller
public class DisplayQuestion {

    private final QuestionDao questionDao;

    public DisplayQuestion(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @GetMapping("/display_table/findquestionbyid")
    public String findRoleById(@RequestParam("id") Long id, ModelMap modelMap) {
        Question question = questionDao.getById(id);
        modelMap.addAttribute("questions", Arrays.asList(question));
        return "display_table/allquestions";
    }

    @GetMapping("/display_table/allquestions")
    public String allQuestions(Model model) {
        List<Question> questions = questionDao.getAll();
        model.addAttribute("questions", questions);
        return "display_table/allquestions";
    }

}
