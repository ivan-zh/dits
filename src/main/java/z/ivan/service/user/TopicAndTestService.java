package z.ivan.service.user;

import org.springframework.stereotype.Service;
import z.ivan.dao.AnswerDao;
import z.ivan.dao.QuestionDao;
import z.ivan.dao.TestDao;
import z.ivan.dao.TopicDao;
import z.ivan.dto.TestEditDto;
import z.ivan.model.Answer;
import z.ivan.model.Question;
import z.ivan.model.Test;
import z.ivan.model.Topic;

import java.util.List;

@Service
public class TopicAndTestService {
    private TopicDao topicDao;
    private TestDao testDao;
    private QuestionDao questionDao;
    private AnswerDao answerDao;

    public TopicAndTestService(TopicDao topicDao, TestDao testDao, QuestionDao questionDao, AnswerDao answerDao) {
        this.topicDao = topicDao;
        this.testDao = testDao;
        this.questionDao = questionDao;
        this.answerDao = answerDao;
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

    public List<Answer> getAnswerList() {
        return answerDao.getAll();
    }
}
