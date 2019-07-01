package z.ivan.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import z.ivan.dao.RoleDao;
import z.ivan.dao.settings.MyJdbcDaoSupport;
import z.ivan.model.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleDaoImpl extends MyJdbcDaoSupport implements RoleDao {

    private static final String ROLEID = "roleid";
    private static final String USER = "user";
    private static final String TUTOR = "tutor";
    private static final String ADMIN = "admin";

    private static final String SQL_GET_ALL = "SELECT * FROM ditsdb.role";
    private static final String SQL_GET_BY_ROLEID = "SELECT * FROM ditsdb.role WHERE " + ROLEID + " = ?";

    public RoleDaoImpl() {
    }

    @Override
    public List<Role> getAll() {
        List<Role> roles;
        try {
            roles = this.getJdbcTemplate().query(SQL_GET_ALL, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            roles = new ArrayList<>();
        }
        return roles;
    }

    @Override
    public Role getById(Long id) {
        Role role;
        try {
            role = this.getJdbcTemplate().queryForObject(SQL_GET_BY_ROLEID, new Object[]{id}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            role = new Role();
        }
        return role;
    }

    private Role mapRow(ResultSet resultSet, int i) {
        Role role = new Role();
        try {
            role.setRoleId(resultSet.getLong(ROLEID));
            role.setAdmin(resultSet.getInt(ADMIN));
            role.setTutor(resultSet.getInt(TUTOR));
            role.setUser(resultSet.getInt(USER));
        } catch (SQLException e) {
        }
        return role;
    }
}
