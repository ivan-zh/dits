package z.ivan.dao;

import z.ivan.model.QuestionStatistics;
import z.ivan.model.TestStatistics;
import z.ivan.model.UserStatistics;

import java.util.List;

public interface StatisticsDao {
    List<TestStatistics> getTestStatistics();

    List<QuestionStatistics> getQuestionStatistics();

    List<UserStatistics> getUserStatistics();
}
