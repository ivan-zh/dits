package z.ivan.dao;

import z.ivan.model.Link;

import java.util.List;

public interface LinkDao {

    List<Link> getAll();

    Link getById(Long id);

    List<Link> getByLiteratureId(Long literatureId);
}
