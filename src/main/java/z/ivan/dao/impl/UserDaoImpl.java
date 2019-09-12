package z.ivan.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import z.ivan.dao.UserDao;
import z.ivan.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl extends CrudDaoImpl<User> implements UserDao {

    private static final String TABLE_NAME = "ditsdb.user";
    private static final String COLUMN_USER_ID = "userid";
    private static final String COLUMN_LOGIN = "login";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_FIRST_NAME = "firstname";
    private static final String COLUMN_LAST_NAME = "lastname";
    private static final String COLUMN_ROLE_ID = "roleid";

    public UserDaoImpl() {
        super(TABLE_NAME, COLUMN_USER_ID, UserDaoImpl::mapRow, UserDaoImpl::mapData);
    }

    @Override
    public User getByLogin(String login) {
        return super.getByColumn(COLUMN_LOGIN, login).get(0);
    }

    private static Map<String, Object> mapData(User model) {
        Map<String, Object> data = new HashMap<>();
        data.put(COLUMN_USER_ID, model.getUserId());
        data.put(COLUMN_LOGIN, model.getLogin());
        data.put(COLUMN_PASSWORD, model.getPassword());
        data.put(COLUMN_FIRST_NAME, model.getFirstName());
        data.put(COLUMN_LAST_NAME, model.getLastName());
        data.put(COLUMN_ROLE_ID, model.getRoleId());
        return data;
    }

    private static User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getLong(COLUMN_USER_ID));
        user.setFirstName(resultSet.getString(COLUMN_FIRST_NAME));
        user.setLastName(resultSet.getString(COLUMN_LAST_NAME));
        user.setLogin(resultSet.getString(COLUMN_LOGIN));
        user.setPassword(resultSet.getInt(COLUMN_PASSWORD));
        user.setRoleId(resultSet.getInt(COLUMN_ROLE_ID));
        return user;
    }
}
