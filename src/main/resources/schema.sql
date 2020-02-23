DROP TABLE IF EXISTS userEntity;

CREATE TABLE user (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      name VARCHAR2(250) NOT NULL,
                      email VARCHAR2(250) NOT NULL
);