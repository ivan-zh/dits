package z.ivan.controller.tutor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dto.QuestionEditDto;
import z.ivan.service.tutor.QuestionsAndAnswersService;
import z.ivan.service.tutor.TopicsAndTestsService;

import java.io.IOException;
import java.util.List;

@Controller
//@RequestMapping("/tutor/questions_and_answers")
public class QuestionsAndAnswersController {

    private TopicsAndTestsService topicsAndTestsService;
    private QuestionsAndAnswersService questionsAndAnswersService;

    public QuestionsAndAnswersController(TopicsAndTestsService topicsAndTestsService,
                                         QuestionsAndAnswersService questionsAndAnswersService) {
        this.topicsAndTestsService = topicsAndTestsService;
        this.questionsAndAnswersService = questionsAndAnswersService;
    }

    @GetMapping("/tutor/questions_and_answers")
    public String main(ModelMap modelMap) {
        modelMap.addAttribute("topics", topicsAndTestsService.getTopicList());
        modelMap.addAttribute("tests", topicsAndTestsService.getTestList());
        modelMap.addAttribute("questions", topicsAndTestsService.getQuestionList());
        modelMap.addAttribute("answers", topicsAndTestsService.getAnswerList());
        return "tutorUI/edit_questions_and_answers";
    }

    @PostMapping("/tutor/questions_and_answers")
    public String edit(ModelMap modelMap,
                       @RequestParam String questionEdit) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<QuestionEditDto> questionList = mapper.readValue(questionEdit, new TypeReference<List<QuestionEditDto>>() {
        });
        questionsAndAnswersService.edit(questionList, null);
        modelMap.addAttribute("topics", topicsAndTestsService.getTopicList());
        modelMap.addAttribute("tests", topicsAndTestsService.getTestList());
        modelMap.addAttribute("questions", topicsAndTestsService.getQuestionList());
        modelMap.addAttribute("answers", topicsAndTestsService.getAnswerList());
        return "tutorUI/edit_questions_and_answers";
    }
}
