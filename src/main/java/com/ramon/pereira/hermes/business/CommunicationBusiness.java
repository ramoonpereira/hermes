package com.ramon.pereira.hermes.business;

import com.ramon.pereira.hermes.model.Communication;
import lombok.NonNull;

import java.util.Optional;

public interface CommunicationBusiness {

    Optional<Communication> create (@NonNull Communication communication);

    Optional<Communication> remove (@NonNull Integer id);
}
