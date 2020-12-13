package com.ramon.pereira.hermes.api.v1.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunicationRecipientResponseDto {

    private Integer id;

    private String name;

    private String phone;

    private String email;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date createdAt;
}
