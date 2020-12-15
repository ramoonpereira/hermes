package com.ramon.pereira.hermes.seed;

import com.ramon.pereira.hermes.model.Communication;
import lombok.NonNull;

import java.util.Date;

public class CommunicationSeeder extends SeederBase {

    public static Communication communicationSeed(@NonNull final Integer id){
        return Communication.builder()
                .id(id)
                .message(faker().bothify("##########"))
                .sendDate(new Date())
                .createdAt(new Date())
                .build();
    }

}
