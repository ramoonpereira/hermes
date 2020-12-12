package com.ramon.pereira.hermes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "communications_channels", schema = "hermes")
public class CommunicationChannel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference
    @JoinColumn(name = "channel_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Channel channel;

    @JsonBackReference
    @JoinColumn(name = "communication_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Communication communication;

    @Column
    private Date createdAt;

    @PrePersist
    protected void prePersist() {
        createdAt = new Date();
    }
}
