
INSERT INTO EPLANNER_USER (id,name,email) VALUES
(1,'Aliko','topkek123@kekmail.com'),
(2,'Bill','32113topkek123@kekmail.com'),
(3,'Folrunsho','321topkek123@kekmail.com'),
(4,'BBBBBBBBBBBBBBB','xxxxtopkek123@kekmail.com'),
(5,'AAAAAAAAAAAAAA','123topkek123@kekmail.com');


INSERT INTO EPLANNER_TEAM (id,name) VALUES
(1,'TEAM 1'),
(2,'TEAM 2'),
(3,'TEAM 3'),
(4,'TEAM 4'),
(5,'TEAM 6');

INSERT INTO EPLANNER_TEAM_USERS (users_id,teams_id) VALUES
    (1,1),
    (2,1),
    (3,1),
    (1,2),
    (1,3),
    (1,4),
    (1,5);