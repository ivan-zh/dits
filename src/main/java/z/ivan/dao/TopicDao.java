package z.ivan.dao;

import z.ivan.model.Topic;

public interface TopicDao extends CrudDao<Topic> {
    Topic getByName(String name);
}
