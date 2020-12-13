package com.ramon.pereira.hermes.api.v1.mapper;

import com.ramon.pereira.hermes.api.v1.dtos.response.CommunicationEventResponseDto;
import com.ramon.pereira.hermes.model.CommunicationEvent;
import com.ramon.pereira.hermes.model.Event;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EventMapper {
    public Optional<CommunicationEventResponseDto> serializeEventToResponseDto(@NonNull final Optional<Event> event) {
        final Event model = event.get();
        return Optional.of(CommunicationEventResponseDto.builder()
                .id(model.getId())
                .name(model.getName())
                .createdAt(model.getCreatedAt())
                .build());
    }

    public Optional<List<CommunicationEventResponseDto>> serializeEventListToResponseDto(@NonNull final Optional<List<CommunicationEvent>> communicationEvents) {
        final var serializers = new ArrayList<CommunicationEventResponseDto>();

        communicationEvents.ifPresent(t -> t.forEach(event -> {
            serializers.add(serializeEventToResponseDto(Optional.of(event.getEvent())).get());
        }));

        return Optional.of(serializers);
    }
}
