package z.ivan.service.user;

import org.springframework.stereotype.Service;
import z.ivan.dao.PersonalUserStatisticDao;
import z.ivan.dao.StatisticsDao;
import z.ivan.dao.UserDao;
import z.ivan.model.PersonalUserStatistic;
import z.ivan.model.UserStatistics;

import java.util.List;

@Service
public class PersonalStatisticServise {

    private PersonalUserStatisticDao personalUserStatisticDao;
    private UserDao userDao;

    public PersonalStatisticServise(PersonalUserStatisticDao personalUserStatisticDao, UserDao userDao) {
        this.personalUserStatisticDao = personalUserStatisticDao;
        this.userDao = userDao;
    }

    public List<PersonalUserStatistic> getPersonalUserStatistic() {
        return personalUserStatisticDao.getPersonalUserStatistic();
    }

}
