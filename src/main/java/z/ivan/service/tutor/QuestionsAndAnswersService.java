package z.ivan.service.tutor;

import org.springframework.stereotype.Service;
import z.ivan.dao.AnswerDao;
import z.ivan.dao.QuestionDao;
import z.ivan.dto.AnswerEditDto;
import z.ivan.dto.QuestionEditDto;
import z.ivan.model.Answer;

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
            Long id = e.getId();
            switch (e.getAction()) {
                case "create":
                    id = questionDao.add(e.getQuestion());
                    break;
                case "delete":
                    questionDao.delete(e.getQuestion().getQuestionId());
                    id = 0L;
                    break;
                case "rename":
                    questionDao.update(e.getQuestion());
                    break;
                case "skip":
                    break;
            }
            if (!id.equals(0L)) {
                for (AnswerEditDto ae : e.getAnswers()) {
                    Answer answer = ae.getAnswer();
                    answer.setQuestionId(id);
                    switch (ae.getAction()) {
                        case "create":
                            answerDao.add(answer);
                            break;
                        case "delete":
                            answerDao.delete(answer.getAnswerId());
                            break;
                        case "rename":
                            answerDao.update(answer);
                            break;
                        case "skip":
                            break;
                    }
                }
            }
        }
    }
}
