package z.ivan.dao;

import z.ivan.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAll();

    Role getById(Long id);
}
