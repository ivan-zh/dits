package z.ivan.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import z.ivan.dao.QuestionDao;
import z.ivan.dao.settings.MyJdbcDaoSupport;
import z.ivan.model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionDaoImpl extends MyJdbcDaoSupport implements QuestionDao {

    private static final String QUESTIONID = "questionid";
    private static final String DESCRIPTION = "description";
    private static final String TESTID = "testid";

    private static final String SQL_GET_ALL = "SELECT * FROM ditsdb.question";
    private static final String SQL_GET_BY_QUESTIONID = "SELECT * FROM ditsdb.question WHERE " + QUESTIONID + " = ?";
    private static final String SQL_GET_BY_TESTID =
            "SELECT * FROM ditsdb.question WHERE " + TESTID + " = ?";

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


    private Question mapRow(ResultSet resultSet, int rowNum) {
        Question question = new Question();
        try {
            question.setQuestionId(resultSet.getLong(QUESTIONID));
            question.setDescription(resultSet.getString(DESCRIPTION));
            question.setTestId(resultSet.getLong(TESTID));
        } catch (SQLException e) {
        }
        return question;
    }

}
