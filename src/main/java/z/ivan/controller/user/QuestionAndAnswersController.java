package z.ivan.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import z.ivan.dao.UserDao;
import z.ivan.dao.impl.UserDaoImpl;
import z.ivan.model.Answer;
import z.ivan.model.Question;
import z.ivan.model.User;
import z.ivan.service.user.QuestionAndAnswerService;
import z.ivan.service.user.TopicAndTestService;
import z.ivan.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class QuestionAndAnswersController {

    private TopicAndTestService topicAndTestService;
    private QuestionAndAnswerService questionAndAnswerService;
    private UserService userService;

    public QuestionAndAnswersController(TopicAndTestService topicAndTestService, QuestionAndAnswerService questionAndAnswerService, UserService userService) {
        this.topicAndTestService = topicAndTestService;
        this.questionAndAnswerService = questionAndAnswerService;
        this.userService = userService;
    }

    @GetMapping("/user/select_topic_and_test_start")
public String selectTest(
        ModelMap modelMap,
        @RequestParam  String testId,
        @SessionAttribute(name = "questionId") String questionId,
        @SessionAttribute(name = "login") String login,
         HttpServletRequest request) {
    User user = userService.getByLogin(login);
    Long userId = user.getUserId();
    Long testIdUser = Long.parseLong(testId) ;
  //  Long questionIdUser = Long.parseLong(questionId);

    List<Question> question = questionAndAnswerService.getByTestId(testIdUser);

    int count = question.size();
        System.out.println(count);
        List<Answer> answer = questionAndAnswerService.getAnswerList();
   // List<Answer> answer = questionAndAnswerService.getByAnswerId(questionIdUser);
   // List<Question> questionByTestIdAndQuestionId = questionAndAnswerService.getQuestionByQuestionId(testIdUser, questionIdUser);

    request.getSession().setAttribute("userId", userId);
    modelMap.addAttribute("testId", testId);
    modelMap.addAttribute("questions", question);
    modelMap.addAttribute("answers", answer);
   // request.getSession().setAttribute("questionId", questionId + 1);


    return "userUI/question_and_answer";
}

@PostMapping("/user/question_and_answer")
    public String test(ModelMap modelMap,
                       @RequestParam  String testId,
                       @SessionAttribute(name = "questionId") String questionId,
                       HttpServletRequest request){
    System.out.println();
       return "userUI/question_and_answer";
}
}
