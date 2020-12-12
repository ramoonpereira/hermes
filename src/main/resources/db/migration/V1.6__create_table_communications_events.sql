CREATE TABLE hermes.communications_events (
  id INT NOT NULL AUTO_INCREMENT,
  event_id INT NOT NULL,
  communication_id INT NOT NULL,
  created_at DATETIME NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_COMMUNICATIONS_EVENTS_EVENT FOREIGN KEY (event_id) REFERENCES events (id),
  CONSTRAINT FK_COMMUNICATIONS_EVENTS_COMMUNICATION FOREIGN KEY (communication_id) REFERENCES communications (id)
);