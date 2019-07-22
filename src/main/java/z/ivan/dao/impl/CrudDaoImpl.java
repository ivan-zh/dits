package z.ivan.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import z.ivan.dao.CrudDao;
import z.ivan.dao.settings.MyJdbcDaoSupport;

import java.util.List;
import java.util.Map;

public abstract class CrudDaoImpl<T> extends MyJdbcDaoSupport implements CrudDao<T> {

    private String tableName;
    private String idColumn;
    private RowMapper<T> rowMapper;
    private DataMapper<T> dataMapper;

    @FunctionalInterface
    public interface DataMapper<E> {
        Map<String, Object> mapData(E model);
    }

    public CrudDaoImpl(String tableName, String idColumn, RowMapper<T> rowMapper, DataMapper<T> dataMapper) {
        this.tableName = tableName;
        this.idColumn = idColumn;
        this.rowMapper = rowMapper;
        this.dataMapper = dataMapper;
    }

    public Long add(T model) {
        Map<String, Object> data = dataMapper.mapData(model);
        data.remove(idColumn);
        return (Long) new SimpleJdbcInsert(this.getJdbcTemplate())
                .withTableName(tableName)
                .usingColumns(data.keySet().toArray(new String[0]))
                .usingGeneratedKeyColumns(idColumn)
                .executeAndReturnKey(data);
    }

    public void update(T model) {
        Map<String, Object> data = dataMapper.mapData(model);
        StringBuilder sets = new StringBuilder();
        Object id = null;
        for (String key : data.keySet()) {
            if (key.equals(idColumn)) {
                id = data.get(key);
            }
            Object value = data.get(key);
            if (value.getClass().equals(String.class)) {
                sets.append(key).append("=\"").append(value).append("\",");
            } else {
                sets.append(key).append("=").append(value).append(",");
            }
        }
        sets.deleteCharAt(sets.length() - 1);
        getJdbcTemplate()
                .update("update " + tableName + " set " + sets.toString() + " where " + idColumn + " = ?", id);
    }

    public List<T> getByColumn(String column, Object value) {
        return getJdbcTemplate().query("select * from " + tableName + " where " + column + " = ?",
                new Object[]{value}, rowMapper);
    }

    public T getById(Long id) {
        return getJdbcTemplate().queryForObject("select * from " + tableName + " where " + idColumn + " = ?",
                new Object[]{id}, rowMapper);
    }

    public List<T> getAll() {
        return getJdbcTemplate().query("select * from " + tableName, rowMapper);
    }

    public void delete(Long id) {
        getJdbcTemplate().update("delete from " + tableName + " where " + idColumn + " = ?", id);
    }
}
