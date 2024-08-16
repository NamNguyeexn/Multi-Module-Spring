CREATE TABLE human (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    dob DATE,
    address TEXT,
    phone TEXT
);
CREATE TABLE user (
      id INT PRIMARY KEY AUTO_INCREMENT,
      humanid INT NOT NULL,
      employeeCode VARCHAR(255),
      username VARCHAR(255) NOT NULL UNIQUE,
      password VARCHAR(255) NOT NULL,
      role ENUM('ADMIN', 'USER'),
      FOREIGN KEY (humanid) REFERENCES human(id)
);
CREATE TABLE workhour (
      id INT PRIMARY KEY AUTO_INCREMENT,
      start DATETIME NOT NULL,
      end DATETIME NOT NULL,
      userid INT NOT NULL,
      status ENUM('DONE', 'NOTDONE'),
      note VARCHAR(255),
      FOREIGN KEY (userid) REFERENCES user(id)
);