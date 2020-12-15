package com.ramon.pereira.hermes.seed;

import com.ramon.pereira.hermes.model.Communication;
import com.ramon.pereira.hermes.model.Event;
import com.ramon.pereira.hermes.model.enEvent;
import lombok.NonNull;

import java.util.Date;

public class EventSeeder extends SeederBase {
    public static Event eventSeed(@NonNull final Integer id, @NonNull final enEvent event) {
        return Event.builder()
                .id(id)
                .name(event)
                .createdAt(new Date())
                .build();
    }
}
