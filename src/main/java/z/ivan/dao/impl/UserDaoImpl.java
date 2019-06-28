package z.ivan.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import z.ivan.dao.UserDao;
import z.ivan.dao.settings.MyJdbcDaoSupport;
import z.ivan.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl extends MyJdbcDaoSupport implements UserDao {
    private static final String USERID = "userid";
    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ROLEID = "roleId";

    private static final String SQL_GET_ALL = "SELECT * FROM ditsdb.user";
    private static final String SQL_GET_BY_USERID = "SELECT * FROM ditsdb.user WHERE " + USERID + " = ?";
    private static final String SQL_GET_BY_LOGIN = "SELECT * FROM ditsdb.user WHERE " + LOGIN + " = ?";

    public UserDaoImpl() {
    }

    public List<User> getAll() {
        List<User> users;
        try {
            users = this.getJdbcTemplate().query(SQL_GET_ALL, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            users = new ArrayList<>();
        }
        return users;
    }

    public User getById(Long id) {
        User user;
        try {
            user = this.getJdbcTemplate().queryForObject(SQL_GET_BY_USERID, new Object[]{id}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            user = new User();
        }
        return user;
    }

    public User getByLogin(String loginname) {
        User user;
        try {
            user = this.getJdbcTemplate().queryForObject(SQL_GET_BY_LOGIN, new Object[]{loginname}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            user = new User();
        }
        return user;
    }

    private User mapRow(ResultSet resultSet, int i) {
        User user = new User();
        try {
            user.setUserId(resultSet.getLong(USERID));
            user.setFirstName(resultSet.getString(FIRSTNAME));
            user.setLastName(resultSet.getString(LASTNAME));
            user.setLogin(resultSet.getString(LOGIN));
            user.setPassword(resultSet.getInt(PASSWORD));
            user.setRoleId(resultSet.getInt(ROLEID));
        } catch (SQLException e) {
        }
        return user;
    }
}
