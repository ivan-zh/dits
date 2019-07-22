package z.ivan.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import z.ivan.config.AppConfig;
import z.ivan.dao.TestDao;
import z.ivan.dao.impl.constants.TablesAndColumns;
import z.ivan.model.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TestDaoImpl implements TestDao {

    private JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL = "SELECT * FROM ditsdb.test";
    private static final String SQL_GET_BY_TESTID = "SELECT * FROM ditsdb.test WHERE " + TablesAndColumns.TESTID + " = ?";
    private static final String SQL_GET_BY_TOPIC_NAME =
            "SELECT * FROM ditsdb.test WHERE topicid = (SELECT topicid FROM ditsdb.topic WHERE topic.name = ? )";

    public TestDaoImpl(AppConfig appConfig) {
        jdbcTemplate = new JdbcTemplate(appConfig.dataSource());
    }

    @Override
    public List<Test> getAll() {
        List<Test> tests;
        try {
            tests = jdbcTemplate.query(SQL_GET_ALL, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            tests = new ArrayList<>();
        }
        return tests;
    }

    @Override
    public Test getById(Long id) {
        Test test;
        try {
            test = jdbcTemplate.queryForObject(SQL_GET_BY_TESTID, new Object[]{id}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            test = new Test();
        }
        return test;
    }

    @Override
    public List<Test> getByTopicName(String topicName) {
        List<Test> tests;
        try {
            tests = jdbcTemplate.query(SQL_GET_BY_TOPIC_NAME, new Object[]{topicName}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            tests = new ArrayList<>();
        }
        return tests;
    }

    @Override
    public Long add(Long topic, String testName, String testDescription) {
        Map<String, Object> data = new HashMap<>();
        data.put(TablesAndColumns.NAME, testName);
        data.put(TablesAndColumns.DESCRIPTION, testDescription);
        data.put(TablesAndColumns.TOPICID, topic);

        final Long id = (Long) new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TablesAndColumns.TEST)
                .usingColumns(TablesAndColumns.NAME, TablesAndColumns.DESCRIPTION,TablesAndColumns.TOPICID)
                .usingGeneratedKeyColumns(TablesAndColumns.TESTID)
                .executeAndReturnKey(data);

        return id;
    }

    private Test mapRow(ResultSet resultSet, int i) {
        Test test = new Test();
        try {
            test.setTestId(resultSet.getLong(TablesAndColumns.TESTID));
            test.setName(resultSet.getString(TablesAndColumns.NAME));
            test.setDescription(resultSet.getString(TablesAndColumns.DESCRIPTION));
            test.setTopicId(resultSet.getLong(TablesAndColumns.TOPICID));
        } catch (SQLException e) {
        }
        return test;
    }
}
