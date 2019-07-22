package z.ivan.dao;

import java.util.List;

public interface CrudDao<T> {
    T getById(Long id);

    List<T> getAll();

    Long add(T model);

    void update(T model);

    void delete(Long id);
}
