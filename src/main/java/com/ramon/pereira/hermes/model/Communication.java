package com.ramon.pereira.hermes.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "communications", schema = "hermes")
public class Communication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String message;

    @Column
    private Date sendDate;

    @Column
    private Date createdAt;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "communication")
    @JsonManagedReference
    private List<CommunicationChannel> channels;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "communication")
    @JsonManagedReference
    private List<CommunicationEvent> events;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "communication")
    @JsonManagedReference
    private List<CommunicationRecipient> recipients;

    @PrePersist
    protected void prePersist() {
        createdAt = new Date();
    }
}
