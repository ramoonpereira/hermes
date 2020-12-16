package com.ramon.pereira.hermes.seed;

import com.ramon.pereira.hermes.model.Recipient;
import lombok.NonNull;

import java.util.Date;

public class RecipientSeeder  extends SeederBase{
    public static Recipient recipientSeed(@NonNull final Integer id) {
        return Recipient.builder()
                .id(id)
                .name(faker().bothify("##########"))
                .phone(faker().bothify("##########"))
                .email(faker().bothify("##########"))
                .createdAt(new Date())
                .build();
    }
}
