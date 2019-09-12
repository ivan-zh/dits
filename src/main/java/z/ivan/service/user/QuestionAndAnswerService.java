package z.ivan.service.user;

import org.springframework.stereotype.Service;
import z.ivan.dao.AnswerDao;
import z.ivan.dao.QuestionDao;
import z.ivan.model.Answer;
import z.ivan.model.Question;

import java.util.List;

@Service
public class QuestionAndAnswerService {

    private QuestionDao questionDao;
    private AnswerDao answerDao;

    public QuestionAndAnswerService(QuestionDao questionDao, AnswerDao answerDao) {
        this.questionDao = questionDao;
        this.answerDao = answerDao;
    }

    public List<Question> getByTestId(Long testId) {
        return questionDao.getByTestId(testId);
    }
    public List<Question> getQuestionList() {
        return questionDao.getAll();
    }


    public List<Answer> getAnswerList() {
        return answerDao.getAll();
    }

    public List<Question> getQuestionByQuestionId(Long testId, Long questionId){
        return questionDao.getQuestionByQuestionId(testId, questionId);
    }

   public List<Answer> getByAnswerId(Long questionId){
        return answerDao.getByAnswerId(questionId);
   }
}
