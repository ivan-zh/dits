package z.ivan.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import z.ivan.config.AppConfig;
import z.ivan.dao.AnswerDao;
import z.ivan.model.Answer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AnswerDaoImpl extends CrudDaoImpl<Answer> implements AnswerDao {

    private static final String TABLE_NAME = "ditsdb.answer";
    private static final String COLUMN_ANSWER_ID = "answerid";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_QUESTION_ID = "questionid";
    private static final String COLUMN_CORRECT = "correct";

    public AnswerDaoImpl(AppConfig appConfig) {
        super(TABLE_NAME, COLUMN_ANSWER_ID, AnswerDaoImpl::mapper);
        jdbcTemplate = new JdbcTemplate(appConfig.dataSource());
    }

    @Override
    public Long add(Answer model) {
        return super.add(createData(model));
    }

    @Override
    public void update(Answer model) {
        super.update(createData(model));
    }

    private static Map<String, Object> createData(Answer answer) {
        Map<String, Object> data = new HashMap<>();
        data.put(COLUMN_ANSWER_ID, answer.getAnswerId());
        data.put(COLUMN_DESCRIPTION, answer.getDescription());
        data.put(COLUMN_QUESTION_ID, answer.getQuestionId());
        data.put(COLUMN_CORRECT, answer.getCorrect());
        return data;
    }

    private static Answer mapper(ResultSet resultSet, int i) throws SQLException {
        Answer answer = new Answer();
        answer.setAnswerId(resultSet.getLong(COLUMN_ANSWER_ID));
        answer.setDescription(resultSet.getString(COLUMN_DESCRIPTION));
        answer.setQuestionId(resultSet.getLong(COLUMN_QUESTION_ID));
        answer.setCorrect(resultSet.getBoolean(COLUMN_CORRECT));
        return answer;
    }
}
