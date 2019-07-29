package z.ivan.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dao.TopicDao;
import z.ivan.model.Topic;

@Controller
public class AddTopic {

    private TopicDao topicDao;

    public AddTopic(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @PostMapping("add_topic_to_db")
    public String addTopic(
            @RequestParam("description") String description,
            @RequestParam("name") String name
    ) {
        Topic topic = new Topic();
        topic.setName(name);
        topic.setDescription(description);
        topicDao.add(topic);
        return "adminUI/admin_main";
    }

}
