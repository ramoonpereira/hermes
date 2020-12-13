package com.ramon.pereira.hermes.repository;

import com.ramon.pereira.hermes.model.Communication;
import lombok.NonNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommunicationRepository  extends JpaRepository<Communication, Integer> {
    @EntityGraph(value = "graph.communication.detail", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Communication> findById(@NonNull final Integer id);
}
