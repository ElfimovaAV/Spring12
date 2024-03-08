create table notes (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         title VARCHAR(50) NOT NULL,
                         description VARCHAR(100) NOT NULL,
                         create_time timestamp
);