create procedure `test_statistics`()
begin
    select test.description, count(statisticid) as count, avg(correct) as avg
    from ditsdb.statistic
             join ditsdb.question on statistic.questionid = question.questionid
             join ditsdb.test on question.testid = test.testid
    group by test.description;
end;

create procedure `question_statistics`()
begin
    select description, count(statisticid) as count, avg(correct) as avg
    from ditsdb.question
             join ditsdb.statistic on question.questionid = statistic.questionid
    group by description;
end;

create procedure `user_statistics`()
begin
    select firstname, lastname, test.description, count(statisticid) as count, avg(correct) as avg
    from ditsdb.statistic
             join ditsdb.question on statistic.questionid = question.questionid
             join ditsdb.test on question.testid = test.testid
             join ditsdb.user on statistic.userid = user.userid
    group by firstname, lastname;
end;
