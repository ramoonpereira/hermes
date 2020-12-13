package com.ramon.pereira.hermes.api.v1.dtos.request;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class CommunicationCreateRequestDto {

    @Valid
    @NotNull
    private String message;

    @Valid
    @NotNull
    private Date sendDate;

    @Valid
    @NotNull
    private List<CommunicationRecipientCreateRequestDto> recipients;

    @Valid
    @NotNull
    private List<CommunicationChannelCreateRequestDto> channels;
}
