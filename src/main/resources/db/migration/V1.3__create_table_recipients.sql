CREATE TABLE hermes.recipients (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(300) NOT NULL,
  email VARCHAR(300) NOT NULL,
  phone VARCHAR(300) NOT NULL,
  created_at DATETIME NOT NULL,
  PRIMARY KEY (id)
);