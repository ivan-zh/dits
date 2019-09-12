package z.ivan.dao;

import z.ivan.model.Question;

import java.util.List;

public interface QuestionDao extends CrudDao<Question> {
    List<Question> getByTestId(Long testId);

    List<Question> getQuestionByQuestionId(Long testId, Long questionId);
}
