package z.ivan.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import z.ivan.config.AppConfig;
import z.ivan.dao.RoleDao;
import z.ivan.dao.impl.constants.TablesAndColumns;
import z.ivan.model.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL = "SELECT * FROM ditsdb.role";
    private static final String SQL_GET_BY_ROLEID = "SELECT * FROM ditsdb.role WHERE " + TablesAndColumns.ROLEID + " = ?";

    public RoleDaoImpl(AppConfig appConfig) {
        jdbcTemplate = new JdbcTemplate(appConfig.dataSource());
    }

    @Override
    public List<Role> getAll() {
        List<Role> roles;
        try {
            roles = jdbcTemplate.query(SQL_GET_ALL, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            roles = new ArrayList<>();
        }
        return roles;
    }

    @Override
    public Role getById(Long id) {
        Role role;
        try {
            role = jdbcTemplate.queryForObject(SQL_GET_BY_ROLEID, new Object[]{id}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            role = new Role();
        }
        return role;
    }

    private Role mapRow(ResultSet resultSet, int i) {
        Role role = new Role();
        try {
            role.setRoleId(resultSet.getLong(TablesAndColumns.ROLEID));
            role.setAdmin(resultSet.getInt(TablesAndColumns.ADMIN));
            role.setTutor(resultSet.getInt(TablesAndColumns.TUTOR));
            role.setUser(resultSet.getInt(TablesAndColumns.USER));
        } catch (SQLException e) {
        }
        return role;
    }
}
