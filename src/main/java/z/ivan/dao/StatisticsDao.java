package z.ivan.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import z.ivan.dao.settings.MyJdbcDaoSupport;
import z.ivan.model.QuestionStatistics;
import z.ivan.model.Role;
import z.ivan.model.TestStatistics;
import z.ivan.model.UserStatistics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StatisticsDao extends MyJdbcDaoSupport {

    private static final String NAME = "name";
    private static final String COUNT = "count";
    private static final String AVG = "avg";
    private static final String SQL_GET_TEST_STATISTICS = "call ditsdb.test_statistics";
    private static final String SQL_GET_QUESTION_STATISTICS = "call ditsdb.question_statistics";
    private static final String SQL_GET_USER_STATISTICS = "call ditsdb.user_statistics";
    private static final String FIRST_NAME = "firstname";
    private static final String LAST_NAME = "lastname";

    public StatisticsDao() {
    }

    public List<TestStatistics> getTestStatistics() {
        List<TestStatistics> testStatistics;
        try {
            testStatistics = this.getJdbcTemplate().query(SQL_GET_TEST_STATISTICS, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            testStatistics = new ArrayList<>();
        }
        return testStatistics;
    }

    public List<QuestionStatistics> getQuestionStatistics() {
        List<QuestionStatistics> questionStatistics;
        try {
            questionStatistics = this.getJdbcTemplate().query(SQL_GET_QUESTION_STATISTICS, this::questionStatisticsMapRow);
        } catch (NullPointerException | DataAccessException e) {
            questionStatistics = new ArrayList<>();
        }
        return questionStatistics;
    }


    public List<UserStatistics> getUserStatistics() {
        List<UserStatistics> userStatistics;
        try {
            userStatistics = this.getJdbcTemplate().query(SQL_GET_USER_STATISTICS, this::userStatisticsMapRow);
        } catch (NullPointerException | DataAccessException e) {
            userStatistics = new ArrayList<>();
        }
        return userStatistics;
    }

    private UserStatistics userStatisticsMapRow(ResultSet resultSet, int i) {
        UserStatistics userStatistics = new UserStatistics();
        try {
            userStatistics.setFirstName(resultSet.getString(FIRST_NAME));
            userStatistics.setLastName(resultSet.getString(LAST_NAME));
            userStatistics.setName(resultSet.getString(NAME));
            userStatistics.setCount(resultSet.getInt(COUNT));
            userStatistics.setAvg(resultSet.getFloat(AVG));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userStatistics;
    }

    private QuestionStatistics questionStatisticsMapRow(ResultSet resultSet, int i) {
        QuestionStatistics questionStatistics = new QuestionStatistics();
        try {
            questionStatistics.setName(resultSet.getString(NAME));
            questionStatistics.setCount(resultSet.getInt(COUNT));
            questionStatistics.setAvg(resultSet.getFloat(AVG));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionStatistics;
    }

    private TestStatistics mapRow(ResultSet resultSet, int i) {
        TestStatistics testStatistics = new TestStatistics();
        try {
            testStatistics.setName(resultSet.getString(NAME));
            testStatistics.setCount(resultSet.getInt(COUNT));
            testStatistics.setAvg(resultSet.getFloat(AVG));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testStatistics;
    }
}
