package z.ivan.controller.tutor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import z.ivan.service.Tutor.StatisticsService;

@Controller
public class StatisticsController {

    private StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/tutor/statistics")
    public String tutorStatistics() {
        return "tutor/statistics";
    }

    @GetMapping("/tutor/statistics/test")
    public String testStatistics(ModelMap modelMap) {
        modelMap.addAttribute("stats", statisticsService.getTestStatistics());
        return "tutor/test_statistics";
    }

    @GetMapping("/tutor/statistics/question")
    public String questionStatistics(ModelMap modelMap) {
        modelMap.addAttribute("stats", statisticsService.getQuestionStatistics());
        return "tutor/question_statistics";
    }

    @GetMapping("/tutor/statistics/user")
    public String userStatistics(ModelMap modelMap) {
        modelMap.addAttribute("stats", statisticsService.getUserStatistics());
        return "tutor/user_statistics";
    }
}
