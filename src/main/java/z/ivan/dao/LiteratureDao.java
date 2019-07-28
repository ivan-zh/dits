package z.ivan.dao;

import z.ivan.model.Literature;

import java.util.List;

public interface LiteratureDao extends CrudDao<Literature> {
    List<Literature> getByQuestionId(Long testId);
}
