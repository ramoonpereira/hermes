CREATE TABLE hermes.communications (
  id INT NOT NULL AUTO_INCREMENT,
  message VARCHAR(8000) NOT NULL,
  send_date DATETIME NOT NULL,
  created_at DATETIME NOT NULL,
  PRIMARY KEY (id)
);