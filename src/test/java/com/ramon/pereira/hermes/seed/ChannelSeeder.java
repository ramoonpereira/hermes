package com.ramon.pereira.hermes.seed;

import com.ramon.pereira.hermes.model.Channel;
import com.ramon.pereira.hermes.model.enChannel;
import lombok.NonNull;

import java.util.Date;

public class ChannelSeeder extends SeederBase {
    public static Channel channelSeed(@NonNull final Integer id, @NonNull final enChannel channel) {
        return Channel.builder()
                .id(id)
                .name(channel)
                .createdAt(new Date())
                .build();
    }
}
