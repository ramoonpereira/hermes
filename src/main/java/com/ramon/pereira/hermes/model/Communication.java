package com.ramon.pereira.hermes.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "communications", schema = "hermes")
@NamedEntityGraph(name = "graph.communication.detail",
        attributeNodes = {
                @NamedAttributeNode(value = "channels", subgraph = "channels"),
                @NamedAttributeNode(value = "events", subgraph = "events"),
                @NamedAttributeNode(value = "recipients", subgraph = "recipients")
        },
        subgraphs = {
                @NamedSubgraph(name = "channels", attributeNodes = @NamedAttributeNode("channel")),
                @NamedSubgraph(name = "events", attributeNodes = @NamedAttributeNode("event")),
                @NamedSubgraph(name = "recipients", attributeNodes = @NamedAttributeNode("recipient"))
        })
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
    private Set<CommunicationChannel> channels;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "communication")
    @JsonManagedReference
    private Set<CommunicationEvent> events;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "communication")
    @JsonManagedReference
    private Set<CommunicationRecipient> recipients;

    @PrePersist
    protected void prePersist() {
        createdAt = new Date();
    }
}
