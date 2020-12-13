package com.ramon.pereira.hermes.api.v1.dtos.request;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunicationRecipientCreateRequestDto {

    @Valid
    @NotNull
    private String name;

    @Valid
    @NotNull
    private String phone;

    @Valid
    @NotNull
    private String email;
}
