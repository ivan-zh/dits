package z.ivan.dao;

import z.ivan.model.Literature;

import java.util.List;

public interface LiteratureDao {

    List<Literature> getAll();

    Literature getById(Long id);

    List<Literature> getByQuestionId(Long testId);
}
