package z.ivan.controller.Tutor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import z.ivan.service.Tutor.StatisticsService;

@Controller
@RequestMapping("tutor/statistics")
public class StatisticsController {

    private StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("")
    public String tutorStatistics() {
        return "tutorUI/statistics";
    }

    @GetMapping("test")
    public String testStatistics(ModelMap modelMap) {
        modelMap.addAttribute("stats", statisticsService.getTestStatistics());
        return "tutorUI/test_statistics";
    }

    @GetMapping("question")
    public String questionStatistics(ModelMap modelMap) {
        modelMap.addAttribute("stats", statisticsService.getQuestionStatistics());
        return "tutorUI/question_statistics";
    }

    @GetMapping("user")
    public String userStatistics(ModelMap modelMap) {
        modelMap.addAttribute("stats", statisticsService.getUserStatistics());
        return "tutorUI/user_statistics";
    }
}
