package com.ramon.pereira.hermes.api.v1.dtos.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ramon.pereira.hermes.model.enEvent;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class CommunicationResponseDto {

    private Integer id;

    private String message;

    @Enumerated(EnumType.STRING)
    private enEvent status;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date sendDate;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date createdAt;

    private List<CommunicationChannelResponseDto> channels;

    private List<CommunicationEventResponseDto> events;

    private List<CommunicationRecipientResponseDto> recipients;

}
