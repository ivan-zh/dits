package z.ivan.dao;

import z.ivan.model.User;

public interface UserDao extends CrudDao<User> {
    User getByLogin(String loginname);

}
