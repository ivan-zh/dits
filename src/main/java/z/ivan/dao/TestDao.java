package z.ivan.dao;

import z.ivan.model.Test;

import java.util.List;

public interface TestDao {

    List<Test> getAll();

    Test getById(Long id);

    List<Test> getByTopicName(String topicName);

    Long add(Long topic, String testName);
}

