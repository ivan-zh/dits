package z.ivan.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import z.ivan.config.AppConfig;
import z.ivan.dao.TopicDao;
import z.ivan.dao.impl.constants.TablesAndColumns;
import z.ivan.model.Topic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TopicDaoImpl implements TopicDao {

    private JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL = "SELECT * FROM ditsdb.topic";
    private static final String SQL_GET_BY_TOPICID = "SELECT * FROM ditsdb.topic WHERE " + TablesAndColumns.TOPICID + " = ?";
    private static final String SQL_GET_BY_NAME = "SELECT * FROM ditsdb.topic WHERE " + TablesAndColumns.NAME + " = ?";

    public TopicDaoImpl(AppConfig appConfig) {
        jdbcTemplate = new JdbcTemplate(appConfig.dataSource());
    }

    @Override
    public List<Topic> getAll() {
        List<Topic> topics;
        try {
            topics = jdbcTemplate.query(SQL_GET_ALL, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            topics = new ArrayList<>();
        }
        return topics;
    }

    @Override
    public Topic getById(Long id) {
        Topic topic;
        try {
            topic = jdbcTemplate.queryForObject(SQL_GET_BY_TOPICID, new Object[]{id}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            topic = new Topic();
        }
        return topic;
    }

    @Override
    public Topic getByName(String name) {
        Topic topic;
        try {
            topic = jdbcTemplate.queryForObject(SQL_GET_BY_NAME, new Object[]{name}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            topic = new Topic();
        }
        return topic;
    }

    @Override
    public Long add(String description, String name) {
        Map<String, String> data = new HashMap<>();
        data.put(TablesAndColumns.DESCRIPTION, description);
        data.put(TablesAndColumns.NAME, name);

        final Long id = (Long) new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TablesAndColumns.TOPIC)
                .usingColumns(TablesAndColumns.DESCRIPTION, TablesAndColumns.NAME)
                .usingGeneratedKeyColumns(TablesAndColumns.TOPICID)
                .executeAndReturnKey(data);
        return id;
    }

    private Topic mapRow(ResultSet resultSet, int i) {
        Topic topic = new Topic();
        try {
            topic.setTopicId(resultSet.getLong(TablesAndColumns.TOPICID));
            topic.setDescription(resultSet.getString(TablesAndColumns.DESCRIPTION));
            topic.setName(resultSet.getString(TablesAndColumns.NAME));
        } catch (SQLException e) {
        }
        return topic;
    }
}
