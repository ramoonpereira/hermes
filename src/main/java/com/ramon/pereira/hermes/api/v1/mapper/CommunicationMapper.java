package com.ramon.pereira.hermes.api.v1.mapper;

import com.ramon.pereira.hermes.api.v1.dtos.request.CommunicationCreateRequestDto;
import com.ramon.pereira.hermes.api.v1.dtos.response.CommunicationResponseDto;
import com.ramon.pereira.hermes.model.Communication;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommunicationMapper {

    @Autowired
    private ChannelMapper channelMapper;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private RecipientMapper recipientMapper;

    public Optional<CommunicationResponseDto> serializeToResponseDto(@NonNull final Optional<Communication> communication) {
        final Communication model = communication.get();
        final var channels = channelMapper.serializeChannelListToResponseDto(Optional.of(model.getChannels()));
        final var events = eventMapper.serializeEventListToResponseDto(Optional.of(model.getEvents()));
        final var recipients = recipientMapper.serializeRecipientListToResponseDto(Optional.of(model.getRecipients()));
        return Optional.of(CommunicationResponseDto.builder()
                .id(model.getId())
                .message(model.getMessage())
                .createdAt(model.getCreatedAt())
                .sendDate(model.getSendDate())
                .channels(channels.get())
                .events(events.get())
                .recipients(recipients.get())
                .build());
    }

    public Optional<Communication> serializeRequestCreateToModel(@NonNull final Optional<CommunicationCreateRequestDto> communicationCreateRequestDto) {
        final var dto = communicationCreateRequestDto.get();
        final var channels = channelMapper.serializeChannelRequestListToModel(Optional.of(communicationCreateRequestDto.get().getChannels()));
        final var recipients = recipientMapper.serializeChannelRequestListToModel(Optional.of(communicationCreateRequestDto.get().getRecipients()));
        return Optional.of(Communication.builder()
                .recipients(recipients.get())
                .channels(channels.get())
                .sendDate(dto.getSendDate())
                .message(dto.getMessage())
                .build());
    }
}
