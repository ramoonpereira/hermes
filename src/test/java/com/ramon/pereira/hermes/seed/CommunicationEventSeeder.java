package com.ramon.pereira.hermes.seed;

import com.ramon.pereira.hermes.model.Communication;
import com.ramon.pereira.hermes.model.CommunicationEvent;
import com.ramon.pereira.hermes.model.Event;
import com.ramon.pereira.hermes.model.enEvent;
import lombok.NonNull;

import java.util.Date;

public class CommunicationEventSeeder extends SeederBase {

    public static CommunicationEvent communicationEventSeed(@NonNull final Integer id,@NonNull final enEvent event){
        return CommunicationEvent.builder()
                .id(id)
                .event(EventSeeder.eventSeed(id,event))
                .createdAt(new Date())
                .build();
    }

    public static CommunicationEvent communicationEventSeed(@NonNull final Integer id){
        return communicationEventSeed(id,enEvent.SCHEDULED);
    }
}
