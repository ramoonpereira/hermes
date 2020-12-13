package com.ramon.pereira.hermes.api.v1.mapper;

import com.ramon.pereira.hermes.api.v1.dtos.request.CommunicationChannelCreateRequestDto;
import com.ramon.pereira.hermes.api.v1.dtos.response.CommunicationChannelResponseDto;
import com.ramon.pereira.hermes.model.Channel;
import com.ramon.pereira.hermes.model.CommunicationChannel;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ChannelMapper {
    public Optional<CommunicationChannelResponseDto> serializeChannelToResponseDto(@NonNull final Optional<Channel> channel) {
        final Channel model = channel.get();
        return Optional.of(CommunicationChannelResponseDto.builder()
                .id(model.getId())
                .name(model.getName())
                .createdAt(model.getCreatedAt())
                .build());
    }

    public Optional<List<CommunicationChannelResponseDto>> serializeChannelListToResponseDto(@NonNull final Optional<List<CommunicationChannel>> communicationChannels) {
        final var serializers = new ArrayList<CommunicationChannelResponseDto>();

        communicationChannels.ifPresent(t -> t.forEach(channel -> {
            serializers.add(serializeChannelToResponseDto(Optional.of(channel.getChannel())).get());
        }));

        return Optional.of(serializers);
    }

    public Optional<CommunicationChannel> serializeChannelRequestToModel(@NonNull final Optional<CommunicationChannelCreateRequestDto> channel) {
        final CommunicationChannelCreateRequestDto model = channel.get();
        return Optional.of(CommunicationChannel.builder()
                .channel(Channel.builder()
                        .name(model.getName())
                        .build())
                .build());
    }

    public Optional<List<CommunicationChannel>> serializeChannelRequestListToModel(@NonNull final Optional<List<CommunicationChannelCreateRequestDto>> communicationChannelCreateRequestDtos) {
        final var serializers = new ArrayList<CommunicationChannel>();

        communicationChannelCreateRequestDtos.ifPresent(t -> t.forEach(channel -> {
            serializers.add(serializeChannelRequestToModel(Optional.of(channel)).get());
        }));

        return Optional.of(serializers);
    }
}
