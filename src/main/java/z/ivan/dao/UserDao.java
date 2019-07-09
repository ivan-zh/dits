package z.ivan.dao;

import z.ivan.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    User getById(Long id);

    User getByLogin(String loginname);

    void add(String firstName, String lastName, String login, int pwdHash, String roleName);
}
