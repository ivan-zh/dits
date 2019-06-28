package z.ivan.dao;

import z.ivan.model.Topic;

import java.util.List;

public interface TopicDao {

    List<Topic> getAll();

    Topic getById(Long id);

    Topic getByName(String name);
}
