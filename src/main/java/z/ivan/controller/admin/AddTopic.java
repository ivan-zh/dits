package z.ivan.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dao.TopicDao;

@Controller
public class AddTopic {

    private TopicDao topicDao;

    public AddTopic(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @PostMapping(value = "add_topic_to_db")
    public String addTopic(
            @RequestParam("description") String description,
            @RequestParam("name") String name,
            ModelMap modelMap
    ) {
        topicDao.add(description,name);
        return "adminUI/admin_main";
    }

}
