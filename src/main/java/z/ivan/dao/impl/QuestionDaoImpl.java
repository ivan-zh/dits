package z.ivan.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import z.ivan.dao.QuestionDao;
import z.ivan.dao.impl.constants.TablesAndColumns;
import z.ivan.dao.settings.MyJdbcDaoSupport;
import z.ivan.model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class QuestionDaoImpl extends MyJdbcDaoSupport implements QuestionDao {

    private static final String SQL_GET_ALL = "SELECT * FROM ditsdb.question";
    private static final String SQL_GET_BY_QUESTIONID = "SELECT * FROM ditsdb.question WHERE " + TablesAndColumns.QUESTIONID + " = ?";
    private static final String SQL_GET_BY_TESTID =
            "SELECT * FROM ditsdb.question WHERE " + TablesAndColumns.TESTID + " = ?";

    @Override
    public List<Question> getAll() {
        List<Question> entities;
        try {
            entities = this.getJdbcTemplate().query(SQL_GET_ALL, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            entities = new ArrayList<>();
        }
        return entities;
    }

    @Override
    public Question getById(Long id) {
        Question question;
        try {
            question = this.getJdbcTemplate().queryForObject(SQL_GET_BY_QUESTIONID, new Object[]{id}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            question = new Question();
        }
        return question;
    }

    @Override
    public List<Question> getByTestId(Long testId) {
        List<Question> entities;
        try {
            entities = this.getJdbcTemplate().query(SQL_GET_BY_TESTID, new Object[]{testId}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            entities = new ArrayList<>();
        }
        return entities;
    }

    @Override
    public Long add(Long test, String description) {
        Map<String, Object> data = new HashMap<>();
        data.put(TablesAndColumns.DESCRIPTION, description);
        data.put(TablesAndColumns.TESTID, test);

        final Long id = (Long) new SimpleJdbcInsert(this.getJdbcTemplate())
                .withTableName(TablesAndColumns.QUESTION)
                .usingColumns(TablesAndColumns.DESCRIPTION, TablesAndColumns.TESTID)
                .usingGeneratedKeyColumns(TablesAndColumns.QUESTIONID)
                .executeAndReturnKey(data);

        return id;
    }


    private Question mapRow(ResultSet resultSet, int rowNum) {
        Question question = new Question();
        try {
            question.setQuestionId(resultSet.getLong(TablesAndColumns.QUESTIONID));
            question.setDescription(resultSet.getString(TablesAndColumns.DESCRIPTION));
            question.setTestId(resultSet.getLong(TablesAndColumns.TESTID));
        } catch (SQLException e) {
        }
        return question;
    }

}
