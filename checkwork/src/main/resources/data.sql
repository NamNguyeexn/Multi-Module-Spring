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
      email VARCHAR(255) NOT NULL UNIQUE,
      department ENUM('SALES', 'PRODUCTION', 'HUMANS'),
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
CREATE TABLE appointment (
         id INT PRIMARY KEY AUTO_INCREMENT,
         name VARCHAR(255) NOT NULL,
         hostid INT NOT NULL,
         joinid TEXT NOT NULL,
         start DATETIME NOT NULL,
         end DATETIME NOT NULL,
         detail TEXT NOT NULL,
        type ENUM('OFFLINE', 'ONLINE'),
        room VARCHAR(255),
         info TEXT NOT NULL
);
ALTER
CREATE TABLE room (
      id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(255) NOT NULL,
      capacity INT NOT NULL,
      status BOOLEAN NOT NULL
);
INSERT INTO room (name, capacity, open)
VALUES
    ('Connection', 5, true),
    ('Incubation', 10, true),
    ('Sharing', 10, true),
    ('Sandy Shore', 15, true),
    ('Waterfall', 15, true),
    ('Misty Forest', 20, true),
    ('Mountain Peak', 20, true),
    ('Lotus Pond', 20, true);
