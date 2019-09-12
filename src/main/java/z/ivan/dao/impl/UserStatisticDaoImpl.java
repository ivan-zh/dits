package z.ivan.dao.impl;

import org.springframework.stereotype.Repository;
import z.ivan.dao.UserStatisticDao;
import z.ivan.dao.settings.MyJdbcDaoSupport;
import z.ivan.model.PersonalUserStatistic;
import z.ivan.model.ResultUserStatistic;

import java.util.List;

@Repository
public class UserStatisticDaoImpl extends MyJdbcDaoSupport implements UserStatisticDao {

    @Override
    public List<PersonalUserStatistic> getPersonalUserStatistic() {
        return null;
    }

    @Override
    public List<ResultUserStatistic> getResultUserStistic() {
        return null;
    }
}
