package z.ivan.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import z.ivan.service.user.PersonalStatisticServise;

@Controller
public class PersonalStatisticController {
    private PersonalStatisticServise personalStatisticServise;

    public PersonalStatisticController(PersonalStatisticServise personalStatisticServise) {
        this.personalStatisticServise = personalStatisticServise;
    }

    @GetMapping("/user/personal_statistic")
    public String personalUserStatistic(ModelMap modelMap) {
        modelMap.addAttribute("statistic", personalStatisticServise.getPersonalUserStatistic());
        return "userUI/personal_statistic";
    }
}
