package com.ramon.pereira.hermes.repository;

import com.ramon.pereira.hermes.model.Channel;
import com.ramon.pereira.hermes.model.enChannel;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {
    Optional<Channel> findByName(@NonNull final enChannel name);
}
