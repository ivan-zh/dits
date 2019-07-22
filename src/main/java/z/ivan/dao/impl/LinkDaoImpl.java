package z.ivan.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import z.ivan.config.AppConfig;
import z.ivan.dao.LinkDao;
import z.ivan.dao.impl.constants.TablesAndColumns;
import z.ivan.model.Link;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkDaoImpl implements LinkDao {

    private JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL = "SELECT * FROM ditsdb.link";
    private static final String SQL_GET_BY_LINKID = "SELECT * FROM ditsdb.link WHERE " + TablesAndColumns.LINKID + " = ?";
    private static final String SQL_GET_BY_LITERATUREID = "SELECT * FROM ditsdb.link WHERE " + TablesAndColumns.LITERATUREID + " = ?";

    public LinkDaoImpl(AppConfig appConfig) {
        jdbcTemplate = new JdbcTemplate(appConfig.dataSource());
    }

    @Override
    public List<Link> getAll() {
        List<Link> entities;
        try {
            entities = jdbcTemplate.query(SQL_GET_ALL, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            entities = new ArrayList<>();
        }
        return entities;
    }

    @Override
    public Link getById(Long id) {
        Link link;
        try {
            link = jdbcTemplate.queryForObject(SQL_GET_BY_LINKID, new Object[]{id}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            link = new Link();
        }
        return link;
    }

    @Override
    public List<Link> getByLiteratureId(Long literatureId) {
        List<Link> links;
        try {
            links = jdbcTemplate.query(SQL_GET_BY_LITERATUREID, new Object[]{literatureId}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            links = new ArrayList<>();
        }
        return links;
    }

    private Link mapRow(ResultSet resultSet, int rowNum) {
        Link link = new Link();
        try {
            link.setLinkId(resultSet.getLong(TablesAndColumns.LINKID));
            link.setLink(resultSet.getString(TablesAndColumns.LINK));
            link.setLiteratureId(resultSet.getLong(TablesAndColumns.LITERATUREID));
        } catch (SQLException e) {
        }
        return link;
    }
}
