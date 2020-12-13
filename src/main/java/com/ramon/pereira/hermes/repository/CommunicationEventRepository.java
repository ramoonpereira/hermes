package com.ramon.pereira.hermes.repository;

import com.ramon.pereira.hermes.model.CommunicationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationEventRepository extends JpaRepository<CommunicationEvent, Integer> {
}
