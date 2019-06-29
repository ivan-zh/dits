package z.ivan.controller.Tutor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tutor/topics_and_tests")
public class TopicsAndTestsController {

    @GetMapping("")
    public void f() {

    }

}
