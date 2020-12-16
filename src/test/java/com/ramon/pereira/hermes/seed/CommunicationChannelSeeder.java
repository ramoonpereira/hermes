package com.ramon.pereira.hermes.seed;

import com.ramon.pereira.hermes.model.Channel;
import com.ramon.pereira.hermes.model.CommunicationChannel;
import com.ramon.pereira.hermes.model.enChannel;
import lombok.NonNull;

import java.util.Date;

public class CommunicationChannelSeeder  extends SeederBase  {

    public static CommunicationChannel communicationChannelSeed(@NonNull final Integer id){
        return CommunicationChannel.builder()
                .id(id)
                .channel(Channel.builder()
                        .name(enChannel.WHATSAPP)
                        .build())
                .createdAt(new Date())
                .build();
    }
}
