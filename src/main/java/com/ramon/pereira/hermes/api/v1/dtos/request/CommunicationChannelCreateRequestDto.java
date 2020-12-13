package com.ramon.pereira.hermes.api.v1.dtos.request;

import com.ramon.pereira.hermes.model.enChannel;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunicationChannelCreateRequestDto {

    @Valid
    @NotNull
    private enChannel name;
}
