package z.ivan.dao.impl;

import org.springframework.stereotype.Repository;
import z.ivan.dao.RoleDao;
import z.ivan.model.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RoleDaoImpl extends CrudDaoImpl<Role> implements RoleDao {

    private static final String TABLE_NAME = "ditsdb.role";
    private static final String COLUMN_ROLE_ID = "roleid";
    private static final String COLUMN_ADMIN = "admin";
    private static final String COLUMN_TUTOR = "tutor";
    private static final String COLUMN_USER = "user";

    public RoleDaoImpl() {
        super(TABLE_NAME, COLUMN_ROLE_ID, RoleDaoImpl::mapRow, RoleDaoImpl::mapData);
    }

    private static Map<String, Object> mapData(Role role) {
        Map<String, Object> map = new HashMap<>();
        map.put(COLUMN_ROLE_ID, role.getRoleId());
        map.put(COLUMN_ADMIN, role.getAdmin());
        map.put(COLUMN_TUTOR, role.getTutor());
        map.put(COLUMN_USER, role.getUser());
        return map;
    }

    private static Role mapRow(ResultSet resultSet, int i) throws SQLException {
        Role role = new Role();
        role.setRoleId(resultSet.getLong(COLUMN_ROLE_ID));
        role.setAdmin(resultSet.getInt(COLUMN_ADMIN));
        role.setTutor(resultSet.getInt(COLUMN_TUTOR));
        role.setUser(resultSet.getInt(COLUMN_USER));
        return role;
    }
}
