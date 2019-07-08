package z.ivan.service.Tutor;

import org.springframework.stereotype.Service;
import z.ivan.dao.QuestionDao;
import z.ivan.dao.TestDao;
import z.ivan.dao.TopicDao;
import z.ivan.model.Question;
import z.ivan.model.Test;
import z.ivan.model.Topic;

import java.util.List;

@Service
public class TopicsAndTestsService {

    private TopicDao topicDao;
    private TestDao testDao;
    private QuestionDao questionDao;

    public TopicsAndTestsService(TopicDao topicDao, TestDao testDao, QuestionDao questionDao) {
        this.topicDao = topicDao;
        this.testDao = testDao;
        this.questionDao = questionDao;
    }

    public List<Topic> getTopicList() {
        return topicDao.getAll();
    }

    public List<Test> getTestList() {
        return testDao.getAll();
    }

    public List<Question> getQuestionList() {
        return questionDao.getAll();
    }

    public void edit(Long topic, Long test, Long question, String topicName, String testName, String questionName) {
        if (topic == 0) {
            topic = topicDao.add(topicName, topicName);
        }
        if (test == 0) {
            test = testDao.add(topic, testName, testName);
        }
        if (question == 0) {
            question = questionDao.add(test, questionName);
        }
    }
}
