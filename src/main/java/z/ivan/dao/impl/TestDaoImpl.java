package z.ivan.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import z.ivan.dao.TestDao;
import z.ivan.dao.settings.MyJdbcDaoSupport;
import z.ivan.model.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TestDaoImpl extends MyJdbcDaoSupport implements TestDao {

    private static final String TESTID = "testid";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String TOPICID = "topicid";

    private static final String SQL_GET_ALL = "SELECT * FROM ditsdb.test";
    private static final String SQL_GET_BY_TESTID = "SELECT * FROM ditsdb.test WHERE " + TESTID + " = ?";
    private static final String SQL_GET_BY_TOPIC_NAME =
            "SELECT * FROM ditsdb.test WHERE topicid = (SELECT topicid FROM ditsdb.topic WHERE topic.name = ? )";

    public TestDaoImpl() {
    }

    @Override
    public List<Test> getAll() {
        List<Test> tests;
        try {
            tests = this.getJdbcTemplate().query(SQL_GET_ALL, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            tests = new ArrayList<>();
        }
        return tests;
    }

    @Override
    public Test getById(Long id) {
        Test test;
        try {
            test = this.getJdbcTemplate().queryForObject(SQL_GET_BY_TESTID, new Object[]{id}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            test = new Test();
        }
        return test;
    }

    @Override
    public List<Test> getByTopicName(String topicName) {
        List<Test> tests;
        try {
            tests = this.getJdbcTemplate().query(SQL_GET_BY_TOPIC_NAME, new Object[]{topicName}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            tests = new ArrayList<>();
        }
        return tests;
    }

    private Test mapRow(ResultSet resultSet, int i) {
     Test test = new Test();
        try {
            test.setTestId(resultSet.getLong(TESTID));
            test.setName(resultSet.getString(NAME));
            test.setDescription(resultSet.getString(DESCRIPTION));
            test.setTopicId(resultSet.getLong(TOPICID));
        } catch (SQLException e) {
        }
        return test;
    }
}
