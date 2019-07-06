package z.ivan.dao;

import z.ivan.model.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> getAll();

    Question getById(Long id);

    List<Question> getByTestId(Long testId);

    Long add(Long test, String description);
}
