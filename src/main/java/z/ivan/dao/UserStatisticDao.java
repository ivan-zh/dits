package z.ivan.dao;

import z.ivan.model.PersonalUserStatistic;
import z.ivan.model.ResultUserStatistic;

import java.util.List;

public interface UserStatisticDao {

    List<PersonalUserStatistic> getPersonalUserStatistic();

    List<ResultUserStatistic> getResultUserStistic();
}
