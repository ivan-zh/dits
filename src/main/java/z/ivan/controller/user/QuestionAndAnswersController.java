package z.ivan.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import z.ivan.service.user.QuestionAndAnswerService;
import z.ivan.service.user.TopicAndTestService;

@Controller
public class QuestionAndAnswersController {

    private TopicAndTestService topicAndTestService;
    private QuestionAndAnswerService questionAndAnswerService;

    public QuestionAndAnswersController(TopicAndTestService topicAndTestService, QuestionAndAnswerService questionAndAnswerService) {
        this.topicAndTestService = topicAndTestService;
        this.questionAndAnswerService = questionAndAnswerService;
    }

    @PostMapping("/user/question_and_answer")
    public String questionAndAnswer(ModelMap modelMap) {
        modelMap.addAttribute("topics", topicAndTestService.getTopicList());
        modelMap.addAttribute("tests", topicAndTestService.getTestList());
        modelMap.addAttribute("questions", topicAndTestService.getQuestionList());
        modelMap.addAttribute("answers", topicAndTestService.getAnswerList());
        return "userUI/question_and_answer";
    }
}
