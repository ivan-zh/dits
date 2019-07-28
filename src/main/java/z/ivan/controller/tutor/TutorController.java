package z.ivan.controller.tutor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TutorController {

    @GetMapping("/tutor/tutor_main")
    public String admin() {
        return "tutorUI/tutor_main";
    }

}
