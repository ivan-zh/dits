package z.ivan.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import z.ivan.service.user.UserStatisticService;

@Controller
public class UserStatisticController {
    private UserStatisticService userStatisticService;

    public UserStatisticController(UserStatisticService userStatisticService) {
        this.userStatisticService = userStatisticService;
    }

    @GetMapping("/user/personal_statistic")
    public String personalUserStatistic(ModelMap modelMap) {
        modelMap.addAttribute("statistic", userStatisticService.getPersonalUserStatistic());
        return "userUI/personal_statistic";
    }

    @GetMapping("/user/result_statistic")
    public String resultUserStatistic(ModelMap modelMap) {
        modelMap.addAttribute("statistic", userStatisticService.getResultUserStatistic());
        return "userUI/result_statistic";
    }
}
