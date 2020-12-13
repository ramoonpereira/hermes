package com.ramon.pereira.hermes.api.v1.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ramon.pereira.hermes.model.enChannel;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunicationChannelResponseDto {

    private Integer id;

    @Enumerated(EnumType.STRING)
    private enChannel name;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date createdAt;
}
