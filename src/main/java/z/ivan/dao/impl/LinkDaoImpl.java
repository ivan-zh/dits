package z.ivan.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import z.ivan.dao.LinkDao;
import z.ivan.dao.impl.constants.TablesAndColumns;
import z.ivan.dao.settings.MyJdbcDaoSupport;
import z.ivan.model.Link;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkDaoImpl extends MyJdbcDaoSupport implements LinkDao {

    private static final String SQL_GET_ALL = "SELECT * FROM ditsdb.link";
    private static final String SQL_GET_BY_LINKID = "SELECT * FROM ditsdb.link WHERE " + TablesAndColumns.LINKID + " = ?";
    private static final String SQL_GET_BY_LITERATUREID = "SELECT * FROM ditsdb.link WHERE " + TablesAndColumns.LITERATUREID + " = ?";

    @Override
    public List<Link> getAll() {
        List<Link> entities;
        try {
            entities = this.getJdbcTemplate().query(SQL_GET_ALL, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            entities = new ArrayList<>();
        }
        return entities;
    }

    @Override
    public Link getById(Long id) {
        Link link;
        try {
            link = this.getJdbcTemplate().queryForObject(SQL_GET_BY_LINKID, new Object[]{id}, this::mapRow);
        } catch (NullPointerException | DataAccessException e) {
            link = new Link();
        }
        return link;
    }

    @Override
    public List<Link> getByLiteratureId(Long literatureId) {
        List<Link> links;
        try {
            links = this.getJdbcTemplate().query(SQL_GET_BY_LITERATUREID, new Object[]{literatureId}, this::mapRow);
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
