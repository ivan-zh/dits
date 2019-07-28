package z.ivan.service.tutor;

import org.springframework.stereotype.Service;
import z.ivan.dao.StatisticsDao;
import z.ivan.model.QuestionStatistics;
import z.ivan.model.TestStatistics;
import z.ivan.model.UserStatistics;

import java.util.List;

@Service
public class StatisticsService {

    private StatisticsDao statisticsDao;

    public StatisticsService(StatisticsDao statisticsDao) {
        this.statisticsDao = statisticsDao;
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
}
