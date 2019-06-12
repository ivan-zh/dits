package z.ivan.dao;

import org.springframework.stereotype.Repository;
import z.ivan.model.User;

import java.util.List;

@Repository
public class UserDao extends MyJdbcDaoSupport {
    private static final String SQL_GET_ALL = "SELECT * FROM user";

    private String USERID = "userid";
    private String FIRSTNAME = "firstname";
    private String LASTNAME = "lastname";
    private String LOGIN = "login";
    private String PASSWORD = "password";
    private String ROLEID = "roleId";

    public UserDao() {
    }

    public List<User> getAll() {
        return this.getJdbcTemplate().query(SQL_GET_ALL, (resultSet, i) -> {
            User user = new User();
            user.setUserId(resultSet.getLong(USERID));
            user.setFirstName(resultSet.getString(FIRSTNAME));
            user.setLastName(resultSet.getString(LASTNAME));
            user.setLogin(resultSet.getString(LOGIN));
            user.setPassword(resultSet.getInt(PASSWORD));
            user.setRoleId(resultSet.getInt(ROLEID));
            return user;
        });

    }
}
