package com.ramon.pereira.hermes.repository;

import com.ramon.pereira.hermes.model.Recipient;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Integer> {
    Optional<Recipient> findOneByEmailOrPhone(@NonNull final String email,@NonNull final String phone);
}
