package com.ramon.pereira.hermes.repository;

import com.ramon.pereira.hermes.model.Channel;
import com.ramon.pereira.hermes.model.Event;
import com.ramon.pereira.hermes.model.enEvent;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    Optional<Event> findByName(@NonNull final enEvent name);
}
