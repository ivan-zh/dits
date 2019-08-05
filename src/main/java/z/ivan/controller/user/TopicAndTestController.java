package z.ivan.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopicAndTestController {
    @GetMapping("/user/select_topic_and_test")
    public String topicAndTest(ModelMap modelMap) {
      //  modelMap.addAttribute("stats", personalStatisticServise.getPersonalUserStatistic());
        return "userUI/select_topic_and_test";
    }
}
