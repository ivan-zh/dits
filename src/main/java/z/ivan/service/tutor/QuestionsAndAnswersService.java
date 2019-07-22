package z.ivan.service.tutor;

import org.springframework.stereotype.Service;
import z.ivan.dao.AnswerDao;
import z.ivan.dao.QuestionDao;
import z.ivan.dto.AnswerEditDto;
import z.ivan.dto.QuestionEditDto;

import java.util.List;

@Service
public class QuestionsAndAnswersService {

    private QuestionDao questionDao;
    private AnswerDao answerDao;

    public QuestionsAndAnswersService(QuestionDao questionDao, AnswerDao answerDao) {
        this.questionDao = questionDao;
        this.answerDao = answerDao;
    }

    public void edit(List<QuestionEditDto> questionList, List<AnswerEditDto> answerList) {
        for (QuestionEditDto e : questionList) {
            Long id = e.getQuestion().getQuestionId();
            switch (e.getAction()) {
                case "create":
                    id = questionDao.add(e.getQuestion());
                    break;
                case "delete":
                    questionDao.delete(e.getQuestion().getQuestionId());
                    break;
                case "rename":
                    questionDao.update(e.getQuestion());
                    break;
                case "skip":
                    break;
            }
            /*for (AnswerEditDto ae : e.getAnswers()) {
                ae.getAnswer().setQuestionId(id);
                switch (ae.getAction()) {
                    case "create":
                        answerDao.add(ae.getAnswer());
                        break;
                    case "delete":
                        answerDao.delete(ae.getAnswer().getAnswerId());
                        break;
                    case "rename":
                        answerDao.update(ae.getAnswer());
                        break;
                    case "skip":
                        break;
                }
            }*/
        }
    }
}
