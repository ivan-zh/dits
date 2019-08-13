package z.ivan.dao.impl;

import org.springframework.stereotype.Repository;
import z.ivan.dao.PersonalUserStatisticDao;
import z.ivan.dao.settings.MyJdbcDaoSupport;
import z.ivan.model.PersonalUserStatistic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonalUserStatisticDaoImpl extends MyJdbcDaoSupport implements PersonalUserStatisticDao {

    private static final String SQL_GET_PERSONAL_USER_STATISTIC = "call ditsdb.personal_user_statistic";
    private static final String COLUMN_FIRST_NAME = "firstname";
    private static final String COLUMN_LAST_NAME = "lastname";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_QUESTION = "question";
    private static final String COLUMN_COUNT = "count";
    private static final String COLUMN_AVG = "avg";

    public PersonalUserStatisticDaoImpl() {
    }

    @Override
    public List<PersonalUserStatistic> getPersonalUserStatistic() {
        List<PersonalUserStatistic> personalUserStatistics;
        personalUserStatistics = this.getJdbcTemplate().query(SQL_GET_PERSONAL_USER_STATISTIC, this::personalUserStatisticsMapRow);
        return personalUserStatistics;
  //      return null;
    }

    private PersonalUserStatistic personalUserStatisticsMapRow(ResultSet resultSet, int i) throws SQLException {
        PersonalUserStatistic personalUserStatistic = new PersonalUserStatistic();
        personalUserStatistic.setFirstName(resultSet.getString(COLUMN_FIRST_NAME));
        personalUserStatistic.setLastName(resultSet.getString(COLUMN_LAST_NAME));
        personalUserStatistic.setName(resultSet.getString(COLUMN_NAME));
        personalUserStatistic.setQuestion(resultSet.getString(COLUMN_QUESTION));
        personalUserStatistic.setCount(resultSet.getInt(COLUMN_COUNT));
        personalUserStatistic.setAvg(resultSet.getFloat(COLUMN_AVG));
        return personalUserStatistic;
    }
}
