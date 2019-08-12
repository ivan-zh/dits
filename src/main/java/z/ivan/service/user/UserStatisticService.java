package z.ivan.service.user;

import org.springframework.stereotype.Service;
import z.ivan.dao.UserStatisticDao;
import z.ivan.model.PersonalUserStatistic;
import z.ivan.model.ResultUserStatistic;

import java.util.List;

@Service
public class UserStatisticService {
    private UserStatisticDao userStatisticDao;

    public UserStatisticService(UserStatisticDao userStatisticDao) {
        this.userStatisticDao = userStatisticDao;
    }

    public List<PersonalUserStatistic> getPersonalUserStatistic () {
        return userStatisticDao.getPersonalUserStatistic();
    }

    public List<ResultUserStatistic> getResultUserStatistic(){
        return userStatisticDao.getResultUserStistic();
    }
}
