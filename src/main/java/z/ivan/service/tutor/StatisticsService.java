package z.ivan.service.tutor;

import org.springframework.stereotype.Service;
import z.ivan.dao.StatisticsDao;
import z.ivan.dao.TestDao;
import z.ivan.dao.UserDao;
import z.ivan.dto.UserExtendedStatisticsDto;
import z.ivan.model.*;

import java.util.LinkedList;
import java.util.List;

@Service
public class StatisticsService {

    private StatisticsDao statisticsDao;
    private UserDao userDao;
    private TestDao testDao;

    public StatisticsService(StatisticsDao statisticsDao, UserDao userDao) {
        this.statisticsDao = statisticsDao;
        this.userDao = userDao;
    }

    public List<TestStatistics> getTestStatistics() {
        return statisticsDao.getTestStatistics();
    }

    public List<QuestionStatistics> getQuestionStatistics() {
        return statisticsDao.getQuestionStatistics();
    }

    public List<UserStatistics> getUserStatistics() {
        return statisticsDao.getUserStatistics();
    }

    public List<UserExtendedStatisticsDto> getUserExtendedStatistics() {
        List<UserExtendedStatisticsDto> list = new LinkedList<>();
        for (User u : userDao.getAll()) {
            UserExtendedStatisticsDto e = new UserExtendedStatisticsDto();
            e.setUser(u);
            for (Test t : testDao.getAll()) {
                //statisticsDao.
            }
            list.add(e);
        }
        return null;
    }
}
