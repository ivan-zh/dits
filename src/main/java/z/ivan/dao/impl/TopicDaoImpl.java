package z.ivan.dao.impl;

import org.springframework.stereotype.Repository;
import z.ivan.dao.TopicDao;
import z.ivan.model.Topic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TopicDaoImpl extends CrudDaoImpl<Topic> implements TopicDao {

    private static final String TABLE_NAME = "ditsdb.topic";
    private static final String COLUMN_TOPIC_ID = "topicid";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESCRIPTION = "description";

    public TopicDaoImpl() {
        super(TABLE_NAME, COLUMN_TOPIC_ID, TopicDaoImpl::mapRow, TopicDaoImpl::mapData);
    }

    @Override
    public Topic getByName(String name) {
        return getByColumn(COLUMN_NAME, name).get(0);
    }

    private static Map<String, Object> mapData(Topic topic) {
        Map<String, Object> map = new HashMap<>();
        map.put(COLUMN_TOPIC_ID, topic.getTopicId());
        map.put(COLUMN_NAME, topic.getName());
        map.put(COLUMN_DESCRIPTION, topic.getDescription());
        return map;
    }

    private static Topic mapRow(ResultSet resultSet, int i) throws SQLException {
        Topic topic = new Topic();
        topic.setTopicId(resultSet.getLong(COLUMN_TOPIC_ID));
        topic.setName(resultSet.getString(COLUMN_NAME));
        topic.setDescription(resultSet.getString(COLUMN_DESCRIPTION));
        return topic;
    }
}
