create table `role`
(
    `roleid` int not null auto_increment,
    `user`   int,
    `tutor`  int,
    `admin`  int,
    primary key (`roleid`)
);

create table `user`
(
    `userid`    int not null auto_increment,
    `firstname` varchar(255),
    `lastname`  varchar(255),
    `login`     varchar(255),
    `password`  int,
    `roleid`    int not null,
    primary key (`userid`),
    foreign key (`roleid`) REFERENCES `role` (`roleid`)
    on delete cascade
);

create table `topic`
(
    `topicid`     int not null auto_increment,
    `description` varchar(231),
    `name`        varchar(231),
    primary key (`topicid`)
);

create table `test`
(
    `testid`      int not null auto_increment,
    `name`        varchar(231),
    `description` varchar(231),
    `topicid`     int not null,
    primary key (`testid`),
    foreign key (`topicid`) references `topic` (`topicid`)
    on delete cascade
);

create table `question`
(
    `questionid`  int not null auto_increment,
    `description` varchar(231),
    `testid`      int not null,
    primary key (`questionid`),
    foreign key (`testid`) references test (`testid`)
    on delete cascade
);

create table `answer`
(
    `answerid`    int not null auto_increment,
    `description` varchar(231),
    `correct`     boolean,
    `questionid`  int,
    primary key (`answerid`),
    foreign key (`questionid`) references `question` (`questionid`)
    on delete cascade
);


create table `statistic`
(
    `statisticid` int not null auto_increment,
    `date`        date,
    `correct`     boolean,
    `questionid`  int,
    `userid`      int,
    primary key (`statisticid`),
    foreign key (`questionid`) references `question` (`questionid`),
    foreign key (`userid`) references `user` (`userid`)
);

create table `literature`
(
    `literatureid` int not null auto_increment,
    `description`  varchar(231),
    `questionid`   int,
    primary key (`literatureid`),
    foreign key (`questionid`) references `question` (`questionid`)
);

create table `link`
(
    `linkid`       int not null auto_increment,
    `link`         varchar(231),
    `literatureid` int,
    primary key (`linkid`),
    foreign key (`literatureid`) references `literature` (`literatureid`)
);