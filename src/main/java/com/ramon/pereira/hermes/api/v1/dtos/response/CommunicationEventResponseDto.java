package com.ramon.pereira.hermes.api.v1.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ramon.pereira.hermes.model.enEvent;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunicationEventResponseDto {

    private Integer id;

    @Enumerated(EnumType.STRING)
    private enEvent name;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date createdAt;
}
