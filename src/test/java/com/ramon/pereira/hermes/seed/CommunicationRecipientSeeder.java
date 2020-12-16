package com.ramon.pereira.hermes.seed;

import com.ramon.pereira.hermes.model.CommunicationRecipient;
import com.ramon.pereira.hermes.model.Recipient;
import lombok.NonNull;

import java.util.Date;

public class CommunicationRecipientSeeder extends SeederBase {
    public static CommunicationRecipient communicationRecipientSeed(@NonNull final Integer id){
        return CommunicationRecipient.builder()
                .id(id)
                .recipient(Recipient.builder()
                        .email(faker().bothify("##########"))
                        .phone(faker().bothify("##########"))
                        .name(faker().bothify("##########"))
                        .build())
                .createdAt(new Date())
                .build();
    }
}
