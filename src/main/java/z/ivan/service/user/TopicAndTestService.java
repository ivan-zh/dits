package z.ivan.service.user;

import org.springframework.stereotype.Service;
import z.ivan.dao.TestDao;
import z.ivan.dao.TopicDao;

@Service
public class TopicAndTestService {
    private TopicDao topicDao;
    private TestDao testDao;

    public TopicAndTestService(TopicDao topicDao, TestDao testDao) {
        this.topicDao = topicDao;
        this.testDao = testDao;
    }
}
