package z.ivan.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import z.ivan.dao.settings.MyJdbcDaoSupport;

import java.util.List;
import java.util.Map;

public abstract class CrudDaoImpl<T> extends MyJdbcDaoSupport {

    private String tableName;
    private String idColumn;
    private RowMapper<T> mapper;

    public CrudDaoImpl(String tableName, String idColumn, RowMapper<T> mapper) {
        this.tableName = tableName;
        this.idColumn = idColumn;
        this.mapper = mapper;
    }

    public Long add(Map<String, Object> data) {
        data.remove(idColumn);
        return (Long) new SimpleJdbcInsert(this.getJdbcTemplate())
                .withTableName(tableName)
                .usingColumns(data.keySet().toArray(new String[0]))
                .usingGeneratedKeyColumns(idColumn)
                .executeAndReturnKey(data);
    }

    public void update(Map<String, Object> data) {
        StringBuilder sets = new StringBuilder();
        Object id = null;
        for (String key : data.keySet()) {
            if (key.equals(idColumn)) {
                id = data.get(key);
            }
            sets.append(key).append("=").append(data.get(key)).append(",");
        }
        sets.deleteCharAt(sets.length() - 1);
        getJdbcTemplate().update("update ? set " + sets.toString() + " where ? = ?",
                tableName, idColumn, id);
    }

    public T getById(Long id) {
        return getJdbcTemplate().queryForObject("select * from ? where ? = ?",
                new Object[]{tableName, idColumn, id}, mapper);
    }

    public List<T> getAll() {
        return getJdbcTemplate().query("select * from ?", new Object[]{tableName}, mapper);
    }

    public void delete(Long id) {
        getJdbcTemplate().update("delete from ? where ? = ?", tableName, idColumn, id);
    }
}
