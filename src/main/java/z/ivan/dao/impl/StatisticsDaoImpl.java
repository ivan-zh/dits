package z.ivan.dao.impl;

import org.springframework.stereotype.Repository;
import z.ivan.dao.StatisticsDao;
import z.ivan.dao.settings.MyJdbcDaoSupport;
import z.ivan.model.QuestionStatistics;
import z.ivan.model.TestStatistics;
import z.ivan.model.UserStatistics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StatisticsDaoImpl extends MyJdbcDaoSupport implements StatisticsDao {

    private static final String SQL_GET_TEST_STATISTICS = "call ditsdb.test_statistics";
    private static final String SQL_GET_QUESTION_STATISTICS = "call ditsdb.question_statistics";
    private static final String SQL_GET_USER_STATISTICS = "call ditsdb.user_statistics";
    private static final String COLUMN_FIRST_NAME = "firstname";
    private static final String COLUMN_LAST_NAME = "lastname";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_COUNT = "count";
    private static final String COLUMN_AVG = "avg";

    public StatisticsDaoImpl() {
    }

    @Override
    public List<TestStatistics> getTestStatistics() {
        List<TestStatistics> testStatistics;
        testStatistics = this.getJdbcTemplate().query(SQL_GET_TEST_STATISTICS, this::mapRow);
        return testStatistics;
    }

    @Override
    public List<QuestionStatistics> getQuestionStatistics() {
        List<QuestionStatistics> questionStatistics;
        questionStatistics = this.getJdbcTemplate().query(SQL_GET_QUESTION_STATISTICS, this::questionStatisticsMapRow);
        return questionStatistics;
    }


    @Override
    public List<UserStatistics> getUserStatistics() {
        List<UserStatistics> userStatistics;
        userStatistics = this.getJdbcTemplate().query(SQL_GET_USER_STATISTICS, this::userStatisticsMapRow);
        return userStatistics;
    }

    private UserStatistics userStatisticsMapRow(ResultSet resultSet, int i) throws SQLException {
        UserStatistics userStatistics = new UserStatistics();
        userStatistics.setFirstName(resultSet.getString(COLUMN_FIRST_NAME));
        userStatistics.setLastName(resultSet.getString(COLUMN_LAST_NAME));
        userStatistics.setName(resultSet.getString(COLUMN_NAME));
        userStatistics.setCount(resultSet.getInt(COLUMN_COUNT));
        userStatistics.setAvg(resultSet.getFloat(COLUMN_AVG));
        return userStatistics;
    }

    private QuestionStatistics questionStatisticsMapRow(ResultSet resultSet, int i) throws SQLException {
        QuestionStatistics questionStatistics = new QuestionStatistics();
        questionStatistics.setName(resultSet.getString(COLUMN_NAME));
        questionStatistics.setCount(resultSet.getInt(COLUMN_COUNT));
        questionStatistics.setAvg(resultSet.getFloat(COLUMN_AVG));
        return questionStatistics;
    }

    private TestStatistics mapRow(ResultSet resultSet, int i) throws SQLException {
        TestStatistics testStatistics = new TestStatistics();
        testStatistics.setName(resultSet.getString(COLUMN_NAME));
        testStatistics.setCount(resultSet.getInt(COLUMN_COUNT));
        testStatistics.setAvg(resultSet.getFloat(COLUMN_AVG));
        return testStatistics;
    }
}
