package z.ivan.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import z.ivan.dao.LiteratureDao;
import z.ivan.dao.settings.MyJdbcDaoSupport;
import z.ivan.model.Literature;
import z.ivan.model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LiteratureDaoImpl extends MyJdbcDaoSupport implements LiteratureDao {

    private static final String LITERATUREID = "literatureid";
    private static final String DESCRIPTION = "description";
    private static final String QUESTIONID = "questionid";

    private static final String SQL_GET_ALL = "SELECT * FROM ditsdb.literature";
    private static final String SQL_GET_BY_LITERATUREID = "SELECT * FROM ditsdb.literature WHERE " + LITERATUREID + " = ?";
    private static final String SQL_GET_BY_QUESTIONID = "SELECT * FROM ditsdb.literature WHERE " + QUESTIONID + " = ?";

    @Override
    public List<Literature> getAll() {
        List<Literature> entities;
        try {
            entities = this.getJdbcTemplate().query(SQL_GET_ALL, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            entities = new ArrayList<>();
        }
        return entities;
    }

    @Override
    public Literature getById(Long id) {
        Literature literature;
        try {
            literature = this.getJdbcTemplate().queryForObject(SQL_GET_BY_LITERATUREID, new Object[]{id}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            literature = new Literature();
        }
        return literature;
    }

    @Override
    public List<Literature> getByQuestionId(Long questionId) {
        List<Literature> literature;
        try {
            literature = this.getJdbcTemplate().query(SQL_GET_BY_QUESTIONID, new Object[]{questionId}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            literature = new ArrayList<>();
        }
        return literature;
    }

    private Literature mapRow(ResultSet resultSet, int rowNum) {
        Literature literature = new Literature();
        try {
            literature.setLiteratureId(resultSet.getLong(LITERATUREID));
            literature.setDescription(resultSet.getString(DESCRIPTION));
            literature.setQuestionId(resultSet.getLong(QUESTIONID));
        } catch (SQLException e) {
        }
        return literature;
    }
}
