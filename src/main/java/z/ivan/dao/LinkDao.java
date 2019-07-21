package z.ivan.dao;

import z.ivan.model.Link;

import java.util.List;

public interface LinkDao extends CrudDao<Link> {
    List<Link> getByLiteratureId(Long literatureId);
}
