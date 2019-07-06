package z.ivan.controller.tutor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.service.Tutor.TopicsAndTestsService;

@Controller
@RequestMapping("tutor/topics_and_tests")
public class TopicsAndTestsController {

    private TopicsAndTestsService topicsAndTestsService;

    public TopicsAndTestsController(TopicsAndTestsService topicsAndTestsService) {
        this.topicsAndTestsService = topicsAndTestsService;
    }

    @GetMapping("")
    public String main(ModelMap modelMap) {
        modelMap.addAttribute("topics", topicsAndTestsService.getTopicList());
        modelMap.addAttribute("tests", topicsAndTestsService.getTestList());
        modelMap.addAttribute("questions", topicsAndTestsService.getQuestionList());
        return "tutorUI/edit_topics_and_tests";
    }

    @PostMapping("edit")
    public String edit(
            @RequestParam Long topic, @RequestParam Long test, @RequestParam Long question,
            @RequestParam String topicName, @RequestParam String testName, @RequestParam String questionName
    ) {
        topicsAndTestsService.edit(topic, test, question, topicName, testName, questionName);
        return "tutorUI/edit_topics_and_tests";
    }

}
