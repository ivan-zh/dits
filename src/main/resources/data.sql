-- Table `role`
insert into role (`admin`) values (1);
insert into role (`tutor`) values (1);
insert into role (`user`) values (1);

-- Table `user`
INSERT INTO ditsdb.user (userid, firstname, lastname, login, password, roleid)
VALUES (1, 'Ivan', 'Zhukouski', 'ivan', 105, 1);

INSERT INTO ditsdb.user (userid, firstname, lastname, login, password, roleid)
 VALUES (2, 'Alexey', 'Katomakhin', 'alex', 49, 2);

INSERT INTO ditsdb.user (userid, firstname, lastname, login, password, roleid)
VALUES (3, 'Artiom', 'Gavrilkov', 'artiom-g', 97, 2);

INSERT INTO ditsdb.user (userid, firstname, lastname, login, password, roleid)
VALUES (4, 'Katya', 'Paulich', 'katya', 107, 3);

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
