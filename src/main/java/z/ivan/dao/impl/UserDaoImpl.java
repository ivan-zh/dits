package z.ivan.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import z.ivan.config.AppConfig;
import z.ivan.dao.UserDao;
import z.ivan.dao.impl.constants.TablesAndColumns;
import z.ivan.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL = "SELECT * FROM ditsdb.user";
    private static final String SQL_GET_BY_USERID = "SELECT * FROM ditsdb.user WHERE " + TablesAndColumns.USERID + " = ?";
    private static final String SQL_GET_BY_LOGIN = "SELECT * FROM ditsdb.user WHERE " + TablesAndColumns.LOGIN + " = ?";
    private static final String SQL_INSERT =
            "INSERT INTO ditsdb.user (`firstname`, `lastname`, `login`, `password`, `roleid`) VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE =
            "UPDATE ditsdb.user SET " +
                    "firstname = ?, " +
                    "lastname = ?, " +
                    "login = ?, " +
                    "password = ?, " +
                    "roleid = ? " +
                    " WHERE "
                    + TablesAndColumns.USERID + " = ?";


    public UserDaoImpl(AppConfig appConfig) {
        jdbcTemplate = new JdbcTemplate(appConfig.dataSource());
    }

    public List<User> getAll() {
        List<User> users;
        try {
            users = jdbcTemplate.query(SQL_GET_ALL, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            users = new ArrayList<>();
        }
        return users;
    }

    public User getById(Long id) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(SQL_GET_BY_USERID, new Object[]{id}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            user = new User();
        }
        return user;
    }

    public User getByLogin(String loginname) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(SQL_GET_BY_LOGIN, new Object[]{loginname}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            user = new User();
        }
        return user;
    }

    @Override
    public void add(String firstName, String lastName, String login, int pwdHash, String roleName) {

        int roleId;
        if ("admin".equalsIgnoreCase(roleName)) {
            roleId = 1;
        } else if ("tutor".equalsIgnoreCase(roleName)) {
            roleId = 2;
        } else {
            roleId = 3;
        }

        jdbcTemplate.update(SQL_INSERT, firstName, lastName, login, pwdHash, roleId);
    }

    @Override
    public void edit(Long id, String firstName, String lastName, String login, int pwdHash, String roleName) {

        int roleId;
        if ("admin".equalsIgnoreCase(roleName)) {
            roleId = 1;
        } else if ("tutor".equalsIgnoreCase(roleName)) {
            roleId = 2;
        } else {
            roleId = 3;
        }

        jdbcTemplate.update(SQL_UPDATE, firstName, lastName, login, pwdHash, roleId, id);

    }

    private User mapRow(ResultSet resultSet, int i) {
        User user = new User();
        try {
            user.setUserId(resultSet.getLong(TablesAndColumns.USERID));
            user.setFirstName(resultSet.getString(TablesAndColumns.FIRSTNAME));
            user.setLastName(resultSet.getString(TablesAndColumns.LASTNAME));
            user.setLogin(resultSet.getString(TablesAndColumns.LOGIN));
            user.setPassword(resultSet.getInt(TablesAndColumns.PASSWORD));
            user.setRoleId(resultSet.getInt(TablesAndColumns.ROLEID));
        } catch (SQLException e) {
        }
        return user;
    }
}
