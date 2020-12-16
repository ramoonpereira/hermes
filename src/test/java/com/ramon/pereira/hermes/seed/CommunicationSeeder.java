package com.ramon.pereira.hermes.seed;

import com.ramon.pereira.hermes.model.Communication;
import com.ramon.pereira.hermes.model.enEvent;
import lombok.NonNull;

import java.util.Date;
import java.util.Set;

public class CommunicationSeeder extends SeederBase {

    public static Communication communicationSeed(@NonNull final Integer id , @NonNull final enEvent event){
        return Communication.builder()
                .id(id)
                .message(faker().bothify("##########"))
                .events(Set.of(CommunicationEventSeeder.communicationEventSeed(id,event)))
                .channels(Set.of(CommunicationChannelSeeder.communicationChannelSeed(id)))
                .recipients(Set.of(CommunicationRecipientSeeder.communicationRecipientSeed(id)))
                .sendDate(new Date())
                .createdAt(new Date())
                .build();
    }
    public static Communication communicationSeed(@NonNull final Integer id){
        return communicationSeed(id, enEvent.SCHEDULED);
    }

}
