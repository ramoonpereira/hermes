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

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "communications_channels",
            joinColumns = @JoinColumn(name = "communication_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id"))
    @JsonManagedReference
    private List<Channel> channels;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "communications_events",
            joinColumns = @JoinColumn(name = "communication_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    @JsonManagedReference
    private List<Event> events;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "communications_recipients",
            joinColumns = @JoinColumn(name = "communication_id"),
            inverseJoinColumns = @JoinColumn(name = "recipient_id"))
    @JsonManagedReference
    private List<Recipient> recipients;

    @PrePersist
    protected void prePersist() {
        createdAt = new Date();
    }
}
