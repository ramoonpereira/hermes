package com.ramon.pereira.hermes.repository;

import com.ramon.pereira.hermes.model.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Integer> {
}
