CREATE TABLE hermes.communications_recipients (
  id INT NOT NULL AUTO_INCREMENT,
  recipient_id INT NOT NULL,
  communication_id INT NOT NULL,
  created_at DATETIME NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_COMMUNICATIONS_RECIPIENTS_RECIPIENT FOREIGN KEY (recipient_id) REFERENCES recipients (id),
  CONSTRAINT FK_COMMUNICATIONS_RECIPIENTS_COMMUNICATION FOREIGN KEY (communication_id) REFERENCES communications (id)
);