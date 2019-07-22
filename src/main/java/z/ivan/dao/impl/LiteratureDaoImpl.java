package z.ivan.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import z.ivan.config.AppConfig;
import z.ivan.dao.LiteratureDao;
import z.ivan.dao.impl.constants.TablesAndColumns;
import z.ivan.model.Literature;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LiteratureDaoImpl implements LiteratureDao {

    private JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL = "SELECT * FROM ditsdb.literature";
    private static final String SQL_GET_BY_LITERATUREID = "SELECT * FROM ditsdb.literature WHERE " + TablesAndColumns.LITERATUREID + " = ?";
    private static final String SQL_GET_BY_QUESTIONID = "SELECT * FROM ditsdb.literature WHERE " + TablesAndColumns.QUESTIONID + " = ?";

    public LiteratureDaoImpl(AppConfig appConfig) {
        jdbcTemplate = new JdbcTemplate(appConfig.dataSource());
    }

    @Override
    public List<Literature> getAll() {
        List<Literature> entities;
        try {
            entities = jdbcTemplate.query(SQL_GET_ALL, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            entities = new ArrayList<>();
        }
        return entities;
    }

    @Override
    public Literature getById(Long id) {
        Literature literature;
        try {
            literature = jdbcTemplate.queryForObject(SQL_GET_BY_LITERATUREID, new Object[]{id}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            literature = new Literature();
        }
        return literature;
    }

    @Override
    public List<Literature> getByQuestionId(Long questionId) {
        List<Literature> literature;
        try {
            literature = jdbcTemplate.query(SQL_GET_BY_QUESTIONID, new Object[]{questionId}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            literature = new ArrayList<>();
        }
        return literature;
    }

    private Literature mapRow(ResultSet resultSet, int rowNum) {
        Literature literature = new Literature();
        try {
            literature.setLiteratureId(resultSet.getLong(TablesAndColumns.LITERATUREID));
            literature.setDescription(resultSet.getString(TablesAndColumns.DESCRIPTION));
            literature.setQuestionId(resultSet.getLong(TablesAndColumns.QUESTIONID));
        } catch (SQLException e) {
        }
        return literature;
    }
}
