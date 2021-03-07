CREATE TABLE SONG (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(400) NOT NULL,
                      author VARCHAR(400) NOT NULL,
                      album VARCHAR(400) NOT NULL,
                      category VARCHAR(400) NOT NULL,
                      votes BIGINT
);