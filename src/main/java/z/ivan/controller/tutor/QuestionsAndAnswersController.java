package z.ivan.controller.tutor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import z.ivan.service.Tutor.TopicsAndTestsService;

@Controller
@RequestMapping("tutor/questions_and_answers")
public class QuestionsAndAnswersController {

    private TopicsAndTestsService topicsAndTestsService;

    public QuestionsAndAnswersController(TopicsAndTestsService topicsAndTestsService) {
        this.topicsAndTestsService = topicsAndTestsService;
    }

    @GetMapping("")
    public String main(ModelMap modelMap) {
        modelMap.addAttribute("topics", topicsAndTestsService.getTopicList());
        modelMap.addAttribute("tests", topicsAndTestsService.getTestList());
        modelMap.addAttribute("questions", topicsAndTestsService.getQuestionList());
        modelMap.addAttribute("answers", topicsAndTestsService.getAnswerList());
        return "tutorUI/edit_questions_and_answers";
    }

    @PostMapping("")
    public String edit(ModelMap modelMap) {
        modelMap.addAttribute("topics", topicsAndTestsService.getTopicList());
        modelMap.addAttribute("tests", topicsAndTestsService.getTestList());
        modelMap.addAttribute("questions", topicsAndTestsService.getQuestionList());
        return "tutorUI/edit_questions_and_answers";
    }
}
