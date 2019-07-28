package z.ivan.dao.impl;

import org.springframework.stereotype.Repository;
import z.ivan.dao.TestDao;
import z.ivan.model.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TestDaoImpl extends CrudDaoImpl<Test> implements TestDao {

    private static final String TABLE_NAME = "ditsdb.test";
    private static final String COLUMN_TEST_ID = "testid";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_TOPIC_ID = "topicid";
    private static final String SQL_GET_BY_TOPIC_NAME =
            "SELECT * FROM ditsdb.test WHERE topicid = (SELECT topicid FROM ditsdb.topic WHERE topic.name = ? )";

    public TestDaoImpl() {
        super(TABLE_NAME, COLUMN_TEST_ID, TestDaoImpl::mapRow, TestDaoImpl::mapData);
    }

    @Override
    public List<Test> getByTopicName(String topicName) {
        List<Test> tests;
        tests = this.getJdbcTemplate().query(SQL_GET_BY_TOPIC_NAME, new Object[]{topicName}, TestDaoImpl::mapRow);
        return tests;
    }

    private static Map<String, Object> mapData(Test model) {
        Map<String, Object> map = new HashMap<>();
        map.put(COLUMN_TEST_ID, model.getTestId());
        map.put(COLUMN_NAME, model.getName());
        map.put(COLUMN_DESCRIPTION, model.getDescription());
        map.put(COLUMN_TOPIC_ID, model.getTopicId());
        return map;
    }

    private static Test mapRow(ResultSet resultSet, int i) throws SQLException {
        Test test = new Test();
        test.setTestId(resultSet.getLong(COLUMN_TEST_ID));
        test.setName(resultSet.getString(COLUMN_NAME));
        test.setDescription(resultSet.getString(COLUMN_DESCRIPTION));
        test.setTopicId(resultSet.getLong(COLUMN_TOPIC_ID));
        return test;
    }
}
