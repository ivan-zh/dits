package z.ivan.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import z.ivan.config.AppConfig;
import z.ivan.dao.impl.constants.TablesAndColumns;
import z.ivan.model.QuestionStatistics;
import z.ivan.model.TestStatistics;
import z.ivan.model.UserStatistics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StatisticsDao {

    private JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_TEST_STATISTICS = "call ditsdb.test_statistics";
    private static final String SQL_GET_QUESTION_STATISTICS = "call ditsdb.question_statistics";
    private static final String SQL_GET_USER_STATISTICS = "call ditsdb.user_statistics";

    public StatisticsDao(AppConfig appConfig) {
        jdbcTemplate = new JdbcTemplate(appConfig.dataSource());
    }

    public List<TestStatistics> getTestStatistics() {
        List<TestStatistics> testStatistics;
        try {
            testStatistics = jdbcTemplate.query(SQL_GET_TEST_STATISTICS, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            testStatistics = new ArrayList<>();
        }
        return testStatistics;
    }

    public List<QuestionStatistics> getQuestionStatistics() {
        List<QuestionStatistics> questionStatistics;
        try {
            questionStatistics = jdbcTemplate.query(SQL_GET_QUESTION_STATISTICS, this::questionStatisticsMapRow);
        } catch (NullPointerException | DataAccessException e) {
            questionStatistics = new ArrayList<>();
        }
        return questionStatistics;
    }


    public List<UserStatistics> getUserStatistics() {
        List<UserStatistics> userStatistics;
        try {
            userStatistics = jdbcTemplate.query(SQL_GET_USER_STATISTICS, this::userStatisticsMapRow);
        } catch (NullPointerException | DataAccessException e) {
            userStatistics = new ArrayList<>();
        }
        return userStatistics;
    }

    private UserStatistics userStatisticsMapRow(ResultSet resultSet, int i) {
        UserStatistics userStatistics = new UserStatistics();
        try {
            userStatistics.setFirstName(resultSet.getString(TablesAndColumns.FIRST_NAME));
            userStatistics.setLastName(resultSet.getString(TablesAndColumns.LAST_NAME));
            userStatistics.setName(resultSet.getString(TablesAndColumns.NAME));
            userStatistics.setCount(resultSet.getInt(TablesAndColumns.COUNT));
            userStatistics.setAvg(resultSet.getFloat(TablesAndColumns.AVG));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userStatistics;
    }

    private QuestionStatistics questionStatisticsMapRow(ResultSet resultSet, int i) {
        QuestionStatistics questionStatistics = new QuestionStatistics();
        try {
            questionStatistics.setName(resultSet.getString(TablesAndColumns.NAME));
            questionStatistics.setCount(resultSet.getInt(TablesAndColumns.COUNT));
            questionStatistics.setAvg(resultSet.getFloat(TablesAndColumns.AVG));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionStatistics;
    }

    private TestStatistics mapRow(ResultSet resultSet, int i) {
        TestStatistics testStatistics = new TestStatistics();
        try {
            testStatistics.setName(resultSet.getString(TablesAndColumns.NAME));
            testStatistics.setCount(resultSet.getInt(TablesAndColumns.COUNT));
            testStatistics.setAvg(resultSet.getFloat(TablesAndColumns.AVG));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testStatistics;
    }
}
