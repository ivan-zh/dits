package z.ivan.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import z.ivan.service.user.TopicAndTestService;

@Controller
public class TopicAndTestController {

  private TopicAndTestService topicAndTestService;

    public TopicAndTestController(TopicAndTestService topicAndTestService) {
        this.topicAndTestService = topicAndTestService;
    }

    @GetMapping("/user/select_topic_and_test")
    public String topicAndTest(ModelMap modelMap) {
        modelMap.addAttribute("topics", topicAndTestService.getTopicList());
        modelMap.addAttribute("tests", topicAndTestService.getTestList());
        return "userUI/select_topic_and_test";
    }
}
