package z.ivan.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import z.ivan.dao.TopicDao;
import z.ivan.dao.settings.MyJdbcDaoSupport;
import z.ivan.model.Topic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TopicDaoImpl extends MyJdbcDaoSupport implements TopicDao {

    private static final String TOPICID = "topicid";
    private static final String DESCRIPTION = "description";
    private static final String NAME = "name";

    private static final String SQL_GET_ALL = "SELECT * FROM ditsdb.topic";
    private static final String SQL_GET_BY_TOPICID = "SELECT * FROM ditsdb.topic WHERE " + TOPICID + " = ?";
    private static final String SQL_GET_BY_NAME = "SELECT * FROM ditsdb.topic WHERE " + NAME + " = ?";


    public TopicDaoImpl() {
    }

    @Override
    public List<Topic> getAll() {
        List<Topic> topics;
        try {
            topics = this.getJdbcTemplate().query(SQL_GET_ALL, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            topics = new ArrayList<>();
        }
        return topics;
    }

    @Override
    public Topic getById(Long id) {
        Topic topic;
        try {
            topic = this.getJdbcTemplate().queryForObject(SQL_GET_BY_TOPICID, new Object[]{id}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            topic = new Topic();
        }
        return topic;
    }

    @Override
    public Topic getByName(String name) {
        Topic topic;
        try {
            topic = this.getJdbcTemplate().queryForObject(SQL_GET_BY_NAME, new Object[]{name}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            topic = new Topic();
        }
        return topic;
    }

    private Topic mapRow(ResultSet resultSet, int i) {
        Topic topic = new Topic();
        try {
            topic.setTopicId(resultSet.getLong(TOPICID));
            topic.setDescription(resultSet.getString(DESCRIPTION));
            topic.setName(resultSet.getString(NAME));
        } catch (SQLException e) {
        }
        return topic;
    }
}
