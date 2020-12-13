package com.ramon.pereira.hermes.api.v1.mapper;

import com.ramon.pereira.hermes.api.v1.dtos.request.CommunicationRecipientCreateRequestDto;
import com.ramon.pereira.hermes.api.v1.dtos.response.CommunicationRecipientResponseDto;
import com.ramon.pereira.hermes.model.CommunicationRecipient;
import com.ramon.pereira.hermes.model.Recipient;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class RecipientMapper {
    public Optional<CommunicationRecipientResponseDto> serializeRecipientToResponseDto(@NonNull final Optional<Recipient> recipient) {
        final Recipient model = recipient.get();
        return Optional.of(CommunicationRecipientResponseDto.builder()
                .id(model.getId())
                .email(model.getEmail())
                .phone(model.getPhone())
                .name(model.getName())
                .createdAt(model.getCreatedAt())
                .build());
    }

    public Optional<List<CommunicationRecipientResponseDto>> serializeRecipientListToResponseDto(@NonNull final Optional<Set<CommunicationRecipient>> communicationRecipients) {
        final var serializers = new ArrayList<CommunicationRecipientResponseDto>();

        communicationRecipients.ifPresent(t -> t.forEach(recipient -> {
            serializers.add(serializeRecipientToResponseDto(Optional.of(recipient.getRecipient())).get());
        }));

        return Optional.of(serializers);
    }

    public Optional<CommunicationRecipient> serializeRecipientRequestToModel(@NonNull final Optional<CommunicationRecipientCreateRequestDto> communicationRecipientCreateRequestDto) {
        final CommunicationRecipientCreateRequestDto model = communicationRecipientCreateRequestDto.get();
        return Optional.of(CommunicationRecipient.builder()
                .recipient(Recipient.builder()
                        .name(model.getName())
                        .email(model.getEmail())
                        .phone(model.getPhone())
                        .build())
                .build());
    }

    public Optional<Set<CommunicationRecipient>> serializeChannelRequestListToModel(@NonNull final Optional<List<CommunicationRecipientCreateRequestDto>> communicationRecipientCreateRequestDtos) {
        final var serializers = new ArrayList<CommunicationRecipient>();

        communicationRecipientCreateRequestDtos.ifPresent(t -> t.forEach(recipient -> {
            serializers.add(serializeRecipientRequestToModel(Optional.of(recipient)).get());
        }));

        return Optional.of(Set.copyOf(serializers));
    }
}
