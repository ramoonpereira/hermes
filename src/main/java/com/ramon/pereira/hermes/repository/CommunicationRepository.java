package com.ramon.pereira.hermes.repository;

import com.ramon.pereira.hermes.model.Communication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationRepository  extends JpaRepository<Communication, Integer> {
}
