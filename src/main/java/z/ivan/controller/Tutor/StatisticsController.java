package z.ivan.controller.Tutor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tutor/statistics")
public class StatisticsController {

    @GetMapping("")
    public String tutorStatistics() {
        return "tutorUI/statistics";
    }

    @GetMapping("test")
    public String testStatistics(ModelMap modelMap) {
        modelMap.addAttribute("stats", null);
        return "tutorUI/test_statistics";
    }

    @GetMapping("question")
    public String questionStatistics() {
        return "tutorUI/question_statistics";
    }

    @GetMapping("user")
    public String userStatistics() {
        return "tutorUI/user_statistics";
    }
}
