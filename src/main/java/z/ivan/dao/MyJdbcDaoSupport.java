package z.ivan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

public class MyJdbcDaoSupport extends JdbcDaoSupport {

    @Autowired
    private DataSource dataSource;
    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }
}
