package z.ivan.dao.impl;

import org.springframework.stereotype.Repository;
import z.ivan.dao.LinkDao;
import z.ivan.model.Link;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinkDaoImpl extends CrudDaoImpl<Link> implements LinkDao {

    private static final String TABLE_NAME = "ditsdb.link";
    private static final String COLUMN_LINK_ID = "linkid";
    private static final String COLUMN_LINK = "link";
    private static final String COLUMN_LITERATURE_ID = "literatureid";

    public LinkDaoImpl() {
        super(TABLE_NAME, COLUMN_LINK_ID, LinkDaoImpl::mapRow, LinkDaoImpl::mapData);
    }

    @Override
    public List<Link> getByLiteratureId(Long literatureId) {
        return getByColumn(COLUMN_LITERATURE_ID, literatureId);
    }

    private static Map<String, Object> mapData(Link link) {
        Map<String, Object> map = new HashMap<>();
        map.put(COLUMN_LINK_ID, link.getLinkId());
        map.put(COLUMN_LINK, link.getLink());
        map.put(COLUMN_LITERATURE_ID, link.getLiteratureId());
        return map;
    }

    private static Link mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Link link = new Link();
        link.setLinkId(resultSet.getLong(COLUMN_LINK_ID));
        link.setLink(resultSet.getString(COLUMN_LINK));
        link.setLiteratureId(resultSet.getLong(COLUMN_LITERATURE_ID));
        return link;
    }
}
