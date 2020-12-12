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
@Table(name = "communications_recipients", schema = "hermes")
public class CommunicationRecipient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference
    @JoinColumn(name = "recipient_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Recipient recipient;

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
