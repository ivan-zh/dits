package z.ivan.controller.displayTable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dao.TopicDao;
import z.ivan.model.Topic;

import java.util.Arrays;
import java.util.List;

@Controller
public class DisplayTopic {

    private final TopicDao topicDao;

    public DisplayTopic(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @GetMapping("/display_table/findtopicbyid")
    public String findTopicById(@RequestParam("id") Long id, ModelMap modelMap) {
        Topic topic = topicDao.getById(id);
        modelMap.addAttribute("topics", Arrays.asList(topic));
        return "display_table/alltopics";
    }

    @GetMapping("/display_table/alltopics")
    public String allTopics(Model model) {
        List<Topic> topics = topicDao.getAll();
        model.addAttribute("topics", topics);
        return "display_table/alltopics";
    }
}
