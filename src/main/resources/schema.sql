DROP TABLE IF EXISTS EPLANNER_USER;

CREATE TABLE EPLANNER_USER (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      name VARCHAR2(250) NOT NULL,
                      email VARCHAR2(250) NOT NULL
);