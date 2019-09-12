package z.ivan.dao;

import z.ivan.model.Answer;

import java.util.List;

public interface AnswerDao extends CrudDao<Answer> {
    List<Answer> getByAnswerId(Long questionId);
}
