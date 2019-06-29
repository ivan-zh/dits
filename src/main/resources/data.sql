-- Table `role`
insert into role (`admin`) values (1);
insert into role (`tutor`) values (1);
insert into role (`user`) values (1);

-- Table `user`
insert into user (`firstname`, `lastname`, `login`, `password`, `roleid`)
VALUES ('Ivan', 'Zhukouski', 'admin', 1, 1);

insert into user (`firstname`, `lastname`, `login`, `password`, `roleid`)
VALUES ('Alexey', 'Katomakhin', 'alex', 1, 2);

insert into user (`firstname`, `lastname`, `login`, `password`, `roleid`)
VALUES ('Artiom', 'Gavrilkov', 'artiom-g', 1, 2);

-- Table `topic`
insert into topic (description, name)
VALUES ('Java core', 'jcore');


-- Table `test`
insert into test (name, description, topicid)
values ('arrays', 'Arrays and collections', 1);

insert into test (name, description, topicid)
values ('primitives', 'Primitives', 1);


-- Table `question`
insert into question (description, testid)
VALUES ('How to define an array?', 1);
insert into question (description, testid)
VALUES ('What is the index of the fitst element of an array?', 1);
insert into question (description, testid)
VALUES ('How many elements contains this array? int[][][] nums = new int[3][2][3];', 1);


-- Table `literature`
insert into literature (description, questionid)
values ('The Complete Reference: Java by Herbert Schildt', 1);

insert into literature (description, questionid)
values ('Thinking In Java 4th Edition - Bruce Eckel', 2);


-- Table `link`
insert into link (link, literatureid)
values ('http://developer.alexanderklimov.ru/android/java/array.php#def', 1);

insert into link (link, literatureid)
values ('https://www.rulit.me/books/filosofiya-java-read-180907-13.html', 2);


-- Table `statistic`
insert into statistic (date, correct, questionid, userid)
values ('2019-01-01', 0, 1, 1);
insert into statistic (date, correct, questionid, userid)
values ('2019-01-02', 1, 1, 1);
insert into statistic (date, correct, questionid, userid)
values ('2019-01-02', 0, 2, 1);
insert into statistic (date, correct, questionid, userid)
values ('2019-01-02', 1, 2, 1);
insert into statistic (date, correct, questionid, userid)
values ('2019-01-03', 1, 3, 1);

insert into statistic (date, correct, questionid, userid)
values ('2019-01-01', 0, 1, 2);
insert into statistic (date, correct, questionid, userid)
values ('2019-01-02', 1, 1, 2);
insert into statistic (date, correct, questionid, userid)
values ('2019-01-02', 0, 2, 2);
insert into statistic (date, correct, questionid, userid)
values ('2019-01-02', 1, 2, 2);
insert into statistic (date, correct, questionid, userid)
values ('2019-01-03', 1, 3, 2);
