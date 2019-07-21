package z.ivan.dao.impl;

import org.springframework.stereotype.Repository;
import z.ivan.dao.LiteratureDao;
import z.ivan.model.Literature;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LiteratureDaoImpl extends CrudDaoImpl<Literature> implements LiteratureDao {

    private static final String COLUMN_ID = "literatureid";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_QUESTION_ID = "questionid";
    private static final String TABLE_NAME = "ditsdb.literature";

    public LiteratureDaoImpl() {
        super(TABLE_NAME, COLUMN_ID, LiteratureDaoImpl::mapRow, LiteratureDaoImpl::mapData);
    }

    @Override
    public List<Literature> getByQuestionId(Long questionId) {
        return super.getByColumn(COLUMN_QUESTION_ID, questionId);
    }

    private static Map<String, Object> mapData(Literature model) {
        Map<String, Object> map = new HashMap<>();
        map.put(COLUMN_ID, model.getLiteratureId());
        map.put(COLUMN_DESCRIPTION, model.getDescription());
        map.put(COLUMN_QUESTION_ID, model.getQuestionId());

        return map;
    }

    private static Literature mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Literature literature = new Literature();
        literature.setLiteratureId(resultSet.getLong(COLUMN_ID));
        literature.setDescription(resultSet.getString(COLUMN_DESCRIPTION));
        literature.setQuestionId(resultSet.getLong(COLUMN_QUESTION_ID));
        return literature;
    }
}
