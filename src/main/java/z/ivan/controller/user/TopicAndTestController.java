package z.ivan.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import z.ivan.service.user.TopicAndTestService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TopicAndTestController {

  private TopicAndTestService topicAndTestService;

    public TopicAndTestController(TopicAndTestService topicAndTestService){
        this.topicAndTestService = topicAndTestService;
    }

    @GetMapping("/user/select_topic_and_test")
    public String topicAndTest(ModelMap modelMap,
                               HttpServletRequest request) {
        request.getSession().setAttribute("questionId", 1);
        modelMap.addAttribute("topics", topicAndTestService.getTopicList());
        modelMap.addAttribute("tests", topicAndTestService.getTestList());
        return "userUI/select_topic_and_test";
    }
}
