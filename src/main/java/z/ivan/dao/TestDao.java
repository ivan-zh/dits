package z.ivan.dao;

import z.ivan.model.Test;

import java.util.List;

public interface TestDao extends CrudDao<Test> {
    List<Test> getByTopicName(String topicName);
}

