CREATE TABLE author(
    id INT PRIMARY KEY,
    username VARCHAR(32) UNIQUE,
    fullname VARCHAR(64),
    password VARCHAR(96)
);
CREATE TABLE role(
    author_id INT,
    role VARCHAR(32),
    foreign key (author_id) references author(id)
);
CREATE TABLE short_message(
    id INT AUTO_INCREMENT PRIMARY KEY,
    author_id INT,
    posted_time TIMESTAMP,
    message_text VARCHAR(255),
    foreign key (author_id) references author(id)
);