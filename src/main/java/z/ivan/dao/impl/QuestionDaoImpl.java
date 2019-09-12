package z.ivan.dao.impl;

import org.springframework.stereotype.Repository;
import z.ivan.dao.QuestionDao;
import z.ivan.model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class QuestionDaoImpl extends CrudDaoImpl<Question> implements QuestionDao {

    private static final String TABLE_NAME = "ditsdb.question";
    private static final String COLUMN_QUESTION_ID = "questionid";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_TEST_ID = "testid";
    private static final String SQL_GET_BY_TEST_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_TEST_ID + " = ?";

    public QuestionDaoImpl() {
        super(TABLE_NAME, COLUMN_QUESTION_ID, QuestionDaoImpl::mapRow, QuestionDaoImpl::mapData);
    }

    @Override
    public List<Question> getByTestId(Long testId) {
        return this.getJdbcTemplate().query(SQL_GET_BY_TEST_ID, new Object[]{testId}, QuestionDaoImpl::mapRow);
    }

    @Override
    public List<Question> getQuestionByQuestionId(Long testId, Long questionId) {
        String SQL_GET_QUESTION_BY_TESTID_AND_QUESTIONID = "SELECT * FROM  " + TABLE_NAME + " WHERE " + COLUMN_TEST_ID + " = ? AND " +COLUMN_QUESTION_ID +" = ?" ;
        return this.getJdbcTemplate().query(SQL_GET_QUESTION_BY_TESTID_AND_QUESTIONID, new Object[]{testId,questionId}, QuestionDaoImpl::mapRow);
    }

    private static Map<String, Object> mapData(Question model) {
        Map<String, Object> map = new HashMap<>();
        map.put(COLUMN_QUESTION_ID, model.getTestId());
        map.put(COLUMN_DESCRIPTION, model.getDescription());
        map.put(COLUMN_TEST_ID, model.getTestId());
        return map;
    }

    private static Question mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Question question = new Question();
        question.setQuestionId(resultSet.getLong(COLUMN_QUESTION_ID));
        question.setDescription(resultSet.getString(COLUMN_DESCRIPTION));
        question.setTestId(resultSet.getLong(COLUMN_TEST_ID));
        return question;
    }

}
