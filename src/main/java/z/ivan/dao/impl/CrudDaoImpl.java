package z.ivan.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.List;
import java.util.Map;

public abstract class CrudDaoImpl<T> {

    protected JdbcTemplate jdbcTemplate;

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
        return (Long) new SimpleJdbcInsert(jdbcTemplate)
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
        jdbcTemplate.update("update " + tableName + " set " + sets.toString() + " where " + idColumn + " = ?", id);
    }

    public T getById(Long id) {
        return jdbcTemplate.queryForObject("select * from " + tableName + " where " + idColumn + " = ?",
                new Object[]{id}, mapper);
    }

    public List<T> getAll() {
        return jdbcTemplate.query("select * from " + tableName, mapper);
    }

    public void delete(Long id) {
        jdbcTemplate.update("delete from " + tableName + " where " + idColumn + " = ?", id);
    }
}
