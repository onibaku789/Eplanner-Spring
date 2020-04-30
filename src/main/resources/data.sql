
INSERT INTO EPLANNER_USER (id,name,email) VALUES
(1,'Teszt Elek','teszt.email1@gmail.com'),
(2,'Elek Teszt','teszt.email2@gmail.com'),
(3,'Elek Test','teszt.email3@gmail.com'),
(4,'Tzset Elek ','teszt.email4@gmail.com'),
(5,'Elek Tset','teszt.email5@gmail.com');


INSERT INTO EPLANNER_TEAM (id,name) VALUES
(1,'TEAM 1'),
(2,'TEAM 2'),
(3,'TEAM 3'),
(4,'TEAM 4'),
(5,'TEAM 5');

INSERT INTO EPLANNER_TEAM_USERS (users_id,teams_id) VALUES
    (1,1),
    (2,1),
    (3,1),
    (1,2),
    (5,3),
    (4,4),
    (1,5);
INSERT INTO eplanner_badges (id, badge)VALUES
(1,'MVP'),
(2,'SCHOLAR'),
(3,'UNYIELDING');

INSERT INTO eplanner_badges_user (badges_id,user_id ) VALUES
(1,1),
(2,2),
(3,3);

INSERT INTO eplanner_time_table (id,end, start,team_id,user_id) VALUES
(1,'2022-03-23 13:10:00','2022-03-23 15:00:00',1,1);


